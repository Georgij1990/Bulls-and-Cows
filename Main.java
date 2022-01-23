package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            SecretCode secretCode = new SecretCode();
            System.out.println("Input the length of the secret code:");
//            System.out.print("> ");
            String num = scanner.nextLine();
            if (!num.matches("\\d+") || num.matches("0")) {
                System.out.printf("Error: \"%s\" isn't a valid number.\n", num);
                break;
            }
            System.out.println("Input the number of possible symbols in the code:");
//            System.out.print("> ");
            String symbolsQuantity = scanner.nextLine();
            if (!symbolsQuantity.matches("\\d+")) {
                System.out.printf("Error: \"%s\" isn't a valid number.\n", symbolsQuantity);
                break;
            }
            if (Integer.parseInt(num) > Integer.parseInt(symbolsQuantity)) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", Integer.parseInt(num), Integer.parseInt(symbolsQuantity));
                break;
            }
            if (Integer.parseInt(symbolsQuantity) > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                break;
            }
            if (Integer.parseInt(num) < 37) {
                while (secretCode.code.length() != Integer.parseInt(num)) {
                    secretCode.generateCode(Integer.parseInt(symbolsQuantity));
                }
            } else {
                System.out.println("Error: can't generate a secret code with number of possible symbols more than 36!");
            }
            secretCode.generateMessage(Integer.parseInt(num), Integer.parseInt(symbolsQuantity));
            System.out.println(secretCode);
            System.out.println("Okay, let's start a game!");
            int counter = 1;
            boolean stopper = true;
            while (stopper) {
                System.out.printf("Turn %d:\n", counter++);
                StringBuilder number = new StringBuilder(scanner.next());
                Grade grade = new Grade(String.valueOf(number));
                int cows = grade.checkTheAmountOfCows(secretCode.toString());
                int bulls = grade.checkTheAmountOfBulls(secretCode.toString());
                if (cows > 0 && bulls == 0) {
                    System.out.printf("Grade: %d %s.\n", cows, grade.printCow(cows));
                } else if (cows > 0 && bulls > 0) {
                    System.out.printf("Grade: %d %s and %d %s.\n", bulls, grade.printBull(bulls), cows, grade.printCow(cows));
                } else if (cows == 0 && bulls > 0) {
                    System.out.printf("Grade: %d %s.\n", bulls, grade.printBull(bulls));
                    if (bulls == Integer.parseInt(num)) {
                        stopper = false;
                    }
                } else {
                    System.out.println("Cannot find number of bulls or number of cows or None after the input");
                }
            }
            System.out.println("Congratulations! You guessed the secret code.");
            break;
        }
    }
}
