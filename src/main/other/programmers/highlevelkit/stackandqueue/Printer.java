package other.programmers.stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        List<Document> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Document(i, priorities[i]));
        }

        int result = 0;

        while (!list.isEmpty()) {
            Document document = list.remove(0);
            System.out.println(document);
            if (checkSize(list, document)) {
                list.add(document);
                continue;
            } else {
                result++;
            }

            if(document.location == location)
                return result;
        }
        return result;
    }

    static boolean checkSize(List<Document> list, Document document) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (list.get(i).priority > document.priority)
                return true;
        }
        return false;
    }

    static class Document {
        private int location;
        private int priority;

        public Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "location=" + location +
                    ", priority=" + priority +
                    '}';
        }
    }

}