package level01exercise04;

public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            System.err.println("Usage: java FileContentReader <file-path>");
            System.exit(1);
        }
        String filePath = args[0];

        FileReaderContent reader = new FileReaderContent();
        reader.readShowFileContent(filePath);
    }
}
