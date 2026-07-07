package level01exercise01;

public class Main {
    public static void main(String[] args){

        if(args.length != 1){
            System.out.println("Usage: " );
            return;
        }

        DirectoryLister lister = new DirectoryLister();
        lister.listDirectory("src/alphabet");
    }
}
