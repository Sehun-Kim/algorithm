package main.other.programmers.bruteforce;

import java.util.*;

public class Carpet {
    public static void main(String[] args) {
        int brown = 24;
        int red = 24;
        int[] result = solution(brown, red);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int brown, int red) {
        // red로 사각형 만들 수 있는 조건을 모두 찾는다.
        Set<Rectangle> redRectangles = new HashSet<>();
        for (int i = 1; i <= red; i++) {
            if (red % i == 0) {
                int horizontal = i;
                int vertical = red / i;
                if (vertical > horizontal) {
                     int temp = horizontal;
                     horizontal = vertical;
                     vertical = temp;
                }
                redRectangles.add(new Rectangle(horizontal, vertical));
            }
        }

        int[] result = new int[2];

        for (Rectangle redRectangle : redRectangles) {
            int horizontal = redRectangle.horizontal + 2;
            int vertical = redRectangle.vertical + 2;
            int area = vertical * horizontal;
            if (area - red == brown) {
                result[0] = horizontal;
                result[1] = vertical;
            }
        }


        return result;
    }

    // 무조건 긴 쪽이
    static class Rectangle {
        int horizontal;
        int vertical;

        public Rectangle(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            return horizontal == rectangle.horizontal &&
                    vertical == rectangle.vertical;
        }

        @Override
        public int hashCode() {
            return Objects.hash(horizontal, vertical);
        }

    }
}
