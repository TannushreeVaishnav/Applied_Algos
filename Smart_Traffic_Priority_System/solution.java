import java.util.Arrays;

public class TrafficPrioritySystem {

    // Function to reorder vehicles based on priority
    public static void sortVehicles(int[] vehicles) {

        int low = 0;
        int mid = 0;
        int high = vehicles.length - 1;

        while (mid <= high) {

            if (vehicles[mid] == 0) {
                swap(vehicles, low, mid);
                low++;
                mid++;
            }

            else if (vehicles[mid] == 1) {
                mid++;
            }

            else {
                swap(vehicles, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] vehicles = {2,0,2,1,1,0};

        System.out.println("Before prioritization:");
        System.out.println(Arrays.toString(vehicles));

        sortVehicles(vehicles);

        System.out.println("After prioritization:");
        System.out.println(Arrays.toString(vehicles));
    }
}