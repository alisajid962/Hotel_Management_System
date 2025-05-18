package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JRadioButton radioButtonM,radioButtonF;
    JTextField nameText,ageText,salaryText,phoneText,cnicText,emailText;
    JComboBox comboBox;
    JButton add,back;
    AddEmployee(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(0,0,0));
        add(panel);


        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(new Color(250,249,246));
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setForeground(Color.BLACK);
        panel.add(nameText);



        JLabel AGE = new JLabel("AGE");
        AGE.setBounds(60,80,150,27);
        AGE.setFont(new Font("serif",Font.BOLD,17));
        AGE.setForeground(Color.WHITE);
        panel.add(AGE);
        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(new Color(250,249,246));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setForeground(Color.BLACK);
        panel.add(ageText);



        JLabel GENDER = new JLabel("GENDER");
        GENDER.setBounds(60,120,150,27);
        GENDER.setFont(new Font("serif",Font.BOLD,17));
        GENDER.setForeground(Color.WHITE);
        panel.add(GENDER);

        radioButtonM = new JRadioButton("MALE");
        radioButtonM.setBounds(200,120,70,27);
        radioButtonM.setBackground(new Color(0,0,0));
        radioButtonM.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonM.setForeground(Color.WHITE);
        panel.add(radioButtonM);
        radioButtonF = new JRadioButton("FEMALE");
        radioButtonF.setBounds(280,120,100,27);
        radioButtonF.setBackground(new Color(0,0,0));
        radioButtonF.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonF.setForeground(Color.WHITE);
        panel.add(radioButtonF);


        JLabel job = new JLabel("JOB");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif",Font.BOLD,17));
        job.setForeground(Color.WHITE);
        panel.add(job);




        comboBox = new JComboBox(new String[] {"Front Desk","Guard","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        comboBox.setBackground(new Color(250,249,246));
        comboBox.setBounds(200,170,150,30);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setForeground(Color.BLACK);
        panel.add(comboBox);




        JLabel SALARY = new JLabel("SALARY");
        SALARY.setBounds(60,220,150,27);
        SALARY.setFont(new Font("serif",Font.BOLD,17));
        SALARY.setForeground(Color.WHITE);
        panel.add(SALARY);
        salaryText = new JTextField();
        salaryText.setBounds(200,220,150,27);
        salaryText.setBackground(new Color(250,249,246));
        salaryText.setFont(new Font("Tahoma",Font.BOLD,14));
        salaryText.setForeground(Color.BLACK);
        panel.add(salaryText);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,270,150,27);
        phone.setFont(new Font("serif",Font.BOLD,17));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phoneText = new JTextField();
        phoneText.setBounds(200,270,150,27);
        phoneText.setBackground(new Color(250,249,246));
        phoneText.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneText.setForeground(Color.BLACK);
        panel.add(phoneText);



        JLabel cnic = new JLabel("CNIC");
        cnic.setBounds(60,320,150,27);
        cnic.setFont(new Font("serif",Font.BOLD,17));
        cnic.setForeground(Color.WHITE);
        panel.add(cnic);
        cnicText = new JTextField();
        cnicText.setBounds(200,320,150,27);
        cnicText.setBackground(new Color(250,249,246));
        cnicText.setFont(new Font("Tahoma",Font.BOLD,14));
        cnicText.setForeground(Color.BLACK);
        panel.add(cnicText);


        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("serif",Font.BOLD,17));
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailText = new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setBackground(new Color(250,249,246));
        emailText.setFont(new Font("Tahoma",Font.BOLD,14));
        emailText.setForeground(Color.BLACK);
        panel.add(emailText);

        JLabel AED = new JLabel("Add Employee Details");
        AED.setBounds(450,24,450,40);
        AED.setFont(new Font("TAHOMA",Font.BOLD,31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);


        add = new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(new Color(30,26,26));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);
        back = new JButton("BACk");
        back.setBounds(200,420,100,30);
        back.setBackground(new Color(30,26,26));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);






        setLayout(null);
        setUndecorated(true);
        setLocation(190,100);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = nameText.getText();
            String age = ageText.getText();
            String salary = salaryText.getText();
            String phone=phoneText.getText();
            String email = emailText.getText();
            String cnic = cnicText.getText();
            String job =(String) comboBox.getSelectedItem();
            String gender = null;
            if(radioButtonM.isSelected()){
                gender= "Male";
            } else if (radioButtonF.isSelected()) {
                gender="Female";
            }
            try{
           con c = new con();
           String q = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+cnic+"')";
           c.statement.executeUpdate(q);
           JOptionPane.showMessageDialog(null,"Employee Added");
           setVisible(false);



            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }



        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
    new AddEmployee();
    }
}
