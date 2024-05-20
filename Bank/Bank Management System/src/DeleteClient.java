package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Main.clients;

public class DeleteClient extends JFrame implements ActionListener {

    JLabel l, l1;
    JButton b1, b2;
    JTextField t1, t2;
    Client cc = new Client();

    public DeleteClient() {
      
        this.setResizable(false);
        this.setSize(700, 350);
        this.setTitle("BANK");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 200);
        this.setLayout(null);
        l = new JLabel("ENTER  ID : ");
        l1 = new JLabel("ENTER Account_Num : ");

        b1 = new JButton("DELETE");
        b2 = new JButton("<<BACK");
        t1 = new JTextField();
        t2 = new JTextField();

        l.setFont(new Font("osward", Font.BOLD, 18));
        l.setForeground(Color.BLACK);
        l.setBounds(135, 12, 400, 40);

        l1.setFont(new Font("osward", Font.BOLD, 18));
        l1.setForeground(Color.BLACK);
        l1.setBounds(80, 54, 400, 40);

        t1.setBounds(250, 20, 200, 30);
        t2.setBounds(290, 60, 200, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBounds(200, 150, 100, 50);
        b2.setBounds(360, 150, 100, 50);

        this.add(l);
        this.add(l1);

        this.add(b1);
        this.add(b2);
        this.add(t1);
        this.add(t2);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            Employee.DeleteClient(cc, t1,t2);
        }
        if (e.getSource() == b2) {
            EmployeeMenu s = new EmployeeMenu();
            this.setVisible(false);
        }

    }

}
