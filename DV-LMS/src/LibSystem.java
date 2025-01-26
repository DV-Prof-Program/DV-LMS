/**
 * Dominick Vician, CEN-3024C-24204, January 20th, 2025
 * LibSystem
 * This class contains all the methods related to usage of the LMS itself,
 * including all the menu options and the ability to read an external file.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibSystem {
    private List<Patron> patrons;

    /**
     * method: LibSystem (Constructor)
     * parameters: None
     * return: None
     * purpose: Initializes the library system with an empty list of patrons.
     */
    public LibSystem() {
        this.patrons = new ArrayList<>();
    }

    /**
     * method: addPatronFromFile
     * parameters: String filePath
     * return: None
     * purpose: Reads patron data from a text file and adds the patrons to the system.
     */
    public void addPatronFromFile(String filePath) {
        filePath = filePath.replace("\"", "");     //These two lines alter the formatting of the path
        filePath = filePath.replace("\\", "/");    //provided by the 'Copy as Path' option on Windows
                                                                    //to fit the formatting expected by FileReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 4) {
                    patrons.add(new Patron(parts[0], parts[1], parts[2], Float.parseFloat(parts[3])));
                }
            }
            System.out.println("Patrons added from file successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * method: addPatronManually
     * parameters: String id, String name, String address, float overdueFine
     * return: None
     * purpose: Adds a patron to the system with the required details provided manually.
     */
    public void addPatronManually(String id, String name, String address, float overdueFine) {
        patrons.add(new Patron(id, name, address, overdueFine));
        System.out.println("Patron added successfully.");
    }

    /**
     * method: removePatron
     * parameters: String id
     * return: None
     * purpose: Removes a patron from the system based on their ID.
     */
    public void removePatron(String id) {
        patrons.removeIf(p -> p.getId().equals(id));
        System.out.println("Patron removed successfully.");
    }

    /**
     * method: displayAllPatrons
     * parameters: None
     * return: None
     * purpose: Displays the details of all patrons currently in the system.
     */
    public void displayAllPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons in the system.");
        } else {
            for (Patron patron : patrons) {
                System.out.println(patron);
            }
        }
    }

    /**
     * method: showMenu
     * parameters: None
     * return: None
     * purpose: Displays the interactive menu for the library system, allowing users to select various options.
     */
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Patron from File");
            System.out.println("2. Add Patron Manually");
            System.out.println("3. Remove Patron");
            System.out.println("4. Display All Patrons");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    addPatronFromFile(filePath);
                    displayAllPatrons();
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Overdue Fine: ");
                    float fine = scanner.nextFloat();
                    addPatronManually(id, name, address, fine);
                    displayAllPatrons();
                    break;
                case 3:
                    System.out.print("Enter Patron ID to remove: ");
                    String removeId = scanner.nextLine();
                    removePatron(removeId);
                    displayAllPatrons();
                    break;
                case 4:
                    displayAllPatrons();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
