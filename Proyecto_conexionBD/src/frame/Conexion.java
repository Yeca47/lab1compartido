
package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;*/

public class Conexion {

    public Connection conectar;
    public String driver;
    public String bd;
    public String usuario;
    public String password;
   // Connection con = null;
    
    public Conexion(){
        this.conectar=null;
        this.driver="com.mysql.jdbc.Driver";
        this.bd="jdbc:mysql://localhost:3306/rutas_git";
        this.usuario="root";
        this.password="";
    }
    
    public Connection procesoConexion(){
    
        try{
            this.conectar = DriverManager.getConnection(this.bd, this.usuario, this.password);
        
        }catch(SQLException e){
            System.out.println("Error-> "+e.getMessage());
        }
        
        return this.conectar;
    }
    
    /*public ResultSet consulta(String sql){
        
        ResultSet res = null;
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            res = pstm.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\n"+e.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        return res;
        }
    
    public DefaultComboBoxModel mostrarAlumno(){
        //String grado = lblgrado.getText();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione Alumno");
        ResultSet res = this.consulta("select * from estudiantes where idGrados=5");
        
        try {
            while(res.next()){
                modelo.addElement(res.getString("nombreEstud")); 
            }
            res.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\n"+e.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return modelo;
    }
    */
    
    
    
    
    

    
}
