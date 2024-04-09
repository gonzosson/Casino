package net.viklander;

import java.util.Random;

public class Roulette {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 36;
    private Random random;

    public Roulette() {
        random = new Random();
    }

    public int spin() {
        return random.nextInt(MAX_NUMBER + 1);
    }

    public boolean isRed(int number) {
        return number != 0 && ((number >= 1 && number <= 10) || (number >= 19 && number <= 28)) || (number >= 11 && number <= 18 && number % 2 == 0) || (number >= 29 && number <= 36 && number % 2 == 1);
    }

    public boolean isBlack(int number) {
        return number != 0 && !isRed(number);
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
