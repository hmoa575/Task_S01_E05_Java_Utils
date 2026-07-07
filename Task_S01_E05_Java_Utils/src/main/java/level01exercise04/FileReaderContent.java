package level01exercise04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderContent {
    public  void readShowFileContent(String filePath){
        System.out.println("Reading File: " + filePath);
        System.out.println("********\n");

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNumber = 1;

            while((line = reader.readLine()) != null){
                System.out.printf("%4d: %s%n", lineNumber, line);
                lineNumber++;
            }
            if(lineNumber == 1) {
                System.out.println("The file is empty.");
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error. File not found. " + filePath);
        }catch (IOException e){
            System.err.println("Error. Reading the file." + e.getMessage());
        }
    }

}
