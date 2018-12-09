package other;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 문제 위장

/*
 * 구하는 방법
 * 옷을 선택하는 방법은 이항계수를 이용하면 된다.
 * 조합에서 몇개만 뽑는 방식
 *
 * 각 종류별로 하나씩 입을 수 있기에 종류중에 옷을 하나 선택하는 가짓수끼리 곱해주면 답을 구할 수 있다.
 * 이 때 각 종류의 옷중 선택하지 않는 경우를 각각 더해주고, 아예 아무것도 안입는 경우는 없어야 하기 때문에 전체에서 빼주어야 한다.
 *
 * 모자 2개 안경 1개가 있을 경우 식은
 * (2C1 + 1) * (1C1 + 1) - 1
 * (두 개의 모자중에 하나를 선택할 경우 + 하나도 안 선택할 경우) * (하나의 안경중에 하나를 선택할 경우 + 하나도 안 선택할 경우) - 아무것도 입지않을경우
 *
 */
public class spy {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        // 종류별 옷갯수 저장될 map
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) {
                int temp = map.get(clothe[1]);
                map.remove(clothe[1]);
                map.put(clothe[1], temp + 1);
            } else {
                map.put(clothe[1], 1);
            }
        }

        // 계산
        int result = 1;
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
            result *= (map.get(s) + 1);
        }

        System.out.println(result - 1);
        return (result - 1);
    }

}
