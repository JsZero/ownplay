package cn.neu;

import java.util.Arrays;

public class FirstNotRepeatingCharInCharStream {

    public static void main(String[] args) {
        Calc c = new Calc();
        c.insert('h');
        c.insert('e');
        c.insert('h');
        c.insert('l');
        c.insert('l');
        c.insert('p');
        c.insert('p');
        c.insert('e');
        System.out.println(c.getFirstNotRepeatChar());
    }

    static class Calc {
        private int[] occurrences;
        private int index;

        public Calc() {
            occurrences = new int[256];
            Arrays.fill(occurrences, -1);
        }

        public void insert(char ch) {
            if (occurrences[ch] == -1)
                occurrences[ch] = index;
            else if (occurrences[ch] >= 0)
                occurrences[ch] = -2;
            index++;
        }

        public char getFirstNotRepeatChar() {
            for (int i = 0; i < occurrences.length; i++) {
                if (occurrences[i] >= 0)
                    return (char) i;
            }
            return '\0';
        }
    }
}
