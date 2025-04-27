/*
 * Brian Preston
 * CSD-420 - Module 8
 * ThreeThreads.java
 * This program uses three threads to generate random letters, digits, and symbols.
 */

import java.util.Random;

public class ThreeThreads {

    public static void main(String[] args) {
        // Create the threads
        Thread letterThread = new Thread(new RandomLetterGenerator());
        Thread digitThread = new Thread(new RandomDigitGenerator());
        Thread symbolThread = new Thread(new RandomSymbolGenerator());

        // Start the threads
        letterThread.start();
        digitThread.start();
        symbolThread.start();
    }
}

// Thread to generate random letters
class RandomLetterGenerator implements Runnable {
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            char letter = (char) ('a' + rand.nextInt(26)); // random lowercase letter
            System.out.print(letter);
        }
    }
}

// Thread to generate random digits
class RandomDigitGenerator implements Runnable {
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int digit = rand.nextInt(10); // random 0-9
            System.out.print(digit);
        }
    }
}

// Thread to generate random symbols
class RandomSymbolGenerator implements Runnable {
    public void run() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            char symbol = symbols[rand.nextInt(symbols.length)];
            System.out.print(symbol);
        }
    }
}

