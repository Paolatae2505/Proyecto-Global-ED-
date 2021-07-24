import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CloockWorkPrincess extends JFrame{
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JTextField jTextField1;
    private JButton jButton1 ;
    private JButton jButton2 ;
    private JButton jButton3 ;
    private int choose;
    private JDialog cerrado;


    public CloockWorkPrincess(){
        setLayout(null);
        inicialitation();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,450,655);
        setResizable(false);
         setLocationRelativeTo(null);
         setTitle("Menu");
    }

    public void setChoose(int choose){
        this.choose = choose;
    }

    public int getChoose(){
        return choose;
    }
    private void inicialitation(){
        operationsLabes();
      //  colocarText();
        colocarButton();
    }

    private void operationsLabes(){
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel7 = new JLabel();
        jTextField1 = new JTextField();
        jLabel1.setBackground(new Color(255, 102, 255));
        jLabel1.setFont(new Font("Dialog", 3, 31)); // NOI18N
        jLabel1.setForeground(new Color(255, 153, 255));
        jLabel1.setText("ClockWorkPrincess");
        jLabel1.setBounds(80,70,300,30);
        add(jLabel1);
        jLabel2.setFont(new Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new Color(255, 153, 255));
        jLabel2.setText("Menu");
        jLabel2.setBounds(190,165,100,30);
        add(jLabel2);
        /** 
        jLabel3.setFont(new Font("Dialog", 2, 25)); // NOI18N
        jLabel3.setForeground(new Color(51, 0, 51));
        jLabel3.setText("1.Buscar");
        jLabel3.setBounds(170,450,100,30);
        add(jLabel3);
        jLabel4.setFont(new Font("Dialog", 2, 25)); // NOI18N
        jLabel4.setForeground(new Color(204, 102, 255));
        jLabel4.setBounds(170,475,300,30);
        jLabel4.setText("2.Historial");
        add(jLabel4);
        jLabel5.setFont(new Font("Dialog", 2, 25)); // NOI18N
        jLabel5.setForeground(new Color(204, 153, 255));
        jLabel5.setBounds(170,500,100,30);
        jLabel5.setText("3.Salir");
        add(jLabel5); 
        */
        jLabel7.setFont(new Font ("Dialog", 2, 24)); // NOI18N
        jLabel7.setForeground(new Color(102, 0, 153));
        jLabel7.setText("Pulse su opcion");
        jLabel7.setBounds(140,420,300,30);
        add(jLabel7);
        jLabel6 = new JLabel(new ImageIcon("Beauty and the beast.jpg"));
        jLabel6.setBounds(0,0,450,655);
        add(jLabel6); 
   

    }

    private void colocarText(){
        jTextField1 = new JTextField();
        jTextField1.setBounds(170,550,100,30);
        jTextField1.setBackground(new Color(255, 153, 255));
        jTextField1.setForeground(new Color(51, 0, 51));
        //jTextField1.setText("Digite su numero ...");
       // jTextField1.setEditable(true);
        add(jTextField1);
        //eventosDelTeclado();
    }

    private void colocarButton (){
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        /////////////////////////////
        jButton1.setText("1.Buscar");
        jButton1.setBounds(160,480,150,30);
        jButton1.setBackground(new Color(255, 204, 255));
        jButton1.setFont(new Font("Dialog", 2, 22)); // NOI18N
        jButton1.setForeground(new Color(102, 0, 102));
        add(jButton1);
        jButton2.setText("2.Historial");
        jButton2.setBounds(160,520,150,30);
        jButton2.setBackground(new Color(102, 0, 102));
        jButton2.setFont(new Font("Dialog", 2, 22)); // NOI18N
        jButton2.setForeground(new Color(255, 153, 255));
        add(jButton2);
        jButton3.setBounds(160,560,150,30);
        jButton3.setBackground(new Color(204, 153, 255));
        jButton3.setFont(new Font("Dialog", 2, 22)); // NOI18N
        jButton3.setForeground(new Color(255, 51, 255));
        jButton3.setText("3.Salir");
        add(jButton3);

    
        ActionListener event1 = new ActionListener(){
           public void actionPerformed(ActionEvent e){
                setChoose(1);
               // System.out.println(getChoose());
               dispose();
           }

        };
        
        ActionListener event2 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 setChoose(2);
                 //cerrado = new JDialog(this,true);
                dispose();
            }
 
         };
         
        ActionListener event3 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 setChoose(3);
                dispose();
            }
         };

        jButton1.addActionListener(event1);
        jButton2.addActionListener(event2);
        jButton3.addActionListener(event3);
    
    } 
public static void main(String[] args) {
        CloockWorkPrincess princess = new CloockWorkPrincess();
        princess.setVisible(true);
        System.out.println(princess.getChoose());

     

        
    }





    
}
