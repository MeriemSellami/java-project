import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class acceuil extends JFrame {
    public acceuil() {
        JLabel t1 = new JLabel("admin or new user");
        JButton bl = new JButton("LogIn");
        JButton bs = new JButton("SignUp");
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin a = new admin();
                a.setVisible(true);
            }
        });
        bs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user c = new user();
                c.setVisible(true);
            }
        });
        p1.add(t1, gbc);
        Color lightPurple = new Color(230, 230, 250);
        Color pinkColor = new Color(255,182,193);
        bl.setBackground(pinkColor);
        bs.setBackground(pinkColor);
        bl.setForeground(Color.BLACK);
        bs.setForeground(Color.BLACK);
        Dimension buttonSize = new Dimension(100, 30); 
        bl.setPreferredSize(buttonSize);
        bs.setPreferredSize(buttonSize);
        p.add(bl, gbc);
        p.add(bs, gbc);
        p.setBackground(lightPurple);
        add(p1, BorderLayout.CENTER);
        setTitle("Account Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

}
