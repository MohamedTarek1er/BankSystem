package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import static Main.Main.clients;
import static Main.Main.transactions;

public class Client extends User implements Serializable {

    private double balance;
    private int Client_id = 1000;
    private String acc_state;
    private String acc_Type;
    private double loans;
    private double debt;
    private double Installment;
    public boolean interestEvaluated = false;
    private int Acc_num = 0;
    

    public Client() {
    }

    public Client(String FirstName, String LastName, int id, String Email, long Password, String phoneNumber, double balance, String acc_state, String acc_Type, int Acc_num) {

        super(FirstName, LastName, Email, Password, phoneNumber);
        this.balance = balance;
        this.acc_state = acc_state;
        this.acc_Type = acc_Type;
        this.Client_id = id;
        this.Acc_num = Acc_num;
    }

    public int getAcc_num() {
        return Acc_num;
    }

    public void setAcc_num(int Acc_num) {
        this.Acc_num = Acc_num;
    }

    public double getInstalmment() {
        return Installment;
    }

 

    public void setInstalmment(double instalmment) {
        Installment = instalmment;
    }

    public double getLoans() {
        return loans;
    }

    public void setLoans(double loans) {
        this.loans = loans;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public int getClient_id() {
        return Client_id;
    }

    public void setClient_id(int client_id) {
        Client_id = client_id;
    }

    private int num_of_Installment = 6;

    public boolean isInterestEvaluated() {
        return interestEvaluated;
    }

    public void setInterestEvaluated(boolean interestEvaluated) {
        this.interestEvaluated = interestEvaluated;
    }

    public int getNum_of_Installment() {
        return num_of_Installment;
    }

    public void setNum_of_Installment(int num_of_Installment) {
        this.num_of_Installment = num_of_Installment;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAcc_state(String acc_state) {
        this.acc_state = acc_state;
    }

    public void setAcc_Type(String acc_Type) {
        this.acc_Type = acc_Type;
    }

    public double getBalance() {
        return balance;
    }

    public String getAcc_state() {
        return acc_state;
    }

    public String getAcc_Type() {
        return acc_Type;
    }

    public static void ClientEdit(Client LogedClient, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5) {

        if (Manager.checkClientEdit(LogedClient, t1, t2, t3, t4, t5)) {

            //assign edited values to the client
            LogedClient.setFirstName(t1.getText());
            LogedClient.setLastName(t2.getText());
            LogedClient.setEmail(t3.getText());

            LogedClient.setPhoneNumber(t5.getText());
            Long password = Long.parseLong(t4.getText());
            LogedClient.setPassword(password);
           
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

    public static void DisplayAccountDetails(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JTextField t8, Client DisplayedClient) {

        String idd = Integer.toString(DisplayedClient.getClient_id());

        t1.setText(DisplayedClient.getFirstName());
        t2.setText(DisplayedClient.getLastName());
        t3.setText(DisplayedClient.getEmail());

        t4.setText(DisplayedClient.getPhoneNumber());
        String balance = Double.toString(DisplayedClient.getBalance());
        t5.setText(balance);

        String acc_num = Integer.toString(DisplayedClient.getAcc_num());
        t6.setText(acc_num);
        t7.setText(DisplayedClient.getAcc_Type());
        t8.setText(idd);

    }

    public static void ShowTransactions(DefaultTableModel model) {

        for (Transactions t : transactions) {

            if (t.getAcc_num() == ClientLogin.Acc_Num()) {
                model.addRow(new Object[]{t.getAcc_num(), t.getType(), t.getAmount(), t.getBalance(), t.getDate()});
            }
        }

    }

}
