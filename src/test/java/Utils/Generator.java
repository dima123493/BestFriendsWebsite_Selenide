package Utils;

import java.util.Locale;
import java.util.Random;

public class Generator {
    static final Random RND = new Random();

    private static int randomInt(int from, int upTo) {
        return from + RND.nextInt(upTo - from);
    }

    public String nameGenerator() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder();
        int wordLength = randomInt(4, 50);
        for (int i = 0; i < wordLength; i++) {
            int index = RND.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        randomString.toUpperCase().charAt(0);
        return randomString;
    }

    public String numberGenerator() {
        StringBuilder sb = new StringBuilder();
        int wordLength = randomInt(10, 13);
        for (int i = 0; i < wordLength; i++) {
            int index = RND.nextInt();
            sb.append(index);
        }
        String randomNumber = sb.toString();
        return randomNumber;
    }
}