package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;

import static Main.Main.employees;

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Transactions> transactions = new ArrayList<>();

    public static void ReadFiles(String filePath, String objType) throws IOException, ClassNotFoundException {

        File file = new File(filePath);

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            try {
                switch (objType) {

                    case "Client":
                        clients = (ArrayList) ois.readObject();
                        break;
                    case "Employee":
                        employees = (ArrayList) ois.readObject();
                        break;
                    case "Transaction":
                        transactions = (ArrayList) ois.readObject();
                }

            } catch (Throwable var7) {

                try {
                    ois.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            ois.close();
        } catch (Exception var8) {
            System.out.println("Error!!");
        }

    }

    public static void WriteFiles(String filePath, String ObjType) {
       
        File file = new File(filePath);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

            try {
                switch (ObjType) {
                    case "Client":
                        oos.writeObject(clients);
                        break;
                    case "Employee":
                        oos.writeObject(employees);
                        break;
                    case "Transaction":
                        oos.writeObject(transactions);
                }
            } catch (Throwable var7) {
                try {
                    oos.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            oos.close();

        } catch (IOException var8) {
            var8.printStackTrace();
            System.out.println("Error!!!");
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ReadFiles("C:\\Users\\MENA\\Favorites\\Clients.txt", "Client");
        ReadFiles("C:\\Users\\MENA\\Favorites\\Employees.txt", "Employee");
        ReadFiles("C:\\Users\\MENA\\Favorites\\Transactions.txt", "Transaction");

        Menu NewMenu = new Menu();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            try {

                WriteFiles("C:\\Users\\MENA\\Favorites\\Clients.txt", "Client");
                WriteFiles("C:\\Users\\MENA\\Favorites\\Employees.txt", "Employee");
                WriteFiles("C:\\Users\\MENA\\Favorites\\Transactions.txt", "Transaction");

            } catch (Exception e) {
               
                e.printStackTrace();
            }
            
        }));
        
    }
    
}