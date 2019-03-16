package main.other.programmers.highlevelkit.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelPath {
    static List<AblePath> paths = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String answer[] = solution(tickets);

        for (String s : answer) {
            System.out.println(s);
        }
    }

    static class Ticket {
        private String start;
        private String last;

        public Ticket(String[] ticket) {
            this.start = ticket[0];
            this.last = ticket[1];
        }

        public boolean isTravel(Ticket ticket) {
            return this.last.equals(ticket.start);
        }

        public boolean isICN() {
            return this.start.equals("ICN");
        }
    }

    static class AblePath implements Comparable<AblePath> {
        String[] path;

        AblePath(List<Integer> visited, List<Ticket> ticketList) {
            this.path = new String[ticketList.size() + 1];

            for (int i = 0; i < ticketList.size(); i++) {
                if (i == (ticketList.size() - 1)) {
                    Ticket ticket = ticketList.get(visited.get(i));
                    this.path[i] = ticket.start;
                    this.path[i + 1] = ticket.last;
                } else {
                    this.path[i] = ticketList.get(visited.get(i)).start;
                }
            }
        }

        public String[] getPath() {
            return path;
        }

        @Override
        public int compareTo(AblePath o) {
            for (int i = 0; i < this.path.length; i++) {
                if (this.path[i].compareTo(o.path[i]) > 0)
                    return 1;
                if (this.path[i].compareTo(o.path[i]) < 0)
                    return -1;
            }
            return 0;
        }
    }

    public static String[] solution(String[][] tickets) {
        List<Ticket> ticketList = new ArrayList<>();

        for (String[] ticket : tickets) {
            ticketList.add(new Ticket(ticket));
        }

        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).isICN()) {
                ArrayList<Integer> visited = new ArrayList<>();
                visited.add(i);
                travel(i, ticketList, visited);
            }
        }

        Collections.sort(paths);
        return paths.get(0).getPath();
    }

    private static void travel(int current, List<Ticket> ticketList, ArrayList<Integer> visited) {
        if (visited.size() == ticketList.size()) {
            paths.add(new AblePath(visited, ticketList));
            return;
        }

        for (int i = 0; i < ticketList.size(); i++) {
            if (i == current || visited.contains(i))
                continue;

            if (ticketList.get(current).isTravel(ticketList.get(i))) {
                ArrayList<Integer> visit = new ArrayList<>(visited);
                visit.add(i);
                travel(i, ticketList, visit);
            }
        }
    }
}
