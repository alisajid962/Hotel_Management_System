package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateCheckIn extends JFrame {
    updateCheckIn(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label= new JLabel(imageIcon1);
        label.setBounds(500,60,200,200);
        panel.add(label);

        JLabel checklabel = new JLabel("Check-In Details");
        checklabel.setBounds(124,11,222,25);
        checklabel.setFont(new Font("Tahoma",Font.BOLD,20));
        checklabel.setForeground(Color.WHITE);
        panel.add(checklabel);

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




        JLabel namelabel = new JLabel("Name");
        namelabel.setBounds(25,174,97,14);
        namelabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        namelabel.setForeground(Color.WHITE);
        panel.add(namelabel);
        JTextField nametext = new JTextField();
        nametext.setBounds(248,174,140,20);
        panel.add(nametext);


        JLabel checkTimelabel = new JLabel("Checked-In");
        checkTimelabel.setBounds(25,216,97,14);
        checkTimelabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        checkTimelabel.setForeground(Color.WHITE);
        panel.add(checkTimelabel);
        JTextField checktext = new JTextField();
        checktext.setBounds(248,216,140,20);
        panel.add(checktext);



        JLabel amountlabel = new JLabel("Amount Paid (Rs) ");
        amountlabel.setBounds(25,261,120,14);
        amountlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        amountlabel.setForeground(Color.WHITE);
        panel.add(amountlabel);
        JTextField amounttext = new JTextField();
        amounttext.setBounds(248,261,140,20);
        panel.add(amounttext);


        JLabel pendingamountlabel = new JLabel("Pending Amount (Rs) ");
        pendingamountlabel.setBounds(25,302,140,20);
        pendingamountlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
        pendingamountlabel.setForeground(Color.WHITE);
        panel.add(pendingamountlabel);
        JTextField pendingamounttext = new JTextField();
        pendingamounttext.setBounds(248,302,140,20);
        panel.add(pendingamounttext);

        JButton BACK = new JButton("Back");
        BACK.setBounds(50,378,89,23);
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
        check.setBounds(200,378,89,23);
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
                       nametext.setText(resultSet.getString("name"));
                       checktext.setText(resultSet.getString("check_in_time"));
                       amounttext.setText(resultSet.getString("deposit"));
                    }

                    ResultSet resultSet1 = c1.statement.executeQuery("select * from room where roomnumber='"+roomtext.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amountpaid = Integer.parseInt(price) - Integer.parseInt(amounttext.getText());

                        pendingamounttext.setText(""+amountpaid);

                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton update = new JButton("Update");
        update.setBounds(350,378,89,23);
        update.setBackground(new Color(30,26,26));
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con c2  = new con();
                    String q =c.getSelectedItem();
                    String room = roomtext.getText();
                    String name = nametext.getText();
                    String check = checktext.getText();
                    String amount = amounttext.getText();
                    c2.statement.executeUpdate("update customerInfo  set allocatedroom = '"+room+"',name = '"+name+"',check_in_time='"+check+"',deposit='"+amount+"' where Id_No ='"+q+"'");
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
        setSize(850,550);
        setVisible(true);
    }
    public static void main(String[] args) {
        new updateCheckIn();
    }
}
