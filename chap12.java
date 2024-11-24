import java.io.*;
import java.util.Scanner;

public class chap12 {
    public static void main(String[] args) {
        String filePath = "/Users/amankhan/Downloads/CHAP 12 AED/my_test_file.txt";
        System.out.println("Reading from the file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Make sure the file exists at the specified location.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a phrase to write into the file:");
        String userPhrase = scanner.nextLine();

        System.out.println("\nWriting to the file...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(userPhrase);
            System.out.println("The phrase has been successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
