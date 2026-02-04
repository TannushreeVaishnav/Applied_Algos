import java.util.*;
public class ServerLoadAnalysis {

    // Check if input array is valid
    private static boolean isValidInput(int[] cpuUsage) {
        return  cpuUsage.length > 0;
    }

    // Find maximum CPU usage
    public static Integer findMax(int[] cpuUsage) {
       
        int max = cpuUsage[0];

        for (int i = 1; i < cpuUsage.length; i++) {
            if (cpuUsage[i] > max) {
                max = cpuUsage[i];
            }
        }
        return max;
    }

    // Find second maximum CPU usage without sorting
    public static Integer findSecondMax(int[] cpuUsage) {
        if ( cpuUsage.length < 2) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int usage : cpuUsage) {
            if (usage > max) {
                secondMax = max;
                max = usage;
            } else if (usage > secondMax && usage != max) {
                secondMax = usage;
            }
        }

        return (secondMax == Integer.MIN_VALUE) ? null : secondMax;
    }

    // Check if CPU usage is non-decreasing
    public static boolean isStableTrend(int[] cpuUsage) {
        if (!isValidInput(cpuUsage)) {
            return false;
        }

        for (int i = 1; i < cpuUsage.length; i++) {
            if (cpuUsage[i] < cpuUsage[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Main method for user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Server Load Analysis ===\n");

        System.out.print("Enter number of CPU usage entries: ");
        int n = scanner.nextInt();

        int[] cpuUsage = new int[n];

        System.out.println("Enter CPU usage values (%):");
        for (int i = 0; i < n; i++) {
            cpuUsage[i] = scanner.nextInt();
        }

        try {
            System.out.print("CPU Usage Data: ");
            for (int usage : cpuUsage) {
                System.out.print(usage + "% ");
            }
            System.out.println();

            Integer max = findMax(cpuUsage);
            Integer secondMax = findSecondMax(cpuUsage);
            boolean stable = isStableTrend(cpuUsage);

            System.out.println("Max CPU Usage       : " + (max!=null?max+"%":"Not Available"));
            System.out.println("Second Max CPU Usage: "
                    + (secondMax != null ? secondMax + "%" : "Not Available"));
            System.out.println("Stable Trend        : " + stable);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}