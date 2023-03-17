package be.jorenfabre.ceasarscoding;

import be.jorenfabre.ceasarscoding.utilities.Converter;

import java.util.Scanner;

public class CeasarsCoding {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter your encryption key: ");
        int key = Converter.toInt(getInput().charAt(0));
        if (key == Integer.MIN_VALUE) {
            restart(args);
            return;
        }
        System.out.print("Do you want to encrypt or decrypt (e/d): ");
        char c = getInput().charAt(0);
        boolean encrypt;
        switch (c) {
            case 'E' -> encrypt = true;
            case 'D' -> encrypt = false;
            default -> {
                restart(args);
                return;
            }
        }
        System.out.print("Please enter your input to be " + (encrypt ? "en" : "de") + "crypted:\n-> ");
        String input = getInput().replace(" ", "[");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int inputInt = Converter.toInt(input.charAt(i));
            int outputInt = (encrypt ? inputInt + key : inputInt - key + 27) % 27;
            Character outputChar = Converter.toChar(outputInt);
            if (outputChar.equals(Character.MIN_VALUE)) {
                restart(args);
                return;
            }
            output.append(outputChar);
        }
        System.out.println("The output of your query:");
        System.out.println(output.toString().toLowerCase().replace('[', ' '));
    }

    private static String getInput() {
        return scanner.nextLine().trim().toUpperCase();
    }

    private static void restart(String[] args) {
        System.out.println("Invalid input! Restarting...");
        main(args);
    }
}
