/**
 * Auth einai h aplh parallagh tou paixnidiou. Yparxoun 12 zeugaria diaforerikwn
 * kartwn k enas paikths pou prospathei na vrei ta zeugaria.
 */
package SoloGame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
/**
 *
 * @author admin
 */
public class soloGame extends JFrame implements ActionListener {
    public JLabel jLabel1;
    public JButton[] buttons;
   public JButton button2;
   public JButton button3= new JButton();
   public JButton button4;
   public JButton button5;
   public ImageIcon img;
   public ImageIcon backing;
   public final int NUM_BUTTONS = 24;
   public ImageIcon iconArray[] = new ImageIcon[NUM_BUTTONS];
   public int intArray[] = new int[NUM_BUTTONS];
   
    /**
    * Methodos pou vazei tis eikones s enan pinaka kai sthn synexeia 
    * xrhsimopoiwntas ena pinaka me tuxaious akeraious topothetei tis eikones 
    * tuxaia sta jbuttons.
    */
   
   public void randomizeIcons(){
        
        iconArray[0] = new ImageIcon("icons/apple.jpg");
        iconArray[1] = new ImageIcon("icons/apple.jpg");
        iconArray[2] = new ImageIcon("icons/ball.jpg");
        iconArray[3] = new ImageIcon("icons/ball.jpg");
        iconArray[4] = new ImageIcon("icons/balletstyl.jpg");
        iconArray[5] = new ImageIcon("icons/balletstyl.jpg");
        iconArray[6] = new ImageIcon("icons/ballon.jpg");
        iconArray[7] = new ImageIcon("icons/ballon.jpg");
        iconArray[8] = new ImageIcon("icons/bear.jpg");
        iconArray[9] = new ImageIcon("icons/bear.jpg");
        iconArray[10] = new ImageIcon("icons/bigaballoon.jpg");
        iconArray[11] = new ImageIcon("icons/bigaballoon.jpg");
        iconArray[12] = new ImageIcon("icons/birds.jpg");
        iconArray[13] = new ImageIcon("icons/birds.jpg");
        iconArray[14] = new ImageIcon("icons/bunny.jpg");
        iconArray[15] = new ImageIcon("icons/bunny.jpg");
        iconArray[16] = new ImageIcon("icons/cake.jpg");
        iconArray[17] = new ImageIcon("icons/cake.jpg");
        iconArray[18] = new ImageIcon("icons/candy.jpg");
        iconArray[19] = new ImageIcon("icons/candy.jpg");
        iconArray[20] = new ImageIcon("icons/catglass.jpg");
        iconArray[21] = new ImageIcon("icons/catglass.jpg");
        iconArray[22] = new ImageIcon("icons/cherry.jpg");
        iconArray[23] = new ImageIcon("icons/cherry.jpg");
         
        Random index = new Random();
        int rint = index.nextInt(22)+1;
        intArray[0] = rint;
        for(int i=1; i<intArray.length; i++){
            rint = index.nextInt(24);
            for(int j=0; j<i; j++){
                if(intArray[j] == rint){
                    i--;
                    break;
                }
                else{
                    intArray[i] = rint;
                }
              
            }
          
        }
                
        
     
    }


/**
     * Constructor
     */

public soloGame(){
        
        setSize(300,300);
       setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        jLabel1 = new JLabel();
        buttons = new JButton[NUM_BUTTONS];
        GridLayout grid = new GridLayout(4, 6 ,10 ,20);
        setLayout(grid);
        for (int i = 0; i < NUM_BUTTONS;i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(65,100));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        
        pack();
        
        setVisible(true);
        randomizeIcons();
        
        
        
    }


      /**
     * kaleitai otan oi 2 kartes pou anoixthkan einai diaforetikes
     * kai kleinei tis 2 kartes
     */

 public Timer hideFace = new Timer(100,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            button2.setIcon(null);
            button3.setIcon(null);
            
        }
    });
 
 
 
    /**
    *kaleitai otan oi 2 kartes einai idies kai tis afhnei anoixtes. 
    */
 
 public  Timer faceMatch = new Timer(100,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            button2.setEnabled(false);
            button3.setEnabled(false);
        }
    });
 
 public  boolean boo = false;//einai pseydhs otan anoigoume 1h karta, sthn 2h karta einai alh8hs kai meta pali pseudhs
     public String compare;//apothekeuei t onoma ths eikonas pou exei h karta gia na to sygkrinei me thn epomenh
     public int numClicks = 0;//metrhths gia tis kartes pou exei anoiksei
     public int  counter = 0;//metrhths gia ta zugaria pou exei vrei o paikths
     
     /**
     * Methodos pou kaleitai kathe fora pou enas paikths kanei klik sthn othonh.
     * Otan o paikths anoiksei mia karta to onoma ths k to jbutton pou vrisketai
     * apo8hkeuontai antistoixa se 2 metavlhtes. To idio tha ginei kai me thn 
     * deyterh karta. An oi 2 kartes einai idies kaleitai h faceMatch, an einai 
     * diaforetikes kaleitai h hideFace.
     */

@Override
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
                    counter = counter + 1;
                   faceMatch.setRepeats(false);
                   faceMatch.start();
                   
                }
                else if(compare != iconArray[intArray[i]].toString()&& button4!= button2)
                {
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
            numClicks = numClicks + 1;
        }
        if(counter == 12){
            getContentPane().removeAll();
            repaint();
           jLabel1 = new JLabel("It took you " + numClicks + " moves to finish the game!!",SwingConstants.CENTER);
            add(jLabel1);
            
            jLabel1.setVisible(true);
        }
      }
            
    }



}