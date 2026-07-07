package level01exercise01;

public class Main {
    public static void main(String[] args){

        if(args.length != 1){
            System.out.println("Usage: java Main <directory-path>" );
            return;
        }

        DirectoryLister lister = new DirectoryLister();
        lister.listDirectory(args[0]);
    }
}
