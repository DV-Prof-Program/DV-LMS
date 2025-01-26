/**
 * Dominick Vician, CEN-3024C-24204, January 20th, 2025
 * LibApp
 * This is the main class of the Library Management System.
 * The LMS will be able to take in an external list of all the library's patrons
 * and allow a user to view and edit the full list by adding and removing patrons manually.
 */

public class LibApp {
    public static void main(String[] args) {
        LibSystem librarySystem = new LibSystem();
        librarySystem.showMenu();
    }
}
