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
        Color lightPurple = new Color(230, 230, 250);
        Color pinkColor = new Color(255,182,193);
        b1.setBackground(pinkColor);
        b2.setBackground(pinkColor);
        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        Dimension buttonSize = new Dimension(100, 30); 
        b1.setPreferredSize(buttonSize);
        b2.setPreferredSize(buttonSize);
        p1.add(b1, gbc);
        p1.add(b2, gbc);
        p1.setBackground(lightPurple);
        add(p1, BorderLayout.CENTER);
        setTitle("Account Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

}
