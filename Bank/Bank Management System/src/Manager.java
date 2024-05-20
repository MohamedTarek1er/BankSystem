package Main;

import javax.swing.*;

import static Main.Main.clients;
import static Main.Main.employees;

public class Manager {

    public static boolean checkEmployeeSignUp(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JTextField t8, JTextField t9, JTextField t10, JTextField t11) {

        boolean emailfound = false;
        boolean valid = true;

        // Email Exception
        for (Employee emp : employees) {
            if (t3.getText().equals(emp.getEmail())) {
                emailfound = true;
            }
        }

        if (emailfound) {

            JOptionPane.showMessageDialog(null, "Email is already Exist", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        //salary Exception
        try {
            double salary = Double.parseDouble(t11.getText());

            if (salary < 8000) {
                throw new IllegalArgumentException("Minimum Salary = 8000 ");
            }

        } catch (IllegalArgumentException e1) {

            JOptionPane.showMessageDialog(null, "Minimum Salary = 8000 ", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        // password Exception
        String textPass = t4.getText();

        try {

            if (textPass.length() < 6) {
                throw new IllegalArgumentException("Password must be 6 digits at least");
            }

            long password = Long.parseLong(t4.getText());

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(null, "Password must be 6 digits at least", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;

        }

        // Unfilled Exception
        if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
                || t5.getText().equals("") || t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("")
                || t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "You Must Fill All Fields", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        if (valid) {
            return true;

        } else {
            return false;
        }

    }

    public static boolean checkClientSignUp(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JTextField t8) {

        boolean emailfound = false;
        boolean valid = true;
        boolean validAcc = false;

        // Email Exception
        for (Client cll : clients) {
            if (t3.getText().equals(cll.getEmail())) {
                emailfound = true;
            }
        }

        if (emailfound) {

            JOptionPane.showMessageDialog(null, "Email is already Exist", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        // Account Type Exception
        String AccType = t8.getText().toLowerCase();

        if (AccType.equals("saving") || AccType.equals("current")) {
            validAcc = true;
        }

        if (!validAcc) {

            JOptionPane.showMessageDialog(null, "You Must Choose Between\n" + " Saving or Current Account", "INFO ", JOptionPane.ERROR_MESSAGE);

            valid = false;

        }

        //Balance Exception
        double balance = 0;
        try {
            balance = Double.parseDouble(t6.getText());

            if (balance < 3000) {
                throw new IllegalArgumentException("Minimum Balance= 3000 ");
            }

        } catch (IllegalArgumentException e1) {

            JOptionPane.showMessageDialog(null, "Minimum Balance= 3000 ", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        // Password Exception
        String textPass = t4.getText();
        long password = 0;

        try {

            if (textPass.length() < 6) {
                throw new IllegalArgumentException("Password must be 6 digits at least");
            }

            password = Long.parseLong(t4.getText());

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(null, "Password must be 6 digits at least", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;

        }

        // Unfilled Exception
        if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
                || t5.getText().equals("") || t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "You Must Fill All Fields", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        if (valid) {
            return true;

        } else {
            return false;
        }

    }

    public static boolean checkEmployeeEditClient(Client EditedClient, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5) {

        boolean emailfound = false;
        boolean valid = true;
        boolean acc = false;

        // Email Exception
        for (Client cll : clients) {
            if (t3.getText().equals(cll.getEmail()) && !(EditedClient.getEmail().equals(cll.getEmail()))) {
                emailfound = true;
            }
        }

        if (emailfound) {

            JOptionPane.showMessageDialog(null, "Email is already Exist", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        // Unfilled Exception
        if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
                || t4.getText().equals("") || t5.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "You Must Fill All Fields", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }
        if (valid) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkClientEdit(Client LogedClient, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5) {
        boolean emailfound = false;
        boolean valid = true;
        boolean acc = false;

        // Email Exception
        for (Client cll : clients) {
            if (t3.getText().equals(cll.getEmail()) && !(LogedClient.getEmail().equals(cll.getEmail()))) {
                emailfound = true;
            }
        }

        if (emailfound) {

            JOptionPane.showMessageDialog(null, "Email is already Exist", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        // Password Exception
        String textPass = t4.getText();
        long password = 0;

        try {

            if (textPass.length() < 6) {
                throw new IllegalArgumentException("Password must be 6 digits at least");
            }

            password = Long.parseLong(t4.getText());

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(null, "Password must be 6 digits at least", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;

        }

        // Unfilled Exception
        if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
                || t4.getText().equals("") || t5.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "You Must Fill All Fields", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;

        }
        if (valid) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean CheckClientLogIn(JTextField t1, JTextField t2, JTextField t3, int Acc_num, String LogedName) {

        boolean is = false;
        for (Client c : clients) {

            String Id = Integer.toString(c.getClient_id());
            String password = Long.toString(c.getPassword());

            if (t3.getText().equals(password) && t1.getText().equals(Id) && t2.getText().equals(c.getEmail())) {
                LogedName = c.getFirstName();
                ClientLogin.rLogedname(LogedName);
                Acc_num = c.getAcc_num();
                ClientLogin.rAcc_Num(Acc_num);
                is = true;
            }
        }
        if (is == true) {
            JOptionPane.showMessageDialog(null, "  log in SUCCESS", "INFO ", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Email or Password Wrong!", "INFO ", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    public static boolean CheckEmployeeLogIn(JTextField t1, JTextField t2, String LogedName) {
        boolean is = false;

        for (Employee employee : employees) {

            String Password = Long.toString(employee.getPassword());
            String Id = Integer.toString(employee.getEmployee_id());
            if (t2.getText().equals(Password) && t1.getText().equals(Id)) {
                is = true;

                LogedName = employee.getFirstName();
                EmployeeLogin.rLogedname(LogedName);
            }
        }
        
        if (is == true) {

            JOptionPane.showMessageDialog(null, "  Log in SUCCESS", "INFO ", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Wrong ID or Password ", "INFO ", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static boolean CheckAmountValid(double amount, Client c) {
        if (c.getBalance() > amount) {
            return true;
        } else {
            return false;

        }
    }

}
