import java.io.*;
import java.util.*;

public class ServerLogAnalysis {

    // Read log file into list
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

     // Move zeros to end
    static void moveZerosToEnd(List<Integer> logs) {
        int index = 0;

        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i) != 0) {
                Collections.swap(logs, index++, i);
            }
        }
    }

    // Linear search
    static boolean searchRequest(List<Integer> logs, int target) {
        for (int id : logs) {
            if (id == target) return true;
        }
        return false;
    }
    // Union of sorted logs
    static List<Integer> unionLogs(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) result.add(a.get(i++));
            else if (a.get(i) > b.get(j)) result.add(b.get(j++));
            else {
                result.add(a.get(i));
                i++; j++;
            }
        }

        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));

        return result;
    }

    // Find missing request IDs
    static void findMissingRequests(List<Integer> logs) {
        int max = Collections.max(logs);
        boolean[] seen = new boolean[max + 1];

        for (int id : logs) {
            if (id > 0) seen[id] = true;
        }

        for (int i = 1; i <= max; i++) {
            if (!seen[i]) {
                System.out.println("Missing request ID: " + i);
            }
        }
    }
    public static void main(String[] args) throws Exception {

        List<Integer> server1 = readLogs("data/server1_logs.csv");
        List<Integer> server2 = readLogs("data/server2_logs.csv");
        List<Integer> status = readLogs("data/request_status.csv");

        moveZerosToEnd(server1);
        moveZerosToEnd(server2);

        System.out.println("Cleaned Server1 Logs: " + server1);
        System.out.println("Cleaned Server2 Logs: " + server2);

        List<Integer> mergedLogs = unionLogs(server1, server2);
        System.out.println("Unified Logs: " + mergedLogs);

        findMissingRequests(mergedLogs);

        System.out.println("Request 105 exists: " +
                searchRequest(mergedLogs, 105));

        System.out.println("Max uptime streak: " +
                maxConsecutiveOnes(status));
    }
}