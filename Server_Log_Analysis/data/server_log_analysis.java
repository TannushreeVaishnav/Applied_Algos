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
