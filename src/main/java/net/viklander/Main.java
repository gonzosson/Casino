package net.viklander;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Casino Cosmos!");

        System.out.println("What's your name?");

        String name = scanner.nextLine();

        System.out.println("How much money would you like to deposit?");

        BigDecimal money = scanner.nextBigDecimal();
        scanner.nextLine();

        Player player = new Player(name, money);

        while(true) {
            System.out.println();
            System.out.println("Menu (choose number or q to quit):");
            System.out.println("(1) Play Wheel of fortune");
            System.out.println("(2) Play Roulette");
            System.out.println("(3) Check balance");
            System.out.println("(q) quit");

            String choice = scanner.nextLine();

            if(player.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("You are bankrupt, get out of here!");
                break;
            }

            switch(choice) {
                case "1":
                    System.out.println("Playing Wheel of fortune!");
                    System.out.println("How much do you want to bet? (max: " + player.getBalance() + ")");
                    BigDecimal bet = getValidBigDecimal(player, scanner.nextLine());
                    scanner.nextLine();

                    if(bet == null) {
                        System.out.println("Invalid amount!");
                        break;
                    }

                    WheelOfFortune.spin(player, bet);
                    break;
                case "2":
                    System.out.println("Playing Roulette!");
                    break;
                case "3":
                    System.out.println(player.getBalance());
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
                    continue;
            }

            if(choice.equals("q")) {
                System.out.println("Exiting Casino Cosmos through the gift shop...");
                break;
            }
        }

        scanner.close();
    }

    private static BigDecimal getValidBigDecimal(Player player, String input) {
        try {
            BigDecimal value = new BigDecimal(input);
            int result = player.getBalance().compareTo(value);

            if(result < 0) {
                return null;
            }

            return value;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}