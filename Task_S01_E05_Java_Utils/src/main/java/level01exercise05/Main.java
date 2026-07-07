package level01exercise05;

import java.io.*;

public class Main {
    public static void main(String[] args){
        if(args.length < 2 ){
            System.err.println("Usage: ");
            System.err.println("java Main --serialize <file.ser>");
            System.err.println("java Main --deserialize <file.ser>");
            System.exit(1);
        }
        String operation = args[0].toLowerCase();
        String fileName = args[1];

        switch (operation){
            case "--serialize" -> serializeCar(fileName);
            case "--deserialize" -> deserializeCar(fileName);
            default -> {System.err.println("Invalid operation.");
            System.exit(1);}
        }
    }
    private static void serializeCar(String fileName){
        Car car = new Car("Tesla", "CyberTruck", 2024, 80000, "Silver");

        try(ObjectOutputStream objectOutS = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutS.writeObject(car);
            System.out.println("Object serialized successfully to: " + fileName);
            System.out.println("Serialized data: " + car);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println(" ");
        }
    }
    private static void deserializeCar(String fileName){
        try(ObjectInputStream ObjectInputS = new ObjectInputStream(new FileInputStream(fileName))){
            Object object = ObjectInputS.readObject();
            if(object instanceof Car){
                Car car = (Car) object;
                System.out.println("Object deserialized successfully from: " + fileName);
                System.out.println("Deserialized data: " + car);
            }else{
                System.out.println("The file does not content a Car object.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found. " + fileName);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found.");
        } catch (IOException e) {
            System.err.println("Error. deserializing object: " + e.getMessage());
        }
    }
}
