import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    private JButton editBtn;
    private JButton delBtn;
    private JButton exiBtn;
    private JPanel menu;

    public menu() {
        setTitle("Menu Principal");
        setContentPane(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 250));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new edit();
                dispose();
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dele();
                dispose();
            }
        });
        exiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
