import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class admin extends JFrame {
    private JComboBox<String> jComboBox1;

    public admin() {
        setTitle("Admin");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel jLabel1 = new JLabel("Choice:");
        panel.add(jLabel1);

        jComboBox1 = new JComboBox<>();
        jComboBox1.addItem("Speciality");
        jComboBox1.addItem("Club");
        panel.add(jComboBox1);

        String[] columnNames = {"name", "age", "Speciality", "Club"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from client")) {

            while (rs.next()) {
                String name = rs.getString("name");
                String age = rs.getString("age");
                String speciality = rs.getString("speciality");
                String club = rs.getString("club");
                model.addRow(new Object[]{name, age, speciality, club});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JButton filtrer = new JButton("Filter");
        filtrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = (String) jComboBox1.getSelectedItem();
                if (choice.equals("Speciality")) {
                    special s = new special();
                    s.setVisible(true);
                } else if (choice.equals("Club")) {
                    club c = new club();
                    c.setVisible(true);
                }
            }
        });
        Color pinkColor = new Color(255,182,193);
        filtrer.setBackground(pinkColor);
        panel.add(filtrer);

        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter the name of the client you want to delete");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
                     Statement stmt = con.createStatement()) {
                    stmt.executeUpdate("delete from client where name = '" + name + "'");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Client deleted");
            }
        });
        panel.add(delete);
        delete.setBackground(pinkColor);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Set the background color to light purple for the panel
        Color lightPurple = new Color(230, 230, 250);
        panel.setBackground(lightPurple);
        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
