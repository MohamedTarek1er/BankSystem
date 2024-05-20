package Main;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static Main.Main.clients;
import static Main.Main.transactions;

public class Transactions extends Client implements Serializable {

    private String Type;
    private double amount;
    private double balance;
    private LocalDate date;
    private int accid;

    public Transactions() {
    }

    public Transactions(int Acc_num, int id, double amount, double balance, String Type) {
        this.setAcc_num(Acc_num);
        this.accid = id;
        this.Type = Type;
        this.amount = amount;
        this.balance = balance;
        this.date = LocalDate.now();
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public static void Deposit(Client DepositedClient, double amount, JTextField t1) {
        boolean valid = true;
        for (Client c : clients) {

            if (ClientLogin.Acc_Num() == c.getAcc_num()) {

                DepositedClient = c;

            }
        }

        if (t1.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "You Must Enter Amount", "INFO ", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        if (valid) {

            amount = Double.parseDouble(t1.getText());
            DepositedClient.setBalance(amount + DepositedClient.getBalance());

            JOptionPane.showMessageDialog(null, "DIPOSITE CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);

            Transactions NewTransaction = new Transactions(DepositedClient.getAcc_num(), DepositedClient.getClient_id(), amount, DepositedClient.getBalance(), "DIPOSITE");
            transactions.add(NewTransaction);

            t1.setText("");
        }
    }

    public static void Transfer(JTextField t1, JTextField t2) {

        boolean is = false;

        Client RecieverClient = new Client();
        Client SenderClient = new Client();

        for (Client c : clients) {
            String acc_num = Integer.toString(c.getAcc_num());

            if (acc_num.equals(t1.getText())) {
                RecieverClient = c;

                is = true;
            }
        }

        for (Client c : clients) {
            if (ClientLogin.Acc_Num() == c.getAcc_num()) {
                SenderClient = c;
            }
        }

        if (!is) {
            JOptionPane.showMessageDialog(null, "ID NOT FOUND", "INFO ", JOptionPane.INFORMATION_MESSAGE);
            t1.setText("");
        }

        if (is) {
            double amount = Double.parseDouble(t2.getText());

            if (Manager.CheckAmountValid(amount, SenderClient)) {

                RecieverClient.setBalance(RecieverClient.getBalance() + amount);
                SenderClient.setBalance(SenderClient.getBalance() - amount);

                JOptionPane.showMessageDialog(null, "TRANSFER CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);

                Transactions NewTransaction = new Transactions(SenderClient.getAcc_num(), SenderClient.getClient_id(), amount, SenderClient.getBalance(), "TSENDER");
                transactions.add(NewTransaction);

                Transactions NewTransaction1 = new Transactions(RecieverClient.getAcc_num(), RecieverClient.getClient_id(), amount, RecieverClient.getBalance(), "TRECEIVER");
                transactions.add(NewTransaction1);

                t1.setText("");
                t2.setText("");

            } else {

                JOptionPane.showMessageDialog(null, "NO ENOUGH MONEY" + "\n your balance = " + SenderClient.getBalance(), "INFO ", JOptionPane.PLAIN_MESSAGE);

                t2.setText("");

            }

        }
    }

    public void Withdrawl(Client LogedClient, JTextField t1) {

        boolean is = false;
        double amount = Double.parseDouble(t1.getText());

        for (Client c : clients) {

            if (ClientLogin.Acc_Num() == c.getAcc_num()) {
                LogedClient = c;
                is = true;
            }
        }

        if (is) {

            if (LogedClient.getBalance() > amount) {
                LogedClient.setBalance(LogedClient.getBalance() - amount);
            } else {
                JOptionPane.showMessageDialog(null, "NO ENOUGH MONEY" + "\n your balance = " + LogedClient.getBalance(), "INFO ", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

}
