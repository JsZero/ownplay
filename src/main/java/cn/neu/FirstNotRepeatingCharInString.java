package cn.neu;

import java.util.HashMap;

public class FirstNotRepeatingCharInString {

    private static Character firstNotRepeatingCharInString(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : arr) {
            if (hashMap.get(ch) == 1)
                return ch;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingCharInString("qwewweqortsmsmtr"));
    }
}
