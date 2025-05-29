package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateRoom extends JFrame {
    updateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label= new JLabel(imageIcon1);
        label.setBounds(500,60,200,200);
        panel.add(label);

        JLabel urslabel = new JLabel("Update Room Status");
        urslabel.setBounds(124,11,222,25);
        urslabel.setFont(new Font("Tahoma",Font.BOLD,20));
        urslabel.setForeground(Color.WHITE);
        panel.add(urslabel);

        JLabel idlabel = new JLabel("ID");
        idlabel.setBounds(25,88,46,14);
        idlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        idlabel.setForeground(Color.WHITE);
        panel.add(idlabel);


        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);
        try{
            con c1 = new con();
            ResultSet resultSet = c1.statement.executeQuery("select * from customerInfo");
            while (resultSet.next()){
                c.add(resultSet.getString("Id_No"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        JLabel roomlabel = new JLabel("Room Number");
        roomlabel.setBounds(25,129,107,14);
        roomlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        roomlabel.setForeground(Color.WHITE);
        panel.add(roomlabel);
        JTextField roomtext = new JTextField();
        roomtext.setBounds(248,129,140,20);
        panel.add(roomtext);




        JLabel availabilitylabel = new JLabel("Availability");
        availabilitylabel.setBounds(25,174,97,14);
        availabilitylabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        availabilitylabel.setForeground(Color.WHITE);
        panel.add(availabilitylabel);
        JTextField availabilitytext = new JTextField();
        availabilitytext.setBounds(248,174,140,20);
        panel.add(availabilitytext);


        JLabel statuslabel = new JLabel("Cleaning Status");
        statuslabel.setBounds(25,216,97,14);
        statuslabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        statuslabel.setForeground(Color.WHITE);
        panel.add(statuslabel);
        JTextField statustext = new JTextField();
        statustext.setBounds(248,216,140,20);
        panel.add(statustext);


        JButton BACK = new JButton("Back");
        BACK.setBounds(50,300,89,23);
        BACK.setBackground(new Color(30,26,26));
        BACK.setForeground(Color.WHITE);
        panel.add(BACK);
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(200,300,89,23);
        check.setBackground(new Color(30,26,26));
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customerInfo where Id_No = '"+id+"'";
                try{
                    con c1= new con();
                    ResultSet resultSet = c1.statement.executeQuery(q);

                    while (resultSet.next()){
                        roomtext.setText(resultSet.getString("allocatedroom"));


                    }

                    ResultSet resultSet1 = c1.statement.executeQuery("select * from room where roomnumber='"+roomtext.getText()+"'");
                    while (resultSet1.next()){
                        availabilitytext.setText(resultSet1.getString("availability"));
                        statustext.setText(resultSet1.getString("cleaning_status"));

                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton update = new JButton("Update");
        update.setBounds(350,300,89,23);
        update.setBackground(new Color(30,26,26));
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c2  = new con();
                    String status = statustext.getText();
                    c2.statement.executeUpdate("update room set cleaning_status ='"+status+"' where roomnumber = "+roomtext.getText());
                    JOptionPane.showMessageDialog(null,"Updated Successfully");


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });










        setUndecorated(true);
        setLayout(null);
        setLocation(350,100);
        setResizable(false);
        setSize(850,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new updateRoom();
    }
}
