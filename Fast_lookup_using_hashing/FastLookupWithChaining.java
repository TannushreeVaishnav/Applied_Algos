import java.util.LinkedList;
import java.util.Scanner;

// Entry class for key-value pair
class Entry {
    int key;
    String value;

    Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

// Custom HashMap using Separate Chaining
class MyHashMap {
    private LinkedList<Entry>[] buckets;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Simple hash function
    private int hash(int key) {
        return key % capacity;
    }

    // Insert or update
    public void put(int key, String value) {
        int index = hash(key);
        LinkedList<Entry> bucket = buckets[index];

        // Check if key exists, update
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // Otherwise, insert new
        bucket.add(new Entry(key, value));
    }

    // Lookup
    public String get(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return "User not found";
    }
}

public class FastLookupWithChaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = scanner.nextInt();

        MyHashMap userMap = new MyHashMap(5); 

        // Input user data
        for (int i = 0; i < n; i++) {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();

            System.out.print("Enter User Status: ");
            String status = scanner.next();

            userMap.put(userId, status);
        }

        // Lookup query
        System.out.print("Enter User ID to search: ");
        int searchId = scanner.nextInt();

        String result = userMap.get(searchId);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
