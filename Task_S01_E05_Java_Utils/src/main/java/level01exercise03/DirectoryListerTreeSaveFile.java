package level01exercise03;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DirectoryListerTreeSaveFile {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void listTreeToWriter(String directoryPath, PrintWriter out){
        File root = new File(directoryPath);

        if(!root.exists()){
            System.err.println("The path does not exist.");
            return;
        }
        if(!root.isDirectory()){
            System.err.println("The path provided is not a directory");
            return;
        }
        out.println("Directory tree for: " + root.getAbsolutePath());
        out.println("\n*******");
        listTreeRecursive(root, "", out);
    }
    private void listTreeRecursive(File dir, String indent, PrintWriter out){
        File[] children = dir.listFiles();
        if(children == null){
            return;
        }
        Arrays.sort(children, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        for(File child : children){
            String type = child.isDirectory()? "D" : "F";
            String lastModified = DATE_FORMAT.format(new Date(child.lastModified()));
            out.printf("%s%s %s [%s]%n", indent, type, child.getName(), lastModified);

            if(child.isDirectory()){
                String INDENT = "  ";
                listTreeRecursive(child, indent + INDENT, out);
            }
        }
    }
}
