package net.viklander;

import java.math.BigDecimal;
import java.util.Random;

public class WheelOfFortune {
    private static final String[] multipliers = {"1.5", "0", "2", "0", "5", "0", "10", "0", "100", "0"};
    private static final Random random = new Random();

    public static void spin(Player player, BigDecimal bet) {
        int index = random.nextInt(multipliers.length);
        BigDecimal playerBalance = player.getBalance();

        switch (index) {
            case 0:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[0]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[0])));
                break;
            case 1:
                player.setBalance(playerBalance.subtract(bet));
                System.out.println("Sorry! You lose!");
                break;
            case 2:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[2]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[2])));
                break;
            case 3:
                player.setBalance(playerBalance.subtract(bet));
                System.out.println("Sorry! You lose!");
                break;
            case 4:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[4]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[4])));
                break;
            case 5:
                player.setBalance(playerBalance.subtract(bet));
                System.out.println("Sorry! You lose!");
                break;
            case 6:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[6]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[6])));
                break;
            case 7:
                player.setBalance(playerBalance.subtract(bet));
                System.out.println("Sorry! You lose!");
                break;
            case 8:
                player.setBalance(playerBalance.add(bet.multiply(new BigDecimal(multipliers[8]))));
                System.out.println("Congrats! You won: " + bet.multiply(new BigDecimal(multipliers[8])));
                break;
            case 9:
                player.setBalance(new BigDecimal(0));
                System.out.println("Sorry, you are now bankrupt!");
                break;
            default:
                break;
        }
    }
}
