package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static Main.Main.*;

public class Admin {

    final String username = "admin";
    final String password = "admin";

    public static void EmployeeSignUp(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JTextField t8, JTextField t9, JTextField t10, JTextField t11) {

        int Employee_id = 0;
        if (Manager.checkEmployeeSignUp(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)) {
            // assign values to new Employee
            String fname = t1.getText();
            String lname = t2.getText();
            String email = t3.getText();
            String phone = t5.getText();
            String address = t6.getText();
            String college = t7.getText();
            String year = t8.getText();
            String total_grade = t9.getText();
            String position = t10.getText();
            double salary = Double.parseDouble(t11.getText());
            long password = Long.parseLong(t4.getText());;
           
            Employee_id = 20;
            for (Employee emp : employees) {
                Employee_id = Math.max(emp.getEmployee_id(),Employee_id);
            }

            Employee_id++;

            //upcasting
            User newuser = new Employee(fname, lname, Employee_id, email, password, phone, address, college, year, total_grade, position, salary);

            //downcasting
            if (newuser instanceof Employee) {

                //downcasting
                employees.add((Employee) newuser);
            }
            JOptionPane.showMessageDialog(null, "CREATE SUCCESS " + "\n YOUR ID = " + Employee_id, "INFO ", JOptionPane.INFORMATION_MESSAGE);

            t1.setText("");
            t11.setText("");
            t10.setText("");
            t9.setText("");
            t8.setText("");
            t7.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Create FAILED ", "INFO ", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void ShowAllTransaction(DefaultTableModel model) {

        for (Transactions t : transactions) {

            model.addRow(new Object[]{t.getAccid(), t.getAcc_num(), t.getType(), t.getAmount(), t.getBalance(), t.getDate()});

        }
    }

    public static void ShowAllEmployees(DefaultTableModel model) {

        for (Employee e : employees) {

            model.addRow(new Object[]{e.getFirstName(), e.getLastName(), e.getEmployee_id(), e.getEmail(), e.getPassword(), e.getPhoneNumber(), e.getAddress(), e.getGraduated_college(), e.getYear_of_graduation(), e.getTotal_grade(), e.getPosition(), e.getSalary()});

        }

    }

    public static void ShowAllClients(DefaultTableModel model) {
        for (Client c : clients) {

            model.addRow(new Object[]{c.getFirstName(), c.getLastName(), c.getClient_id(), c.getAcc_num(), c.getEmail(), c.getPassword(), c.getPhoneNumber(), c.getBalance(), c.getAcc_state(), c.getAcc_Type()});

        }

    }

}
