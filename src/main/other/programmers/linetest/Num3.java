package main.other.programmers.linetest;

import java.util.*;

public class Num3 {
    public static void main(String[] args) {
        String a = "6\n" +
                "id name occupation\n" +
                "5 Brown Accountant\n" +
                "2 Cony Programmer\n" +
                "3 Sally Doctor\n" +
                "1 James Singer\n" +
                "4 Moon Dancer\n" +
                "7\n" +
                "id city zip\n" +
                "2 Seoul 10008\n" +
                "7 Busan 40002\n" +
                "5 Gwangju 20009\n" +
                "6 Daegu 30008\n" +
                "3 Seoul 40005\n" +
                "1 Seoul 50006";

        String[] values = a.split("\\n");
        int t1 = Integer.parseInt(values[0]);
        int t2 = Integer.parseInt(values[t1 + 1]);

        Table table1 = makeTable(values, 1, 1 + t1);
        Table table2 = makeTable(values, t1 + 2, t1 + 2 + t2);

        Table joinTable = table1.join(table2);

        System.out.println(joinTable);
    }

    private static Table makeTable(String[] values, int start, int last) {
        Table table = new Table();
        for (int i = start; i < last; i++) {
            String[] cols = values[i].split(" ");
            if (i == start) {
                table.addHeader(cols);
            } else {
                table.addRow(cols);
            }
        }
        return table;
    }


    static class Table {
        List<String> header;
        Map<Integer, Row> rows;

        public Table() {
            this.header = new ArrayList<>();
            this.rows = new HashMap<>();
        }

        public void addHeader(String[] cols) {
            for (String col : cols) {
                this.header.add(col);
            }
        }

        public void addRow(String[] cols) {
            int id = Integer.parseInt(cols[0]);
            Row row = new Row(id);
            for (int i = 1; i < cols.length; i++) {
                row.addValue(cols[i]);
            }
            this.rows.put(id, row);
        }


        public Table join(Table other) {
            Table newTable = new Table();
            newTable.addHeader(headerJoin(other));
            rowJoin(other, newTable.header.size(), newTable);

            return newTable;
        }

        private void rowJoin(Table other, int size, Table newTable) {
            Map<Integer, Row> otherRows = other.rows;
            for (Integer integer : rows.keySet()) {
                String[] rows;
                if (otherRows.containsKey(integer)) {
                    rows = this.rows.get(integer).joinRow(otherRows.get(integer), size);
                } else {
                    rows = this.rows.get(integer).makeRow(size);
                }
                newTable.addRow(rows);
            }
        }

        private String[] headerJoin(Table other) {
            int total = this.header.size() + other.header.size() - 1;
            String[] newheaders = new String[total];
            for (int i = 0; i < this.header.size(); i++) {
                newheaders[i] = this.header.get(i);
            }

            int o = 1;
            for (int i = this.header.size(); i < total; i++) {
                newheaders[i] = other.header.get(o);
                o++;
            }
            return newheaders;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(headerToString() + "\n");

            for (Row value : rows.values()) {
                sb.append(value + "\n");
            }

            return sb.toString();
        }

        private String headerToString() {
            StringBuffer sb = new StringBuffer();
            for (String s : header) {
                sb.append(s + " ");
            }
            return sb.toString();
        }
    }

    static class Row {
        int id;
        List<String> values;

        public Row(int id) {
            this.id = id;
            values = new ArrayList<>();
        }

        public void addValue(String col) {
            this.values.add(col);
        }


        public String[] joinRow(Row row, int size) {
            String[] newRows = new String[size];
            int idx = 1;
            newRows[0] = String.valueOf(this.id);
            while(!this.values.isEmpty()) {
                newRows[idx++] = this.values.remove(0);
            }

            while(!row.values.isEmpty()) {
                newRows[idx++] = row.values.remove(0);
            }

            return newRows;
        }

        public String[] makeRow(int size) {
            String[] newRows = new String[size];
            newRows[0] = String.valueOf(this.id);
            for (int i = 1; i < size; i++) {
                if (i >= values.size())
                    newRows[i] = "NULL";
                else
                    newRows[i] = values.get(i);
            }
            return newRows;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(this.id + " ");
            for (String value : values) {
                sb.append(value + " ");
            }
            return sb.toString();
        }
    }
}
