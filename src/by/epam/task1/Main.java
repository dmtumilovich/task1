package by.epam.task1;

import java.util.List;
import java.util.Scanner;
public class Main {
    private static final String FILE_NAME = "appliances_db.txt";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppliancesHelper helper = new AppliancesHelper(FILE_NAME);

        while (true) {
            String searchString;
            System.out.println("Enter several options by dividing them with spaces(for example 'Laptop WEIGHT=11 CAPACITY=33'):");
            searchString = scanner.nextLine();

            List<String> matches = helper.getAppliancesList(searchString);

            System.out.println("\nSearching results:");
            if (matches.size() != 0) {
                for (String ans : matches) {
                    System.out.println(ans);
                }
            } else {
                System.out.println("No matches!");
            }

            System.out.print("\nWould you like to continue? (y/n): ");
            if(!scanner.nextLine().equalsIgnoreCase("y"))
                break;
        }
    }

}
