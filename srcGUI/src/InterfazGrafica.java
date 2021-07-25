
import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoria
 */
public class InterfazGrafica extends javax.swing.JFrame {
    
 public int choose;
 public Icon imagen;
 public List<File> documentos = new ArrayList<>();

    /**
     * Creates new form InterfazGrafica
     */
    public InterfazGrafica() {
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

        tittle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rosaFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tittle.setFont(new java.awt.Font("Cambria", 2, 36)); // NOI18N
        tittle.setForeground(new java.awt.Color(255, 153, 255));
        tittle.setText("ClockWork Princess");
        getContentPane().add(tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 360, 30));

        jButton1.setBackground(new java.awt.Color(255, 204, 255));
        jButton1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setText("1.Buscar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 170, 30));

        jButton2.setBackground(new java.awt.Color(153, 0, 255));
        jButton2.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 153, 255));
        jButton2.setText("2.Historial");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 170, 30));

        jButton3.setBackground(new java.awt.Color(51, 0, 51));
        jButton3.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 204, 204));
        jButton3.setText("3.Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 170, 30));

        jLabel1.setFont(new java.awt.Font("Cambria", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 255));
        jLabel1.setText("Pulse su Opción...");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 190, -1));

        rosaFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesInterfaz/Beauty and the beast.jpg"))); // NOI18N
        rosaFondo.setText("jLabel1");
        getContentPane().add(rosaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 452, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BUTTON1
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     /// Nada por ahora 
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
       imagen =  new ImageIcon(getClass().getResource("/ImagenesInterfaz/takeRose.jpg"));
                        //JOptionPane.showMessageDialog(null,"Adios!");

                  JOptionPane.showMessageDialog(null, "Adios!", "Clockwork Princess off",
                        JOptionPane.INFORMATION_MESSAGE,imagen );
           System.exit(0);
          //dispose();
       
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
 
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         Consulta consulta = new Consulta();
        consulta.setDocumentos(documentos);
        consulta.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked
     public void setDocsFiles(List<File> documentos){
         this.documentos = documentos;
     }
     public static List<File> getFiles(Scanner entrada) {
        String path = "";
        File directorio = null;
        boolean allow = false;

        while (!allow) {
            //System.out.println("Digite la ruta del directorio: ");
            //entrada.nextLine();
            try {
                path = JOptionPane.showInputDialog("Digite la ruta del directorio:", "Ruta");
                path = path.trim();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Usted cancelo la ejecución", "Clockwork Princess OFF",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } catch (Exception ex){
                  JOptionPane.showMessageDialog(null, "Usted cancelo la ejecución", "Clockwork Princess OFF",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            directorio = new File(path);
            if (directorio.isDirectory() && directorio.exists()) {
                allow = true;
            } else {
                allow = false;
                JOptionPane.showMessageDialog(null, "Su directorio no existe",
                        "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
        }
        File[] listFiles = directorio.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        return Arrays.asList(listFiles);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ///// Atributos ////////
      List<File> docs = new ArrayList<>();
        List<String> resultados;
        List<String> historial = new ArrayList<>();
        Map<String, List<String>> cache = new HashMap<>();
        Scanner entrada = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String consulta;
       boolean isRunning = true;
        String subPattern = "";
        boolean iniciar = false;
        boolean op = true;
        int choose;
        int len;
        
            docs = getFiles(entrada);
     
                while (docs.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Su esta carpeta vacío",
                            "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                    getFiles(entrada);
                }
             new InterfazGrafica().setDocsFiles(docs);
             new Consulta().setCache(cache);
      
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
          
       /// System.exit(0);
        
        
    
          
        }
        
     
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel rosaFondo;
    private javax.swing.JLabel tittle;
    // End of variables declaration//GEN-END:variables
}
