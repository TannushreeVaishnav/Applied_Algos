import java.io.*;
import java.util.*;

public class ServerLogAnalysis {

    // Read numbers from a file (each line contains one number)
    static List<Integer> readLogs(String filePath) throws IOException {
        List<Integer> logs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            logs.add(Integer.parseInt(line.trim()));
        }
        br.close();
        return logs;
    }

    // Move zeros (empty log entries) to the end
    static void moveZerosToEnd(List<Integer> logs) {
        int index = 0;

        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i) != 0) {
                Collections.swap(logs, index, i);
                index++;
            }
        }
    }

    // Linear search for a request ID
    static boolean searchRequest(List<Integer> logs, int target) {
        for (int id : logs) {
            if (id == target)
                return true;
        }
        return false;
    }

    // Union of two sorted log lists
    static List<Integer> unionLogs(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                result.add(a.get(i++));
            } else if (a.get(i) > b.get(j)) {
                result.add(b.get(j++));
            } else {
                result.add(a.get(i));
                i++;
                j++;
            }
        }

        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));

        return result;
    }

    // Find missing request IDs between min and max
    static void findMissingRequests(List<Integer> logs) {

        List<Integer> clean = new ArrayList<>();
        for (int id : logs) {
            if (id != 0)
                clean.add(id);
        }

        if (clean.isEmpty()) return;

        int min = Collections.min(clean);
        int max = Collections.max(clean);

        Set<Integer> set = new HashSet<>(clean);

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                System.out.println("Missing request ID: " + i);
            }
        }
    }

    // Maximum consecutive successful requests (1 = success, 0 = fail)
    static int maxConsecutiveOnes(List<Integer> status) {
        int max = 0, count = 0;

        for (int s : status) {
            if (s == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    // Find unique error code (others appear twice)
    static int findUniqueError(List<Integer> errors) {
        int result = 0;
        for (int e : errors) {
            result ^= e;
        }
        return result;
    }

    // Rotate logs to bring latest entries to front
    static void rotateLogs(List<Integer> logs, int k) {
        int n = logs.size();
        k = k % n;

        reverse(logs, 0, n - 1);
        reverse(logs, 0, k - 1);
        reverse(logs, k, n - 1);
    }

    static void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            Collections.swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) throws Exception {

        // Read data from files
        List<Integer> server1 = readLogs("data/server1_logs.csv");
        List<Integer> server2 = readLogs("data/server2_logs.csv");
        List<Integer> status = readLogs("data/request_status.csv");

        // Step 1: Clean logs (push empty entries to end)
        moveZerosToEnd(server1);
        moveZerosToEnd(server2);

        System.out.println("Cleaned Server1 Logs: " + server1);
        System.out.println("Cleaned Server2 Logs: " + server2);

        // Step 2: Merge logs from both servers
        List<Integer> mergedLogs = unionLogs(server1, server2);
        System.out.println("Unified Logs: " + mergedLogs);

        // Step 3: Remove zeros before analysis
        mergedLogs.removeIf(x -> x == 0);

        // Step 4: Detect missing request IDs
        findMissingRequests(mergedLogs);

        // Step 5: Search for a specific request
        System.out.println("Request 105 exists: " +
                searchRequest(mergedLogs, 5));

        // Step 6: Find longest success streak
        System.out.println("Max uptime streak: " +
                maxConsecutiveOnes(status));


        // Step 8: Rotate logs to see most recent entries first
        rotateLogs(mergedLogs, 3);
        System.out.println("Logs after rotation: " + mergedLogs);

        System.out.println("Total merged requests: " + mergedLogs.size());
    }
}
