import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class acceuil extends JFrame {
    public acceuil() {
        JLabel t1 = new JLabel("Create your account or login");

        JButton b1 = new JButton("LogIn");
        JButton b2 = new JButton("SignUp");

        JPanel p1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin a = new admin();
                a.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user c = new user();
                c.setVisible(true);
            }
        });

        p1.add(t1, gbc);

        // Set button background color to light purple
        Color lightPurple = new Color(230, 230, 250); // Adjust the RGB values for a lighter shade of purple
        Color pinkColor = new Color(255,182,193);
        b1.setBackground(pinkColor);
        b2.setBackground(pinkColor);

        // Set button foreground (text) color to black
        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);

        // Set the size of buttons
        Dimension buttonSize = new Dimension(100, 30); // Adjust the dimensions as needed
        b1.setPreferredSize(buttonSize);
        b2.setPreferredSize(buttonSize);

        p1.add(b1, gbc);
        p1.add(b2, gbc);

        // Set the background color to light purple for the panel
        p1.setBackground(lightPurple);

        // Center the panel on the JFrame
        add(p1, BorderLayout.CENTER);

        setTitle("Account Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Automatically adjust frame size to fit components
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

}
