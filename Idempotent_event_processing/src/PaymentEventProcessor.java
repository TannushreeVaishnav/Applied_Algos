import java.util.Scanner;

public class PaymentEventProcessor {
     /*
     - Removes duplicate transaction IDs in-place.
     - Returns the count of unique transactions.
     */
    public static int removeDuplicates(int[] transactions) {

        if (transactions.length == 0) return 0;

        int uniqueIndex = 0;

        for (int i = 1; i < transactions.length; i++) {
            if (transactions[i] != transactions[uniqueIndex]) {
                uniqueIndex++;
                transactions[uniqueIndex] = transactions[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transaction events: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("No events received. System idle.");
            return;
        }

        int[] transactions = new int[n];

        System.out.println("Enter sorted transaction IDs:");
        for (int i = 0; i < n; i++) {
            transactions[i] = sc.nextInt();
        }

        int uniqueCount = removeDuplicates(transactions);

        System.out.println("\nProcessed Transactions:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(transactions[i] + " ");
        }

        System.out.println("\nTotal events received: " + n);
        System.out.println("Unique transactions processed: " + uniqueCount);
    }
}