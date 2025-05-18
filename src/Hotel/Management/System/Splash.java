package Hotel.Management.System;

import javax.swing.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon splash = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label = new JLabel(splash);
        label.setBounds(0,0,858,600);
         add(label);
        setLayout(null);
        setLocation(200,80);
        setSize(858,600);
        setVisible(true);
        try {
            Thread.sleep(5000);
            new Login();
            setVisible(false);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }





    public static void main(String[] args) {
        new Splash();
    }
}
