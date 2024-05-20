package Main;

import javax.swing.*;
import java.io.Serializable;
import static Main.Main.clients;

public class Employee extends User implements Serializable {

    private String address;
    private String Graduated_college;
    private String year_of_graduation;
    private String total_grade;
    private String position;
    private double salary;
    private int Employee_id = 20;

    public Employee() {
    }

    public Employee(String FirstName, String LastName, int id, String Email, long Password, String phoneNumber, String address, String Graduated_college, String year_of_graduation, String total_grade, String position, double salary) {

        super(FirstName, LastName, Email, Password, phoneNumber);
        this.address = address;
        this.Graduated_college = Graduated_college;
        this.year_of_graduation = year_of_graduation;
        this.total_grade = total_grade;
        this.position = position;
        this.salary = salary;
        this.Employee_id = id;

    }

    public int getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(int employee_id) {
        Employee_id = employee_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGraduated_college(String graduated_college) {
        Graduated_college = graduated_college;
    }

    public void setYear_of_graduation(String year_of_graduation) {
        this.year_of_graduation = year_of_graduation;
    }

    public void setTotal_grade(String total_grade) {
        this.total_grade = total_grade;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public String getGraduated_college() {
        return Graduated_college;
    }

    public String getYear_of_graduation() {
        return year_of_graduation;
    }

    public String getTotal_grade() {
        return total_grade;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public static void EditPersonalInfo(Employee LogedEmployee, JTextField t1, JTextField t2) {

        JOptionPane.showMessageDialog(null, "EDIT CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);
        LogedEmployee.setAddress(t1.getText());
        LogedEmployee.setPosition(t2.getText());

    }
    
    public static void EmployeeEditClient(Client EditedClient, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5) {

        if (Manager.checkEmployeeEditClient(EditedClient, t1, t2, t3, t4, t5)) {

            EditedClient.setFirstName(t1.getText());
            EditedClient.setLastName(t2.getText());
            EditedClient.setEmail(t3.getText());
            EditedClient.setPhoneNumber(t4.getText());
            EditedClient.setAcc_state(t5.getText());

            JOptionPane.showMessageDialog(null, "EDIT CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "EDIT FAILED", "INFO ", JOptionPane.ERROR_MESSAGE);

        }

    }

    //for Name
    public static Client SearchClient(Client SearchedClient, String fname) {

        for (Client c : clients) {

            if (fname.equals(c.getFirstName())) {

                SearchedClient = c;
                return SearchedClient;
            }
        }

        SearchedClient.setClient_id(0);
        return SearchedClient;
    }

    //for acc_num
    public static Client SearchClient(Client SearchedClient, int Acc_num) {

        for (Client c : clients) {
            if (Acc_num == c.getAcc_num()) {

                SearchedClient = c;
                return SearchedClient;
            }
        }

        SearchedClient.setClient_id(0);
        return SearchedClient;
    }

    //for both
    public static Client SearchClient(Client SearchedClient, String fname, int acc_num) {
        for (Client c : clients) {

            if (fname.equals(c.getFirstName()) && acc_num == c.getAcc_num()) {

                SearchedClient = c;
                return SearchedClient;
            }
        }

        SearchedClient.setClient_id(0);
        return SearchedClient;
    }

    public static void DeleteClient(Client DeletedClient, JTextField t1, JTextField t2) {

        if (! t1.getText().equals("") && ! t2.getText().equals("")) {
            boolean isfound = false;
            for (Client c : clients) {

                int id = Integer.parseInt(t1.getText());
                int acc_num = Integer.parseInt(t2.getText());

                if (id == c.getClient_id() && acc_num == c.getAcc_num()) {
                    DeletedClient = c;
                    isfound = true;
                }
            }
            
            if (!isfound) {

                JOptionPane.showMessageDialog(null, "CLIENT NOT FOUND", "INFO ", JOptionPane.ERROR_MESSAGE);

            } else {
                clients.remove(DeletedClient);
                JOptionPane.showMessageDialog(null, "DELETE CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);
                t1.setText("");
                t2.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CLIENT NOT FOUND", "INFO ", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void ClientSignUp(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JTextField t8) {

        if (Manager.checkClientSignUp(t1, t2, t3, t4, t5, t6, t7, t8)) {

            String fname = t1.getText();
            String lname = t2.getText();
            String email = t3.getText();
            String phone = t7.getText();
            
            int new_id = Integer.parseInt(t5.getText());

            int Acc_num = 0;
            boolean repeat = false;

            int Client_id = 0;
            double balance = Double.parseDouble(t6.getText());

            long password = Long.parseLong(t4.getText());
            String AccType = t8.getText().toLowerCase();

            for (Client c1 : clients) {
                if (new_id == c1.getClient_id()) {
                    repeat = true;
                    Client_id = new_id;
                }
            }

            if (!repeat) {

                for (Client c : clients) {
                    Client_id = Math.max(c.getClient_id(),Client_id);
                }
                Client_id++;
            }

            for (Client cc : clients) {
                Acc_num = cc.getAcc_num();
            }
            Acc_num++;

            // upcasting
            User newuser = new Client(fname, lname, Client_id, email, password, phone, balance, "open", AccType, Acc_num);

            if (newuser instanceof Client) {
                //downcasting
                clients.add((Client) newuser);
            }

            //downcasting
            Client c = (Client) newuser;

            JOptionPane.showMessageDialog(null, "CREATE SUCCESS " + "\n YOUR ID = " + Client_id, "INFO ", JOptionPane.INFORMATION_MESSAGE);
            t1.setText("");
            t8.setText("");
            t7.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");

        }
    }

}
