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