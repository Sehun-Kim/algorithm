package main.other.programmers.linetest;

import java.util.ArrayList;
import java.util.List;


public class Num2 {
    public static void main(String[] args) {
        String a = "HSO214";
        String result = solution(a);

        System.out.println(result);
    }

    static class Element {
        String element;
        String count;

        public Element(String element) {
            this.element = element;
        }

        public void addElement(String lower) {
            this.element = this.element + lower;
        }

        public void addCount(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            if (count.equals("1"))
                return this.element;
            return this.element + this.count;
        }
    }

    static String solution(String a) {
        String[] strings = a.split("");
        List<Element> elements = new ArrayList<>();

        int strLen = a.length();
        int eleLen = 0;

        for (int i = 0; i < strLen; i++) {
            if (isNumber(a.charAt(i))) {
                System.out.println(i);
                eleLen = i;
                break;
            }
        }

        for (int j = 0; j < eleLen; j++) {
            if (Character.isUpperCase(a.charAt(j))) {
                elements.add(new Element(strings[j]));
            } else {
                elements.get(j - 1).addElement(strings[j]);
            }
        }

        if (!((strLen - eleLen) == elements.size())) {
            return "error";
        }

        for (int i = eleLen; i < strLen; i++) {
            elements.get(i - eleLen).addCount(strings[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (Element element : elements) {
            sb.append(element);
        }

        return sb.toString();
    }

    private static boolean isNumber(char charAt) {
        return Character.isDigit(charAt);
    }
}
