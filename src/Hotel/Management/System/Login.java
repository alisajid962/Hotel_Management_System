package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField UserField;
    JPasswordField PassField;
    JButton Login,Cancel;
    Login(){
        JLabel l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        l1.setFont(new Font("Tahoma", Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        l2.setFont(new Font("Tahoma", Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        add(l2);

        UserField = new JTextField();
        UserField.setBounds(150,20,150,30);
        UserField.setForeground(Color.BLACK);
        UserField.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(UserField);

        PassField = new JPasswordField();
        PassField.setBounds(150,70,150,30);
        PassField.setForeground(Color.BLACK);
        PassField.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(PassField);

        ImageIcon LoginGif = new ImageIcon(ClassLoader.getSystemResource("icon/Login.gif"));
        JLabel LoginGifLabel = new JLabel(LoginGif);
        LoginGifLabel.setBounds(315,-20,255,300);
        add(LoginGifLabel);

        Login = new JButton("Login");
        Login.setBounds(40,140,120,30);
        Login.setFont(new Font("serif",Font.BOLD,15));
        Login.setBackground(new Color(30, 26, 26));
       Login.setForeground(Color.WHITE);
       Login.addActionListener(this);
        add(Login);


        Cancel = new JButton("Cancel");
        Cancel.setBounds(180,140,120,30);
        Cancel.setFont(new Font("serif",Font.BOLD,15));
        Cancel.setBackground(new Color(30, 26, 26));
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);




        setLayout(null);
        setSize(600,300);
        setLocation(400,270);
        getContentPane().setBackground(new Color(0, 0, 0));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login){
          try {
              con c = new con();
              String user = UserField.getText();
              String pass = PassField.getText();
              String q = "SELECT * FROM login WHERE username='" + user + "' AND password='" + pass + "'";

//              String q = "select * from login where username='"+ user +"',and password ='"+ pass+ "'";
              ResultSet resultSet = c.statement.executeQuery(q);
              if(resultSet.next()){
                 new Dashboard();
                  setVisible(false);

              }else{
               JOptionPane.showMessageDialog(null,"Password ghalat hai bhai ");
              }
          } catch (Exception ex) {
              throw new RuntimeException(ex);
          }
    }  else{
        System.exit(102);
        }
    }

    public static void main(String[] args) {
         new Login();
    }
}
