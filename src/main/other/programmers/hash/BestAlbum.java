package other.programmers.hash;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static int[] solution(String[] genres, int[] plays) {
        Set<String> genreNames = new HashSet<>(Arrays.asList(genres));
        Map<String, Best> bests = new HashMap<>();

        for (String genreName : genreNames) {
            bests.put(genreName, new Best());
        }

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Best best = bests.get(genre);

            best.addSong(new Song(plays[i], i));
        }

        List<Best> result = new ArrayList<>(bests.values());
        Collections.sort(result);

        List<Integer> answer = new ArrayList<>();
        for (Best best : result) {
            Queue<Song> songs = best.getSongs();
            while (!songs.isEmpty()) {
                answer.add(songs.poll().getId());
            }
        }

        int[] arr = new int[answer.size()];
        for (int i=0; i<arr.length; i++) {
            arr[i] = answer.get(i);
        }
        return arr;

    }

    static class Best implements Comparable<Best> {
        private int hit;
        private PriorityQueue<Song> songs;

        public Best() {
            this.hit = 0;
            this.songs = new PriorityQueue<>();
        }

        public void addSong(Song song) {
            addHit(song.getPlay());
            songs.offer(song);
        }

        public void addHit(int play) {
            this.hit += play;
        }

        public Queue<Song> getSongs() {
            if (songs.size() > 2) {
                Queue queue = new PriorityQueue();
                queue.offer(this.songs.poll());
                queue.offer(this.songs.poll());
                return queue;
            }
            return songs;
        }

        @Override
        public int compareTo(Best o) {
            if (this.hit > o.hit)
                return -1;
            if (this.hit < o.hit)
                return 1;
            return 0;
        }
    }

    static class Song implements Comparable<Song> {
        private int play;
        private int id;

        public Song(int play, int id) {
            this.play = play;
            this.id = id;
        }

        public int getPlay() {
            return play;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play > o.play) {
                return -1;
            } else if (this.play < o.play) {
                return 1;
            }
            return 0;
        }
    }

}
