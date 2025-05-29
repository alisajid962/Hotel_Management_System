package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
public class Splash extends JFrame {

    private JLabel titleLabel;
    private JLabel logoLabel;
    private float opacity = 0.0f;

    public Splash() {
        setTitle("Majestic Haven");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        // Main panel with dark theme
        JPanel panel = new JPanel();
        panel.setBackground(new Color(25, 25, 25));
        panel.setLayout(new BorderLayout());

        // Hotel Logo
        ImageIcon logoIcon = new ImageIcon("Login.gif"); // Make sure the logo is in the same folder
        logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(logoLabel, BorderLayout.NORTH);

        // Animated Title
        titleLabel = new JLabel("Majestic Haven", JLabel.CENTER);
        titleLabel.setForeground(new Color(135, 206, 250));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setOpaque(false);
        panel.add(titleLabel, BorderLayout.CENTER);

        add(panel);

        // Animation Timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (opacity < 1.0f) {
                    opacity += 0.05f;
                    titleLabel.setForeground(new Color(135, 206, 250, (int) (opacity * 255)));
                } else {
                    timer.cancel();
                    fadeOut();
                }
            }
        }, 0, 50); // Animate every 50ms for smoothness

        setVisible(true);
    }

    // Fade-out effect
    private void fadeOut() {
        Timer fadeTimer = new Timer();
        fadeTimer.schedule(new TimerTask() {
            float fadeOpacity = 1.0f;

            @Override
            public void run() {
                fadeOpacity -= 0.05f;
                if (fadeOpacity <= 0) {
                    fadeTimer.cancel();
                    dispose();
                    new Login();
                } else {
                    setOpacity(fadeOpacity);
                }
            }
        }, 0, 50);
    }

    public static void main(String[] args) {
        new Splash();
    }
}








