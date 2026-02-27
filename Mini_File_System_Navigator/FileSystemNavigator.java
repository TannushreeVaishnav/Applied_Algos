import java.util.*;

// Represents a File or Folder node
class FileNode {
    String name;
    boolean isFile;
    int size; 
    List<FileNode> children;

    public FileNode(String name, boolean isFile, int size) {
        this.name = name;
        this.isFile = isFile;
        this.size = size;
        this.children = new ArrayList<>();
    }
}

public class FileSystemNavigator {

    private FileNode root;

    // Constructor
    public FileSystemNavigator() {
        root = new FileNode("Root", false, 0);
    }

    public FileNode getRoot() {
        return root;
    }

    // Add a folder
    public void addFolder(FileNode parent, String folderName) {
        FileNode folder = new FileNode(folderName, false, 0);
        parent.children.add(folder);
    }

    // Add a file
    public void addFile(FileNode parent, String fileName, int size) {
        FileNode file = new FileNode(fileName, true, size);
        parent.children.add(file);
    }

    // Public method to print tree
    public void printTree() {
        printTree(root, 0);
    }

    // Recursive DFS for clean tree printing
    private void printTree(FileNode node, int level) {

        if (node == null) return;

        // Indentation
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        // Print folder or file
        if (node.isFile) {
            System.out.println("- " + node.name + " (" + node.size + "KB)");
        } else {
            System.out.println("+ " + node.name);
        }

        // Traverse children
        for (FileNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    // DFS to calculate total size
    public int calculateTotalSize(FileNode node) {
        if (node == null) return 0;

        int total = node.isFile ? node.size : 0;

        for (FileNode child : node.children) {
            total += calculateTotalSize(child);
        }

        return total;
    }

    // BFS to search file
    public String searchFile(String fileName) {

        Queue<FileNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            FileNode current = queue.poll();

            if (current.isFile && current.name.equals(fileName)) {
                return "File Found: " + current.name + " (" + current.size + "KB)";
            }

            for (FileNode child : current.children) {
                queue.add(child);
            }
        }

        return "File Not Found";
    }

    // Main Method
    public static void main(String[] args) {

        FileSystemNavigator fs = new FileSystemNavigator();
        FileNode root = fs.getRoot();

        // Creating folders
        fs.addFolder(root, "Documents");
        fs.addFolder(root, "Photos");

        // Adding files to Documents
        FileNode documents = root.children.get(0);
        fs.addFile(documents, "Resume.pdf", 120);
        fs.addFile(documents, "Notes.txt", 50);

        // Adding subfolder and file inside Photos
        FileNode photos = root.children.get(1);
        fs.addFolder(photos, "2025");

        FileNode year2025 = photos.children.get(0);
        fs.addFile(year2025, "Trip.jpg", 300);

        // Print File System
        System.out.println("File System Structure:\n");
        fs.printTree();

        // Total Size
        int totalSize = fs.calculateTotalSize(root);
        System.out.println("\nTotal Storage Used: " + totalSize + "KB");

        // Search File
        System.out.println("\nSearching for Resume.pdf...");
        System.out.println(fs.searchFile("Resume.pdf"));
    }
}