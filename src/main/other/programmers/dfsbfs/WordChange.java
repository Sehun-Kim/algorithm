package main.other.programmers.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class WordChange {
    static int result = 0;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words);
        System.out.println(result);
    }

    static class Word {
        private int visitCount;
        private boolean[] visitWords;
        private String word;
        private List<Word> changeableWords;

        public Word(int visitCount, boolean[] visitWords, int visitIdx, String word) {
            this.visitCount = visitCount;
            this.visitWords = new boolean[visitWords.length];
            for (int i = 0; i < visitWords.length; i++) {
                if (visitWords[i] || i == visitIdx)
                    this.visitWords[i] = true;
            }

            this.word = word;
            this.changeableWords = new ArrayList<>();
        }

        public Word addChangeableWord(String[] words, String target) {
            for (int i = 0; i < words.length; i++) {
                if (isChangeable(words[i]) && !this.visitWords[i]) {
                    if (words[i].equals(target)) {
                        System.out.println(visitCount + 1);
                        if (result == 0 || result > (visitCount + 1)) {
                            result = visitCount + 1;
                        }
                        break;
                    }
                    Word newWord = new Word(this.visitCount + 1, this.visitWords, i, words[i]).addChangeableWord(words, target);
                    this.changeableWords.add(newWord);
                }
            }

            return this;
        }

        private boolean isChangeable(String word) {
            int changeCnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if (this.word.charAt(i) != word.charAt(i))
                    changeCnt += 1;
            }

            return changeCnt == 1;
        }
    }

    static boolean checkNone(String[] words, String target) {
        for (String word : words) {
            if (target.equals(word))
                return false;
        }
        return true;
    }

    public static int solution(String begin, String target, String[] words) {
        if (checkNone(words, target)) {
            return 0;
        }

        boolean[] visitWords = new boolean[words.length + 1];
        Word beginWord = new Word(0, visitWords, visitWords.length - 1, begin);
        beginWord.addChangeableWord(words, target);

        return result;
    }


}
