package level01exercise02;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DirectoryListerTree {
    private final String INDENT = "  ";
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void listTree(String directoryPath){
        File root = new File(directoryPath);

        if(!root.exists()){
            System.err.println("Error. The path does not exist.");
            return;
        }
        if(!root.isDirectory()){
            System.err.println("Error. The path is not a directory.");
            return;
        }
        System.out.println("Directory tree for: " + root.getAbsolutePath());
        System.out.println("\n*******");
        listTreeRecursive(root, "");
    }
    private void listTreeRecursive(File dir, String indent) {
        File[] children = dir.listFiles();
        if (children == null) {
            return;
        }
        Arrays.sort(children, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        for(File child : children){
            String type = child.isDirectory() ? "D":"F";
            String lastModified = DATE_FORMAT.format(new Date(child.lastModified()));

            System.out.printf(indent + " " + type + " " + child.getName() + " " + lastModified );

            if(child.isDirectory()){ listTreeRecursive(child, indent + INDENT);}
        }
    }
}
