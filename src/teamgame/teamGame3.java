/**
 * To aplo paixnidi me 3 paiktes. Klash pou klhronomei apo thn teamGame 
 */
package teamgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;
import static teamgame.teamGame.counter1;
import static teamgame.teamGame.counter2;

/**
 *
 * @author admin
 */
public class teamGame3 extends teamGame {

    /**
     * Creates new form teamGame3
     * Constructor
     */
    public teamGame3(){
        super();
        initComponents();
        setVisible(true);
    }
    
    
   /**
     *kaleitai otan oi 2 kartes pou anoixthkan einai diaforetikes
     * kai kleinei tis 2 kartes kai kanei prasino to eikonidio tou paikth
     * pou paizei meta
     */
    
     public Timer hideFace = new Timer(100,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            button2.setIcon(null);
            button3.setIcon(null);
           if(p1 == true){
               jButton1.setBackground(Color.GREEN);
               jButton3.setBackground(null);
           }
           else if(p2 == true){
               jButton2.setBackground(Color.GREEN);
               jButton1.setBackground(null);
           }
           else if(p3 == true){
               jButton3.setBackground(Color.GREEN);
               jButton2.setBackground(null);
           }
            }
        
    });
       public static int counter3 = 0 ;//metrhths twn kartwn tou player3
      public static boolean p3 = false;//einai true otan paizei o player3
    
    /**
     * Methodos pou kaleitai kathe fora pou enas paikths kanei klik sthn othonh.
     * Otan o paikths anoiksei mia karta to onoma ths k to jbutton pou vrisketai
     * apo8hkeuontai antistoixa se 2 metavlhtes. To idio tha ginei kai me thn 
     * deyterh karta. An oi 2 kartes einai idies kaleitai h faceMatch, an einai 
     * diaforetikes kaleitai h hideFace.
     * Epishs metraei poses kartes exei vrei o kathe paikths kai emfanizei mhnyma
     * me ton nikhth.
     */
      public void actionPerformed(ActionEvent e) {
    
    button2 = (JButton) e.getSource();
    
    for(int i=0; i<NUM_BUTTONS; i++){
          
        if(buttons[i].equals(button2))
        {
            buttons[i].setIcon(iconArray[intArray[i]]);
            if(boo == false)
            {
                compare = iconArray[intArray[i]].toString();
                boo = true;
                button3 = button2;
                button4 = button2;
                
            }
            else
            {
                if(compare == iconArray[intArray[i]].toString() && button4 != button2)  
                {
                   if(p1 == true){
                   counter1 = counter1 + 1;
                   }
                   else if(p2 == true){
                      counter2 = counter2 + 1; 
                   }
                   else{
                       counter3 = counter3 + 1;
                   }
                
                   faceMatch.setRepeats(false);
                   faceMatch.start();
                   
                }
                else if(compare != iconArray[intArray[i]].toString()&& button4!= button2)
                {
                    if(p1 == true){
                     p1 = false;
                     p2 = true;
                   }
                   else{
                      if(p2 == true){
                          p2 = false;
                          p3 = true;
                      }
                      else{
                          if(p3 == true){
                            p3 = false;
                            p1 = true;
                          }
                      }
                   }
                    hideFace.setRepeats(false);
                    hideFace.start();
                   
                }
                else
                {
                    button4.setIcon(iconArray[intArray[i]]);
                    boo = true;
                    break;
                }
                 boo = false;   
        
              }            
        }
      }
         if((counter1 + counter2 + counter3) == 12){
      getContentPane().removeAll();
      repaint();
      winner();
         }   
    }
      
      public void winner() {

        winLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       if((counter1 > counter2) && (counter1>counter3)){
        winLabel.setText("player 1 wins with " + counter1 + " ///player 2: " + counter2 + "///player 3:  "  + counter3);
       }
       else if((counter2 > counter1) && (counter2>counter3)){
           winLabel.setText("player 2 wins with " + counter2 + " ///player 1:  " + counter1 + " ///player 3: " + counter3);
       }
        else if ((counter3>counter1) && (counter3 > counter2)){
            winLabel.setText("player 2 wins with " + counter2 + " ///player 1:  " + counter1 + "///player 3: " + counter3);
        }
       else{
           winLabel.setText("YOU ARE TIE!!");
       }
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(winLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(winLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("Player 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(510, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

   
 
    public javax.swing.JButton jButton3;
   }