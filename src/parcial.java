
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class parcial {
    
    public static Connection conectar(){
        Connection con = null;
        try{
            String url ="jdbc:mysql://localhost:3306/BD_Multa?user=root&password=mysqladmin";
            con = DriverManager.getConnection(url);
            if (con != null){
                System.out.print("Conexion Satisfactoria");
            }
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return con;
    }
    public static void main(String[] args) {
   
        try{    
            JasperReport jr =(JasperReport)
            JRLoader.loadObject
            (parcial.class.getResource("./reporte.jasper"));
            Map parametros=new HashMap<String, Object>();
            JasperPrint jp = JasperFillManager.fillReport
                    (jr,parametros, conectar());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
            
        } catch(Exception e){
            System.err.print(e); 
        }
    }
    
    
}
