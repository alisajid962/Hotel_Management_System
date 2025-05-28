package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin  extends JFrame implements ActionListener {
    JButton add_Employee,add_Room,add_Driver,logout,back;

    Admin(){
        add_Employee = new JButton("ADD EMPLOYEE");
        add_Employee.setBounds(250,230,200,30);
        add_Employee.setBackground(new Color(30,26,26));
        add_Employee.setForeground(Color.WHITE);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Employee.addActionListener(this);
        add(add_Employee);




        add_Room  = new JButton("ADD ROOM");
        add_Room .setBounds(250,380,200,30);
        add_Room .setBackground(new Color(30,26,26));
        add_Room .setForeground(Color.WHITE);
        add_Room .setFont(new Font("Tahoma",Font.BOLD,15));
        add_Room .addActionListener(this);
        add(add_Room);



        add_Driver  = new JButton("ADD DRIVER");
        add_Driver .setBounds(250,530,200,30);
        add_Driver .setBackground(new Color(30,26,26));
        add_Driver .setForeground(Color.WHITE);
        add_Driver .setFont(new Font("Tahoma",Font.BOLD,15));
        add_Driver .addActionListener(this);
        add(add_Driver);

        logout  = new JButton("Logout");
        logout.setBounds(135,650,95,30);
        logout .setBackground(new Color(30,26,26));
        logout .setForeground(Color.WHITE);
        logout .setFont(new Font("Tahoma",Font.BOLD,15));
        logout .addActionListener(this);
        add(logout);

        back  = new JButton("Back");
        back.setBounds(30,650,95,30);
        back .setBackground(new Color(30,26,26));
        back .setForeground(Color.WHITE);
        back .setFont(new Font("Tahoma",Font.BOLD,15));
        back .addActionListener(this);
        add(back);


        ImageIcon employee_img = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image Employe_img = employee_img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(Employe_img);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70,180,120,120);
        add(label);

        ImageIcon Room_img = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image room_img = Room_img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(room_img);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(70,340,120,120);
         add(label1);

        ImageIcon Driver_img = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image driver_img = Driver_img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(driver_img);
        JLabel label2 = new JLabel(imageIcon2);
        label2.setBounds(70,500,120,120);
        add(label2);

        ImageIcon logo_img = new ImageIcon(ClassLoader.getSystemResource("icon/ccc.gif"));
        Image Logo_img = logo_img.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(Logo_img);
        JLabel label3 = new JLabel(imageIcon3);
        label3.setBounds(650,120,500,500);
        add(label3);












        setLayout(null);
        getContentPane().setBackground(Color.black);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_Employee){
             new AddEmployee();
    } else if (e.getSource()==add_Room) {
            new AddRoom();
        } else if (e.getSource()==add_Driver) {
          new AddDriver();
        } else if (e.getSource()==logout) {
            System.exit(433);

        } else if (e.getSource()==back) {
            new Dashboard();
            this.setVisible(false);
        }
    }

        public static void main(String[] args) {
        new Admin();
    }
}
