package main.other.remotejobpair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int[] people = {2, 3};
        int[] tshirts = {1, 2, 3};
        int result = solution(people, tshirts);
        System.out.println(result);
    }

    private static int solution(int[] people, int[] tshirts) {
        List<Integer> peopleList = new ArrayList<>();
        List<Integer> tshirtsList = new ArrayList<>();

        for (int person : people) {
            peopleList.add(person);
        }

        for (int tshirt : tshirts) {
            tshirtsList.add(tshirt);
        }

        Collections.sort(peopleList);
        Collections.sort(tshirtsList);

        int max = 0;
        int idx = 0;

        for (int i = 0; i < peopleList.size(); i++) {
            for (int j = idx; j < tshirtsList.size(); j++) {
                if (peopleList.get(i) <= tshirtsList.get(j)) {
                    max++;
                    idx = j + 1;
                    break;
                }
            }
        }

        return max;
    }
}
