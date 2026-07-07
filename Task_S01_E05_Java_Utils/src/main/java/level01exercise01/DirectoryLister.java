package level01exercise01;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {
    public void listDirectory(String directoryPath){
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Error. The path does not exists.");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Error. The patch is not a directory.");
            return;
        }
        String[] contents = directory.list();

        if (contents == null || contents.length == 0) {
            System.out.println("The directory is empty.");
            return;
        }
        Arrays.sort(contents);
        System.out.println("Content ordered alphabetically: ");
        for (String i : contents) {
            System.out.println(i);
        }
    }
}
