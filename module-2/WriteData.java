// Brian Preston
// CSD-420 Module 2 Assignment - WriteData.java
// This program writes 5 random integers and 5 random doubles to a file.
// If the file exists, it appends the data. If not, it creates the file.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        Random rand = new Random();
        String fileName = "brianpreston_datafile.dat";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("Integers: ");
            for (int i = 0; i < 5; i++) {
                writer.write(rand.nextInt(100) + " ");
            }

            writer.write(" | Doubles: ");
            for (int i = 0; i < 5; i++) {
                writer.write(String.format("%.2f ", rand.nextDouble() * 100));
            }

            writer.write("\n");
            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

