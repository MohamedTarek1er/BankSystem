package Main;

import javax.swing.*;

import static Main.Main.clients;
import static Main.Main.transactions;

public class Saving extends Transactions {

    double amount;
    static double Max_Limit;

    @Override
    public void Withdrawl(Client LogedClient, JTextField t1) {

        amount = Double.parseDouble(t1.getText());
        if (amount > LogedClient.getBalance()) {

            JOptionPane.showMessageDialog(null, "NO ENOUGH MONEY" + "\n your balance = " + LogedClient.getBalance(), "INFO ", JOptionPane.PLAIN_MESSAGE);
            t1.setText("");

        } else {
            
            if (ExceededMaxLimit(amount, LogedClient)) {

                LogedClient.setBalance(LogedClient.getBalance() - amount);
                JOptionPane.showMessageDialog(null, "Withdrawal Confirmed", "INFO ", JOptionPane.INFORMATION_MESSAGE);

                Transactions NewTransaction = new Transactions(LogedClient.getAcc_num(), LogedClient.getClient_id(), amount, LogedClient.getBalance(), "WITHDRAWL");
                transactions.add(NewTransaction);

                t1.setText("");

            } else {
                
                double MIN_Balance = (LogedClient.getBalance() * 1 / 4);
                double range=LogedClient.getBalance()- MIN_Balance;
                
                JOptionPane.showMessageDialog(null, "YOU MUST WITHDAW AMOUNT BETWEEN " + 1 + " AND " + range, "INFO ", JOptionPane.ERROR_MESSAGE);
                t1.setText("");

            }
        }

    }

    public static void EvaluationRequest(Client requestedClient, double interestRate) {
        for (Client c : clients) {

            String str = Integer.toString(c.getClient_id());
            if (str.equals(ClientLogin.logedID())) {

                requestedClient = c;
            }
        }

        if (requestedClient.interestEvaluated == false) {

            JOptionPane.showMessageDialog(null, "INTEREST EVALUATION CONFIRMED", "INFO ", JOptionPane.INFORMATION_MESSAGE);
            requestedClient.interestEvaluated = true;

            double interest = requestedClient.getBalance() * interestRate;
            requestedClient.setBalance(requestedClient.getBalance() + interest);

        } else {
            JOptionPane.showMessageDialog(null, "Interest for the year has already been evaluated", "INFO ", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static boolean ExceededMaxLimit(double amountt, Client c1) {

        Max_Limit = (c1.getBalance() * 1/4);
        double sum = c1.getBalance() - amountt;

        if (sum >= Max_Limit && sum > 0) {
            return true;
            
        } else {
            return false;
        }
    }
    
}
