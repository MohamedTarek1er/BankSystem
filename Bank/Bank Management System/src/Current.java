package Main;

import javax.swing.*;
import static Main.Main.clients;
import static Main.Main.transactions;

public class Current extends Transactions {

    private final double MIN_BALANCE = 3000;
    private final double TaxRate = 0.01;

    @Override
    public void Withdrawl(Client LogedClient, JTextField t1) {

        boolean is = false;

        for (Client c : clients) {

            if (ClientLogin.Acc_Num() == c.getAcc_num()) {
                LogedClient = c;

                double amount = Double.parseDouble(t1.getText());
                if (amount > c.getBalance()) {

                    JOptionPane.showMessageDialog(null, "NO ENOUGH MONEY" + "\n your balance = " + c.getBalance(), "INFO ", JOptionPane.PLAIN_MESSAGE);
                    t1.setText("");
                } else {

                    if (c.getBalance() > MIN_BALANCE) {
                       
                        if (c.getBalance() - amount < 3000) {
                           
                            JOptionPane.showMessageDialog(null, "Be Careful Next Time You will Have to Pay Taxes", "INFO ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        c.setBalance(c.getBalance() - amount);
                      
                        Transactions NewTransaction = new Transactions(LogedClient.getAcc_num(), LogedClient.getClient_id(), amount, LogedClient.getBalance(), "WITHDRAWL");
                        transactions.add(NewTransaction);

                        if (c.getBalance() < 3000) {

                            JOptionPane.showMessageDialog(null, "WITHDRAWL CONFIRMED " + "\n" + " Taxes of  " +Taxes(LogedClient,amount)+" were imposed" , "INFO ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        t1.setText("");
                        
                    } else {

                        if (((c.getBalance() - amount) - Taxes(LogedClient, amount)) > 0) {

                            c.setBalance((c.getBalance() - amount) - Taxes(LogedClient, amount));

                            Transactions NewTransaction1 = new Transactions(LogedClient.getAcc_num(), LogedClient.getClient_id(), amount, LogedClient.getBalance(), "WITHDRAWL");
                            transactions.add(NewTransaction1);

                            JOptionPane.showMessageDialog(null, "WITHDRAWL CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);
                            t1.setText("");

                        } else {
                            JOptionPane.showMessageDialog(null, "LOW BALANCE" + "\n YOUR CURRENT BALANCE IS NOT ENOUGH TO PROCESS THIS TRANSACTIONS", "INFO ", JOptionPane.ERROR_MESSAGE);

                        }
                    }

                }
            }

        }

    }

    public double Taxes(Client Client1, double amount) {
       
        double Tax = amount * TaxRate;
        return Tax;
    }
  
}
