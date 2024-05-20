package Main;

import javax.swing.*;
import static Main.Main.clients;
import static Main.Main.transactions;

public class Loan extends Transactions {

    private static  final double interestRate = 0.025;
    private static double SingleInstallment;

    public static void RequestLoan(Client RequestedClient, JTextField t) {

        for (Client c : clients) {

            if (ClientLogin.Acc_Num() == c.getAcc_num()) {
                RequestedClient = c;
            }
        }

        double amount = Double.parseDouble(t.getText());
        if (amount >= 10000 && amount <= 500000) {

            RequestedClient.setLoans(amount);
            SingleInstallment = ((amount / 6) * interestRate) + (amount / 6);

            RequestedClient.setInstalmment(SingleInstallment);
            RequestedClient.setDebt((interestRate * amount) + amount);
            
            Apply_Payment(RequestedClient, amount);

            JOptionPane.showMessageDialog(null, "LOAN CONFIRMED "
                    + " \n YOU HAVE TO PAY " + SingleInstallment + "\n AT 6 INSTALLMENT", "INFO ", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, "YOUR BALANCE IS UPDATED "
                    + " \n YOUR CURRENT BALANCE IS " + RequestedClient.getBalance() + "\n", "INFO ", JOptionPane.INFORMATION_MESSAGE);

            Transactions NewTransaction = new Transactions(RequestedClient.getAcc_num(), RequestedClient.getClient_id(), amount, RequestedClient.getDebt(), "LOAN");
            transactions.add(NewTransaction);
            t.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "We suggest that you Enter amount\n" + "between 10000 and 500000\n" + " for the Loan to be accepted", "INFO ", JOptionPane.ERROR_MESSAGE);
            t.setText("");

        }
    }

    public static void PayLoan(Client PaidClient) {

        if (PaidClient.getNum_of_Installment() > 1 && PaidClient.getDebt() != 0) {

            PaidClient.setNum_of_Installment(PaidClient.getNum_of_Installment() - 1);
            PaidClient.setDebt(PaidClient.getDebt() - PaidClient.getInstalmment());

            JOptionPane.showMessageDialog(null, "REMAIN INSTALLMENTS IS " + PaidClient.getNum_of_Installment() + "\n AND YOUR DEBT NOW IS " + PaidClient.getDebt(), "INFO ", JOptionPane.INFORMATION_MESSAGE);

            Transactions NewTransaction1 = new Transactions(PaidClient.getAcc_num(), PaidClient.getClient_id(), PaidClient.getLoans(), PaidClient.getDebt(), "LOAN");
            transactions.add(NewTransaction1);

        } else {

            if (PaidClient.getDebt() == 0 && PaidClient.getNum_of_Installment() == 6) {
                JOptionPane.showMessageDialog(null, "YOU DONT HAVE ANY LOANS", "INFO ", JOptionPane.INFORMATION_MESSAGE);
            } else {

                if (PaidClient.getNum_of_Installment() == 1) {
                    PaidClient.setDebt(0);

                    Transactions NewTransaction2 = new Transactions(PaidClient.getAcc_num(), PaidClient.getClient_id(), PaidClient.getLoans(), PaidClient.getDebt(), "LOAN");
                    transactions.add(NewTransaction2);
                }

                JOptionPane.showMessageDialog(null, "YOU HAVE PAID ALL YOUR INSTALLMENTS", "INFO ", JOptionPane.INFORMATION_MESSAGE);

                PaidClient.setDebt(0);
                PaidClient.setNum_of_Installment(6);

            }

        }

    }

    public static void Apply_Payment(Client CurrentClient, double total_amount) {

        CurrentClient.setBalance(CurrentClient.getBalance() + total_amount);
    }

}
