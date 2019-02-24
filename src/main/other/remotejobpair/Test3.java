package main.other.remotejobpair;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
//        int[] healths = {200, 120, 150};
//        int[][] items = {{30, 100}, {500, 30}, {100, 400}};
//        // {1. 2}

        int[] healths = {300, 200, 500};
        int[][] items = {{1000, 600}, {400, 500}, {300, 100}};
        // {3}

        int[] result = solution(healths, items);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Character implements Comparable<Character> {
        private int healthPoint;

        public Character(int health) {
            this.healthPoint = health;
        }

        @Override
        public int compareTo(Character o) {
            if (o.healthPoint > this.healthPoint)
                return 1;
            if (o.healthPoint < this.healthPoint)
                return -1;
            return 0;
        }

        public boolean isUsable(Item item) {
            return 100 <= (this.healthPoint - item.lowerHealth);
        }
    }

    static class Item implements Comparable<Item> {
        private int no;
        private int upperAttackPoint;
        private int lowerHealth;

        public Item(int no, int upperAttackPoint, int lowerHealth) {
            this.no = no;
            this.upperAttackPoint = upperAttackPoint;
            this.lowerHealth = lowerHealth;
        }

        @Override
        public int compareTo(Item o) {
            if (o.lowerHealth > this.lowerHealth)
                return 1;
            if (o.lowerHealth < this.lowerHealth)
                return -1;
            return 0;
        }

    }

    private static int[] solution(int[] healths, int[][] items) {
        List<Character> characters = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();

        for (int health : healths) {
            characters.add(new Character(health));
        }

        for (int i = 0; i < items.length; i++) {
            itemList.add(new Item(i + 1, items[i][0], items[i][1]));
        }

        Collections.sort(characters);
        Collections.sort(itemList);

        int idx = 0;
        List<Item> result = new ArrayList<>();

        for (int i = 0; i < characters.size(); i++) {
            for (int j = idx; j < itemList.size(); j++) {
                if (characters.get(i).isUsable(itemList.get(j))) {
                    result.add(itemList.get(j));
                    idx = j + 1;
                    break;
                }
            }
        }

        Collections.sort(result, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.no > o2.no)
                    return 1;
                if (o1.no < o2.no)
                    return -1;
                return 0;
            }
        });


        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).no;
        }

        return answer;
    }
}
