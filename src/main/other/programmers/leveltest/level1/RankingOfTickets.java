package main.other.programmers.leveltest.level1;

import java.util.*;

public class RankingOfTickets {
    public static void main(String[] args) {
        String[] movies = {"spy", "ray", "spy", "room", "once", "ray", "spy", "once"};
        String[] result = solution(movies);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String[] solution(String[] movies) {
        Map<String, Integer> movieCount = new HashMap<>();

        for (String movie : movies) {
            if (movieCount.containsKey(movie)) {
                movieCount.put(movie, movieCount.get(movie) + 1);
            } else {
                movieCount.put(movie, 1);
            }
        }

        List<Movie> result = new ArrayList<>();
        for (String movie : movieCount.keySet()) {
            result.add(new Movie(movie, movieCount.get(movie)));
        }

        Collections.sort(result);

        return result.stream().map(movie -> movie.name).toArray(String[]::new);
    }

    static class Movie implements Comparable {
        String name;
        int count;

        public Movie(String name, int count) {
            this.name = name;
            this.count = count;
        }


        @Override
        public int compareTo(Object o) {
            Movie other = (Movie) o;

            if (this.count < other.count) {
                return 1;
            }
            if (this.count > other.count) {
                return -1;
            }

            return this.name.compareTo(other.name);
        }
    }
}
