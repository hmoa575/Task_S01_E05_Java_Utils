package level01exercise03;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.err.println("Usage: java Main <directory-path> [output-file]");

            System.err.println("If output-file is omitted, 'directoryTree.txt' will be used.");
            System.exit(1);
        }

        String directoryPath = args[0];
        String outputFileName = (args.length == 2)? args[1] : "directoryTree.txt";

        try
            (PrintWriter writer = new PrintWriter(outputFileName)){
              DirectoryListerTreeSaveFile lister = new DirectoryListerTreeSaveFile();

              lister.listTreeToWriter(directoryPath, writer);
            System.out.println("Tree saved to: " + outputFileName);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
