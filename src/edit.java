import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class edit extends JFrame {
    private JTextField ced;
    private JTextField n1;
    private JButton modBtn;
    private JButton regBtn;
    private JLabel res;
    private JPanel modi;

    public edit() {
        setTitle("Editar estudiante");
        setContentPane(modi);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(470, 280));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        modBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estudiante est = new estudiante();
                String url = "jdbc:mysql://localhost:3306/clase";
                String user = "root";
                String pass = "123456";
                est.setCedula(ced.getText());
                est.setNota(Double.parseDouble(n1.getText()));
                Connection conn = null;
                PreparedStatement ps = null;
                try{
                    String querry = "update estudiantes set b1 = ? where cedula = ?";
                    conn = DriverManager.getConnection(url, user, pass);
                    ps = conn.prepareStatement(querry);
                    ps.setDouble(1, est.getNota());
                    ps.setString(2, est.getCedula());
                    int filas = ps.executeUpdate();
                    if (filas>0){
                        res.setText("El estudiante con cedula "+ est.getCedula() +" se ha editado correctamente");
                        setPreferredSize(new Dimension(460,280));
                        pack();
                        setLocationRelativeTo(null);
                    }else{
                        res.setText("No se ha podido encontrar al estudiante con la cédula: "+est.getCedula());
                        setPreferredSize(new Dimension(450,280));
                        pack();
                        setLocationRelativeTo(null);
                    }
                }catch(SQLException e1){
                    e1.printStackTrace();
                }finally{
                    try{
                        if(ps != null){
                            ps.close();
                        }if(conn != null){
                            conn.close();
                        }
                    }catch(SQLException e1){
                        e1.printStackTrace();
                    }
                }
            }

        });
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menu();
                dispose();
            }
        });
    }
}
