import java.util.Arrays;
import java.util.Scanner;

/**
* This program creates 10 random numbers between 1 and 100.
* It then asks the user for a number and uses binary search
* to find and return the index if found.
*
* @author Santiago Hewett
* @version 1.0
* @since 2025/03/27
*/

final class BinarySearch {

    // Max size of the array
    public static final int MAX_ARRAY = 10;

    // Max value for random numbers
    public static final int MAX_VALUE = 100;

    // Private constructor to prevent instantiation
    private BinarySearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) throws Exception {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // User input as string
        String userNumberStr = "";

        // Index for search result
        int index = 0;

        // User input as integer
        int userNumberInt = 0;

        // Array of random numbers
        int[] arrayRandInts = new int[MAX_ARRAY];

        // Loop until user enters 'q'
        do {
            // Fill array with random numbers
            arrayRandInts = populatingArrays();

            // Sort the array
            Arrays.sort(arrayRandInts);

            // Print the sorted array
            System.out.println("What number are you searching for in "
             + "the list below? Enter 'q' to quit.");

            for (int index1 = 0; index1 < MAX_ARRAY; index1++) {
                System.out.print(arrayRandInts[index1] + " ");
            }
            System.out.print(" Number: ");

            // Read user input
            userNumberStr = scanner.nextLine();

            // If user enters 'q', say goodbye
            if (userNumberStr.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                // Try to convert input to a number
                try {
                    userNumberInt = Integer.parseInt(userNumberStr);

                    // Set up binary search range
                    int low = 0;
                    int high = MAX_ARRAY - 1;

                    // Binary search loop
                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (arrayRandInts[mid] == userNumberInt) {
                            index = mid;
                            break;
                        } else if (arrayRandInts[mid] < userNumberInt) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }

                        // If not found, set index to -1
                        index = -1;
                    }

                    // Check if number was found
                    if (index == -1) {
                        System.out.println("The number "
                                + userNumberInt
                                + " was not found in the list.");
                    } else {
                        System.out.println("The number "
                                + userNumberInt
                                + " is found as early as index "
                                + index);
                    }

                } catch (NumberFormatException error) {
                    // Show error if input is not a number
                    System.out.println("Invalid input: "
                            + userNumberStr
                            + ", Please enter a integer");
                }
            }

        } while (!userNumberStr.equals("q"));

        // Close scanner
        scanner.close();
    }

    // Method to fill array with random numbers
    public static int[] populatingArrays() {
        int[] arrayRandInts = new int[MAX_ARRAY];

        // Add random numbers to array
        for (int index = 0; index < MAX_ARRAY; index++) {
            arrayRandInts[index] = (int) (Math.random() * MAX_VALUE) + 1;
        }

        // Return the filled array
        return arrayRandInts;
    }
}
