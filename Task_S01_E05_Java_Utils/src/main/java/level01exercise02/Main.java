package level01exercise02;

public class Main {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Usage: Java Main <directory_path>");
            System.exit(1);
        }
        String directoryPath = args[0];
        DirectoryListerTree lister = new DirectoryListerTree();
        lister.listTree(directoryPath);
    }
}
