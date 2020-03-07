
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static parcial.conectar;


public class FrmReport extends javax.swing.JFrame {

 
    public FrmReport() {
        initComponents();
    }

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
    
    void mostrar() {
        Statement st = null;
        DefaultTableModel mdltabla = new DefaultTableModel();
        mdltabla.addColumn("DNI");
        mdltabla.addColumn("multa");
        mdltabla.addColumn("monto");
        mdltabla.addColumn("correo");
        tblReporte.setModel(mdltabla);
        String[] dato = new String[4];
        try {
            st = conectar().createStatement();
            String query = "select * from multas where DNI=" + txtDNI.getText();
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                dato[0] = res.getString(1);
                dato[1] = res.getString(2);
                dato[2] = res.getString(3);
                dato[3] = res.getString(4);
                mdltabla.addRow(dato);

            }
        } catch (Exception e) {
        }
        
        void insertar() {
        try {
            String Query = "call usp_insert(? , ?, ?, ?)";
            PreparedStatement ps = conectar().prepareStatement(Query);
            ps.setString(1, txtDNI.getText());
            ps.setString(2, dbomulta.toString());
            ps.setString(3, txtmonto.getText());
            ps.setString(4, txtcorreo.getText());
            ps.executeUpdate();
            conectar().close();
            JOptionPane.showMessageDialog(null, "se agrego el producto");
            mostrartodo();

        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        void mostrartodo() {
        Statement st = null;
        DefaultTableModel mdltabla = new DefaultTableModel();
        mdltabla.addColumn("DNI");
        mdltabla.addColumn("multa");
        mdltabla.addColumn("monto");
        mdltabla.addColumn("correo");
        tblReporte.setModel(mdltabla);
        String[] dato = new String[4];
        try {
            st = conectar().createStatement();
            String query = "select * from multas ";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                dato[0] = res.getString(1);
                dato[1] = res.getString(2);
                dato[2] = res.getString(3);
                dato[3] = res.getString(4);
                mdltabla.addRow(dato);

            }
        } catch (Exception e) {
        }
    }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtDNI = new javax.swing.JTextField();
        txtmonto = new javax.swing.JTextField();
        dbomulta = new javax.swing.JComboBox<>();
        txtcorreo = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dbomulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta Velocidad", "Pasar luz roja", "Estacionar en zona Prohibida", "Pico Placa" }));

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblReporte);

        jLabel1.setText("DNI");

        jLabel2.setText("Multa");

        jLabel3.setText("Monto");

        jLabel4.setText("Correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDNI)
                            .addComponent(txtmonto, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dbomulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcorreo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbomulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnReporte))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed

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
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        insertar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> dbomulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblReporte;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
