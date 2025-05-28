package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class NewCustomer1 extends JFrame {
    JTextField textFieldnumber,textFieldname,textFieldcountry;
    JRadioButton r1 , r2;
    JComboBox comboBox;
    Choice c1;
    NewCustomer1(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);



        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);



        JLabel labelname = new JLabel("New Customer Form");
        labelname.setBounds(118,11,260,53);
        labelname.setFont(new Font("Tahoma",Font.BOLD,20));
        labelname.setForeground(Color.WHITE);
        panel.add(labelname);


        JLabel labelID = new JLabel("ID");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.PLAIN,14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);
        comboBox = new JComboBox(new String[] {"Passport","Cnic","Voter Id","Driving License"});
        comboBox.setBounds(200,73,150,20);
        comboBox.setFont(new Font("Tahoma",Font.PLAIN,14));
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(Color.BLACK);
        panel.add(comboBox);



        JLabel numberlabel = new JLabel("Number ");
        numberlabel.setBounds(35,111,200,14);
        numberlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        numberlabel.setForeground(Color.WHITE);
        panel.add(numberlabel);
        textFieldnumber = new JTextField();
        textFieldnumber.setBounds(200,111,150,20);
        panel.add(textFieldnumber);


        JLabel namelabel = new JLabel("Name ");
        namelabel.setBounds(35,151,200,14);
        namelabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        namelabel.setForeground(Color.WHITE);
        panel.add(namelabel);
        textFieldname = new JTextField();
        textFieldname.setBounds(200,151,150,20);
        panel.add(textFieldname);



        JLabel genderlabel = new JLabel("Gender  ");
        genderlabel.setBounds(35,191,200,14);
        genderlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        genderlabel.setForeground(Color.WHITE);
        panel.add(genderlabel);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setBackground(Color.BLACK);
        r1.setForeground(Color.WHITE);
        r1.setBounds(200,191,80,12);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setBackground(Color.BLACK);
        r2.setForeground(Color.WHITE);
        r2.setBounds(280,191,80,12);
        panel.add(r2);


        JLabel countrylabel = new JLabel("Country");
        countrylabel.setBounds(35,231,200,14);
        countrylabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        countrylabel.setForeground(Color.WHITE);
        panel.add(countrylabel);
        textFieldcountry = new JTextField();
        textFieldcountry.setBounds(200,231,150,20);
        panel.add(textFieldcountry);


        JLabel roomlabel = new JLabel("Allocated Room Number ");
        roomlabel.setBounds(35,274,150,14);
        roomlabel.setFont(new Font("Tahoma",Font.PLAIN,12));
        roomlabel.setForeground(Color.WHITE);
        panel.add(roomlabel);
        c1 = new Choice();
        try {
            con c = new con();
            ResultSet resultSet =c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));

            }

        } catch (Exception e) {
             e.printStackTrace();
        }
        c1.setBounds(200,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(Color.black);
        c1.setForeground(Color.WHITE);
        panel.add(c1);







        setLayout(null);
        setResizable(false);
        setLocation(350,100);
        setSize(850,550);
        setVisible(true);
    }
    public static void main(String[] args) {
new NewCustomer1();
    }
}
