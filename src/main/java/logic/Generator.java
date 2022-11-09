package logic;

import java.util.Random;

public class Generator {
    static final Random RND = new Random();

    public static int randomInt(int from, int upTo) {
        return from + RND.nextInt(upTo - from);
    }

    public static String nameGenerator() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        int wordLength = randomInt(4, 50);
        for (int i = 0; i < wordLength; i++) {
            int index = RND.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String passwordGenerator() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*())_+=-~`?><:\"";
        StringBuilder sb = new StringBuilder();
        int wordLength = randomInt(6, 18);
        for (int i = 0; i < wordLength; i++) {
            int index = RND.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String numberGenerator() {
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder();
        int wordLength = randomInt(10, 13);
        for (int i = 0; i < wordLength; i++) {
            int index = RND.nextInt(numbers.length());
            sb.append(index);
        }
        return sb.toString();
    }
}
