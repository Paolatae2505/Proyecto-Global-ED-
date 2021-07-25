import java.util.*;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paola Vargas Bravo
 */
public class Consulta extends javax.swing.JFrame {
    
     public  List<File> docs;
     public Busqueda busqueda = new Busqueda();
     public  List<String> resultados;
     public  String consulta ;
     public Map<String, List<String>> cache;
     public  Resultados resultadosFinales;

    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
           setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areadeTexto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Digite su busqueda :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 17, -1, -1));

        areadeTexto.setBackground(new java.awt.Color(255, 204, 255));
        areadeTexto.setColumns(20);
        areadeTexto.setRows(5);
        jScrollPane2.setViewportView(areadeTexto);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 310, 50));

        jButton1.setText("consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 102, 120, -1));
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 490, 40));

        jButton2.setText("Resulatdos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 190, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setDocumentos(List<File> docs){
        this.docs = docs;
    }
    
    public List<String> getResultados(){
        return resultados;
    }
    
    public String getConsulta(){
        return consulta;
    }
    
    public void setCache( Map<String, List<String>> cache){
        this.cache = cache;
    }
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        consulta = areadeTexto.getText();
        new Historial().addConsulta(consulta);
        resultadosFinales = new Resultados();
        cache = new HashMap<>();
        
    System.out.println(cache.size());
    System.out.println(cache.isEmpty());
       if(cache.isEmpty()){
              resultados = busqueda.compara(docs,consulta);
              resultadosFinales.setStringFinales(resultados); 
             cache.put(consulta, resultados);
             System.out.println(cache.size()); 
       }else{
          resultados = busqueda.containsCache(cache, consulta);
          
          if(resultados == null){
            resultados =  busqueda.compara(docs, consulta);
            cache.put(consulta, resultados);
            resultadosFinales. setStringFinales(resultados);
          }else{
         resultadosFinales.setStringFinales(resultados);
             
          }
       }
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
               resultadosFinales.setVisible(true);
               setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areadeTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
