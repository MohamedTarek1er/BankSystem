package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Main.employees;

public class EmployeeLogin extends JFrame implements ActionListener {

    JLabel text = new JLabel("WELCOME TO BANK");
    static JTextField t1;
    JTextField t2;
    JButton b1, b2, b3, b4;
    ImageIcon i;
    JLabel K;

    public EmployeeLogin() {

        this.setResizable(false);
        this.setSize(800, 500);
        this.setTitle("BANK");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(225, 100);
        JLabel f = new JLabel();
        f.setIcon(new ImageIcon("D:\\banking.png"));

        text.setFont(new Font("osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        this.add(text);
        f.setBounds(70, 10, 100, 100);

        JLabel mail = new JLabel("ID:");
        mail.setFont(new Font("Raleway", Font.BOLD, 28));
        mail.setBounds(255, 142, 500, 40);
        this.add(mail);

        JLabel pass = new JLabel("PASSWORD:");
        pass.setFont(new Font("Raleway", Font.BOLD, 28));
        pass.setBounds(120, 212, 400, 40);
        this.add(pass);

        t1 = new JTextField();
        t2 = new JPasswordField();
        t1.setBounds(300, 150, 250, 30);
        t2.setBounds(300, 220, 250, 30);
        this.add(t1);
        this.add(t2);

        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.white);
        b1.setForeground(Color.BLUE);
        b1.setBounds(240, 300, 100, 30);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLUE);
        b2.setBounds(370, 300, 100, 30);
        b2.addActionListener(this);

        this.add(b2);
        b3 = new JButton("<<BACK");
        b3.setBackground(Color.white);
        b3.setForeground(Color.BLUE);
        b3.setBounds(500, 300, 100, 30);
        b3.addActionListener(this);
        this.add(b3);

        this.setVisible(true);

    }
    static String LogedName;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            Menu m = new Menu();
            this.setVisible(false);

        }

        if (e.getSource() == b2) {
            t1.setText("");
            t2.setText("");

        }
        if (e.getSource() == b1) {
            if (Manager.CheckEmployeeLogIn(t1, t2, LogedName)) {
                this.setVisible(false);
                EmployeeMenu r = new EmployeeMenu();
            }
        }

    }
    static String g;

    public static String EMlogedID() {

        return t1.getText();

    }

    public static String rLogedname(String s) {
        LogedName = s;
        g = s;
        return LogedName;
    }

    public static String Logedname() {

        return g;
    }

}
