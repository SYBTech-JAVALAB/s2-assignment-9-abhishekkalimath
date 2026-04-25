import java.io.*;
import java.util.Scanner;

public class StudentFileManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "students.txt";

        try {
            File file = new File(fileName);

            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("New file created.");
            }

            // Choose write mode
            System.out.println("Choose option:");
            System.out.println("1. Overwrite");
            System.out.println("2. Append");
            int choice = sc.nextInt();
            sc.nextLine();

            FileWriter fw;
            if (choice == 1) {
                fw = new FileWriter(file);
            } else {
                fw = new FileWriter(file, true);
            }

            BufferedWriter bw = new BufferedWriter(fw);

            // Input student details
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Grade: ");
            String grade = sc.next();

            bw.write("Name: " + name + ", ID: " + id + ", Grade: " + grade);
            bw.newLine();

            bw.close();

            // Read file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("\nStored Student Information:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}
