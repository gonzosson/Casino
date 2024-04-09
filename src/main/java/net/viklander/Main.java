package net.viklander;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                System.out.println(player.name + ", you are bankrupt and a looser, get out of here!");
                break;
            }

            switch(choice) {
                case "1":
                    System.out.println("Playing Wheel of fortune!");
                    System.out.println("How much do you want to bet? (max: " + player.getBalance() + ")");
                    BigDecimal betWheel = getValidBigDecimal(player, scanner.nextLine());

                    if(betWheel == null) {
                        System.out.println("Invalid amount!");
                        break;
                    }

                    WheelOfFortune.spin(player, betWheel);
                    break;
                case "2":
                    System.out.println("Playing Roulette!");
                    System.out.println("How much do you want to bet? (max: " + player.getBalance() + ")");
                    BigDecimal betRoulette = getValidBigDecimal(player, scanner.nextLine());

                    System.out.println();
                    System.out.println("What do you want to bet on? (choose number):");
                    System.out.println("(1) Red");
                    System.out.println("(2) Black");
                    System.out.println("(3) Even");
                    System.out.println("(4) Odd");
                    System.out.println("(5) Low");
                    System.out.println("(6) High");

                    String rouletteChoice = scanner.nextLine();

                    Roulette roulette = new Roulette();
                    int result = roulette.spin();

                    switch(rouletteChoice) {
                        case "1":
                            if(roulette.isRed(result)) {
                                System.out.println("YES! red it is");
                            } else {
                                System.out.println("woop woop, you loose");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }

                    break;
                case "3":
                    System.out.println("Your balance is: " + player.getBalance());
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