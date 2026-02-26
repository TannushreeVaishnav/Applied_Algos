import java.util.*;

// Represents a File or Folder node
class FileNode {
    String name;
    boolean isFile;
    int size; // valid only if it is a file
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

    // Printing tree
    public void printTree() {
        printTree(root, 0);
    }
}



