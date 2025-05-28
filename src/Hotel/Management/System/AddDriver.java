package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameText,ageText,carCText,carNText,locText;
    JComboBox comboBox,comboBox1;
    JButton add,back;


    AddDriver(){
       JPanel panel = new JPanel();
       panel.setBounds(5,5,890,490);
       panel.setBackground(Color.BLACK);
       panel.setLayout(null);
       add(panel);

       JLabel label = new JLabel("ADD DRIVER");
       label.setBounds(194,10,150,22);
       label.setForeground(Color.WHITE);
       label.setFont(new Font("Tahoma",Font.BOLD,22));
       panel.add(label);


       JLabel name = new JLabel("NAME");
       name.setBounds(64,70,102,22);
       name.setFont(new Font("Tahoma",Font.BOLD,14));
       name.setForeground(Color.WHITE);
       panel.add(name);
       nameText = new JTextField();
       nameText.setBounds(174,70,156,20);
       nameText.setFont(new Font("Tahoma",Font.BOLD,14));
       nameText.setBackground(new Color(250,249,246));
       nameText.setForeground(Color.BLACK);
       panel.add(nameText);


        JLabel age = new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageText = new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setBackground(new Color(250,249,246));
        ageText.setForeground(Color.BLACK);
        panel.add(ageText);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64,150,102,22);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        comboBox = new JComboBox(new String[]{"Male","Female"});
        comboBox.setBounds(176,150,154,20);
        comboBox.setBackground(new Color(30,36,26));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);


        JLabel carC = new JLabel("Car Company");
        carC.setBounds(64,190,102,22);
        carC.setFont(new Font("Tahoma",Font.BOLD,14));
        carC.setForeground(Color.WHITE);
        panel.add(carC);
        carCText = new JTextField();
        carCText.setBounds(174,190,156,20);
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        carCText.setBackground(new Color(250,249,246));
        carCText.setForeground(Color.BLACK);
        panel.add(carCText);


        JLabel carN = new JLabel("Car Name");
        carN.setBounds(64,230,102,22);
        carN.setFont(new Font("Tahoma",Font.BOLD,14));
        carN.setForeground(Color.WHITE);
        panel.add(carN);
        carNText = new JTextField();
        carNText.setBounds(174,230,156,20);
        carNText.setFont(new Font("Tahoma",Font.BOLD,14));
        carNText.setBackground(new Color(250,249,246));
        carNText.setForeground(Color.BLACK);
        panel.add(carNText);


        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(64,270,102,22);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);
        comboBox1 = new JComboBox(new String[]{"Yes","No"});
        comboBox1.setBounds(176,270,154,20);
        comboBox1.setBackground(new Color(30,36,36));
        comboBox1.setForeground(Color.WHITE);
        panel.add(comboBox1);


        JLabel location = new JLabel("LOCATION");
        location.setBounds(64,310,102,22);
        location.setFont(new Font("Tahoma",Font.BOLD,14));
        location.setForeground(Color.WHITE);
        panel.add(location);
        locText = new JTextField();
        locText.setBounds(174,310,156,20);
        locText.setFont(new Font("Tahoma",Font.BOLD,14));
        locText.setBackground(new Color(250,249,246));
        locText.setForeground(Color.BLACK);
        panel.add(locText);


        add = new JButton("Add");
        add.setBounds(200,380,111,33);
        add.setBackground(new Color(30,26,26));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);


        back = new JButton("Back");
        back.setBounds(64,380,111,33);
        back.setBackground(new Color(30,26,26));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);



        setLayout(null);
        setUndecorated(true);
        setResizable(false);
        setLocation(200,100);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == add){
           String name = nameText.getText();
           String age = ageText.getText();
           String gender = (String) comboBox.getSelectedItem();
           String company= carCText.getText();
           String carname = carNText.getText();
           String available = (String) comboBox1.getSelectedItem();
           String location = locText.getText();

           try{
               con c = new con();
               String q = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+carname+"','"+available+"','"+location+"')";
               c.statement.executeUpdate(q);
               JOptionPane.showMessageDialog(null,"Driver Added");
               this.setVisible(false);



           } catch (Exception ex) {
               throw new RuntimeException(ex);
           }

         }else{
           setVisible(false);
         }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
