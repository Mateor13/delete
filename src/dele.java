import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class dele extends JFrame{
    private JTextField ced;
    private JButton eliminarButton;
    private JLabel res;
    private JPanel delet;
    private JButton regresarButton;

    public dele() {
        setTitle("Eliminar Estudiantes");
        setContentPane(delet);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300,250));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estudiante est = new estudiante();
                String url = "jdbc:mysql://localhost:3306/clase";
                String user = "root";
                String pass = "123456";
                est.setCedula(ced.getText());
                Connection conn = null;
                PreparedStatement ps = null;
                try{
                    String querry = "delete from estudiantes where cedula = ?";
                    conn = DriverManager.getConnection(url, user, pass);
                    ps = conn.prepareStatement(querry);
                    ps.setString(1, est.getCedula());
                    int filas = ps.executeUpdate();
                    if (filas>0){
                        res.setText("El estudiante con cedula "+ est.getCedula() +" se ha eliminado correctamente");
                        setPreferredSize(new Dimension(460,250));
                        pack();
                        setLocationRelativeTo(null);
                    }else{
                        res.setText("No se ha podido encontrar al estudiante con la cédula: "+est.getCedula());
                        setPreferredSize(new Dimension(450,250));
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
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menu();
            }
        });
    }
}
