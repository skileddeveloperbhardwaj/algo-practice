package misc;

import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        System.out.println(getRandomQuestionNumber());
    }

    private static int getRandomQuestionNumber() {
        return (int)(Math.random()*500+1);
    }
}
