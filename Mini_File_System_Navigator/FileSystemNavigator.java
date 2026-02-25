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

