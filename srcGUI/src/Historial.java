import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interfaz que maneja el Historial de busqueda
 * @author Barón Herrera Helena Victoria
 * @author Vargas Bravo Paola
 * @version 1.0 (17 de Julio 2021)
 * @since Estructuras de datos 2021-2.
 */
public class Historial extends javax.swing.JFrame {
    public static List<String> consultas = new ArrayList<>();
    /**
     * Creates new form Historial
     */
    public Historial() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        areaTexto.setEditable(false);
        imprimeHistorial();
    }
    
    public void addConsulta(String consulta){
        for(String c : consultas){
                if(c == consulta){
                    consultas.remove(c);
                    break;
                }
        }
        consultas.add(0, consulta);
    }
    
    public  void imprimeHistorial(){
        String t = "";
        if(consultas.isEmpty()){
            areaTexto.setText("No has realizado ninguna búsqueda.");
        } else {
            for(String c : consultas){
                t+= c+ "\n";
            }
          areaTexto.setText(t);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        listo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Cambria", 2, 26)); // NOI18N
        titulo.setForeground(new java.awt.Color(204, 255, 255));
        titulo.setText("HISTORIAL");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, 40));

        areaTexto.setBackground(new java.awt.Color(204, 204, 255));
        areaTexto.setColumns(20);
        areaTexto.setForeground(new java.awt.Color(0, 0, 0));
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 220, 300));

        listo.setBackground(new java.awt.Color(204, 153, 255));
        listo.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        listo.setForeground(new java.awt.Color(102, 102, 255));
        listo.setText("Listo");
        listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listoActionPerformed(evt);
            }
        });
        getContentPane().add(listo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    /**
     * @param args the command line arguments
     */
    private void listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listoActionPerformed
        setVisible(false);
        new InterfazGrafica().setVisible(true);
    }//GEN-LAST:event_listoActionPerformed

    /**
     * Main que ejecuta la interfaz de Historial 
     * @author Barón Herrera Helena Victoria
     * @author Vargas Bravo Paola
     * @version 1.0 (17 de Julio 2021)
     * @since Estructuras de datos 2021-2.
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
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea areaTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
