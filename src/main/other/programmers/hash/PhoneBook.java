package other.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        boolean sol = solution(phone_book);
        System.out.println(sol);
    }

    private static boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                if(i != j && phone_book[j].startsWith(s))
                    return false;
            }
        }

        return true;
    }
}
