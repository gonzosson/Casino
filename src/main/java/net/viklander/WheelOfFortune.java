package net.viklander;

import java.math.BigDecimal;
import java.util.Random;

public class WheelOfFortune {
    private static String[] multipliers = {"1.5", "2", "5", "10", "100", "0"};
    private static Random random = new Random();

    public static void spin(Player player, BigDecimal bet) {
        int index = random.nextInt(multipliers.length);
        BigDecimal playerBalance = player.getBalance();

        switch (index) {
            case 0:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[0]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[0])));
                break;
            case 1:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[1]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[1])));
                break;
            case 2:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[2]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[2])));
                break;
            case 3:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[3]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[3])));
                break;
            case 4:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[4]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[4])));
                break;
            case 5:
                player.setBalance(new BigDecimal(0));
                System.out.println("Sorry, you are now bankrupt!");
                break;
            default:
                break;
        }
    }
}
