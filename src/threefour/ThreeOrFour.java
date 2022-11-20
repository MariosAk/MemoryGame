/**
 * Se authn thn parallagh yparxoun 3 h 4 antigrafa apo 12 diaforetikes kartes
 * kai o paikths prepei na ta vrei.
 */

package threefour;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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

public class ThreeOrFour extends JFrame implements ActionListener  {
    private JButton[] buttons;
    JButton button2;
    JButton button3= new JButton();
    JButton button4;
    JButton button5;
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 ;
    ImageIcon img;
    ImageIcon backing;
    JLabel jLabel1 ;
    final int NUM_BUTTONS = 42;
    ImageIcon iconArray[] = new ImageIcon[NUM_BUTTONS];
    int intArray[] = new int[NUM_BUTTONS];
    
    /**
    * Methodos pou vazei tis eikones s enan pinaka kai sthn synexeia 
    * xrhsimopoiwntas ena pinaka me tuxaious akeraious topothetei tis eikones 
    * tuxaia sta jbuttons.
    */
    
    public void randomizeIcons(){
        
        iconArray[0] = new ImageIcon("icons/apple.jpg");
        iconArray[1] = new ImageIcon("icons/apple.jpg");
        iconArray[2] = new ImageIcon("icons/apple.jpg");
        iconArray[3] = new ImageIcon("icons/balletstyl.jpg");
        iconArray[4] = new ImageIcon("icons/balletstyl.jpg");
        iconArray[5] = new ImageIcon("icons/balletstyl.jpg");
        iconArray[6] = new ImageIcon("icons/bear.jpg");
        iconArray[7] = new ImageIcon("icons/bear.jpg");
        iconArray[8] = new ImageIcon("icons/bear.jpg");
        iconArray[9] = new ImageIcon("icons/birds.jpg");
        iconArray[10] = new ImageIcon("icons/birds.jpg");
        iconArray[11] = new ImageIcon("icons/birds.jpg");
        iconArray[12] = new ImageIcon("icons/cake.jpg");
        iconArray[13] = new ImageIcon("icons/cake.jpg");
        iconArray[14] = new ImageIcon("icons/cake.jpg");
        iconArray[15] = new ImageIcon("icons/catglass.jpg");
        iconArray[16] = new ImageIcon("icons/catglass.jpg");
        iconArray[17] = new ImageIcon("icons/catglass.jpg");
        iconArray[18] = new ImageIcon("icons/ballon.jpg");
        iconArray[19] = new ImageIcon("icons/ballon.jpg");
        iconArray[20] = new ImageIcon("icons/ballon.jpg");
        iconArray[21] = new ImageIcon("icons/ballon.jpg");
        iconArray[22] = new ImageIcon("icons/bigaballoon.jpg");
        iconArray[23] = new ImageIcon("icons/bigaballoon.jpg");
        iconArray[24] = new ImageIcon("icons/bigaballoon.jpg");
        iconArray[25] = new ImageIcon("icons/bigaballoon.jpg");
        iconArray[26] = new ImageIcon("icons/bunny.jpg");
        iconArray[27] = new ImageIcon("icons/bunny.jpg");
        iconArray[28] = new ImageIcon("icons/bunny.jpg");
        iconArray[29] = new ImageIcon("icons/bunny.jpg");
        iconArray[30] = new ImageIcon("icons/candy.jpg");
        iconArray[31] = new ImageIcon("icons/candy.jpg");
        iconArray[32] = new ImageIcon("icons/candy.jpg");
        iconArray[33] = new ImageIcon("icons/candy.jpg");
        iconArray[34] = new ImageIcon("icons/cherry.jpg");
        iconArray[35] = new ImageIcon("icons/cherry.jpg");
        iconArray[36] = new ImageIcon("icons/cherry.jpg");
        iconArray[37] = new ImageIcon("icons/cherry.jpg");
        iconArray[38] = new ImageIcon("icons/ball.jpg");
        iconArray[39] = new ImageIcon("icons/ball.jpg");
        iconArray[40] = new ImageIcon("icons/ball.jpg");
        iconArray[41] = new ImageIcon("icons/ball.jpg");
        
    
        Random index = new Random();
        int rint = index.nextInt(40)+1;
        intArray[0] = rint;
        for(int i=1; i<intArray.length; i++){
            rint = index.nextInt(NUM_BUTTONS);
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
    
    public ThreeOrFour(){
        
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
          jLabel1 = new JLabel();     
        buttons = new JButton[NUM_BUTTONS];
        GridLayout grid = new GridLayout(6, 7 ,10 ,20);
        setLayout(grid);
        for (int i = 0; i < NUM_BUTTONS ;i++) {
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
     *kaleitai an oi 3 h 4 kartes einai diaforetikes kai tis kleinei.
     */
        
    Timer hideFace = new Timer(100,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            button2.setIcon(null);
            button3.setIcon(null);
            button5.setIcon(null);
            button7.setIcon(null);  
            steps = steps + 1;
        }
    });
    
    /**
     * kaleitai an oi 3 h 4 kartes einai idies kai tis afhnei anoixtes.
     */
    
    Timer faceMatch = new Timer(100,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            button2.setEnabled(false);
            button3.setEnabled(false);
            button5.setEnabled(false);
            button7.setEnabled(false);
            steps = steps + 1;
            counter = counter + 1;
        }
    });
           
   
    
       int steps = 0;//metriths gia ta vhmata pou exei kanei o paixths mexri na kerdisei
       int counter = 0;//metriths gia ta zeugaria pou exei vrei o paixths
       boolean boo = false;
       boolean boo2 = false;
       boolean boo3 = false;
       String compare;
       String compare2;
    
       /**
     * Methodos pou kaleitai me kathe klik pou kanei o paikths. Anoigei h prwth karta kai apo8hkeyontai se 2 metaulhtes
     * to onoma ths eikonas kai to jbuuton ths. Anoigei deuterh karta apo8hkeyetai to onoma to onoma k to jbutton ths se
     * 2 alles metavlhtes kai sugkrinetai me thn prwth. An einai idies anoigei trith karta k sygkrinontai k an einai k auth 
     * idia psaxnei an yparxei tetarth. An einai oles idies kaleitai h faceMatch. An einai diaforetikes kaleitai h hideFace. 
     */
       
    @Override
    public void actionPerformed(ActionEvent e) {
    button2 = (JButton) e.getSource();
    loop:
    for(int i=0; i<NUM_BUTTONS; i++){
          
        if(buttons[i].equals(button2))    
        {
           buttons[i].setIcon(iconArray[intArray[i]]);
            if(boo3 == true){
                if(compare2 == iconArray[intArray[i]].toString()){
                faceMatch.setRepeats(false);
                faceMatch.start();
                boo3 = false;
                break;
                }
                else{
                    hideFace.setRepeats(false);
                    hideFace.start();
                    boo3 = false;
                    break;
                }
            }
        else{
                button7 = button2;
            }
        if(boo2 == true){   
             if(compare == iconArray[intArray[i]].toString() && (button5 != button2) && (button4 != button2)){ 
                 for(int j=0; j<42; j++){
                     if((iconArray[j].toString() == iconArray[intArray[i]].toString()) && (j<=17)){
                           faceMatch.setRepeats(false);
                           faceMatch.start();
                
                 boo2 = false;
                 break loop;
                     }
                     else if((iconArray[j].toString() == iconArray[intArray[i]].toString()) && (j>17) ){
                        
                        compare2 = iconArray[intArray[i]].toString();
                        boo3 = true;
                        boo2 = false;
                        break loop;
                     }
                     
                     }
             }
        else if (compare != iconArray[intArray[i]].toString() && (button5 != button2) && (button4 != button2)){
                 
                 hideFace.setRepeats(false);
                 hideFace.start();
                 boo2 = false;
                 
                 break;
             }
            }
        else{
                button5 = button2;
               
            }
        if(boo == false && (button6 != button2)){
                compare = iconArray[intArray[i]].toString();
                boo = true;
                button3 = button2;
                button4 = button2;
                       
        }
        else{
                if(compare == iconArray[intArray[i]].toString() && (button4 != button2) )  
                {
                  button6 = button2;
                   boo2 = true;
                }
                else if(compare != iconArray[intArray[i]].toString() && (button4!= button2))
                {
                    
                    
                    hideFace.setRepeats(false);
                    hideFace.start();
                    
                }
                else
                {
                    boo = true;
                    break;
                }
                 boo = false;   
            }            
        }
                if(counter == 12){
            getContentPane().removeAll();
            repaint();
           jLabel1 = new JLabel("It took you " + steps + " moves to finish the game!!",SwingConstants.CENTER);
            add(jLabel1);
            
            jLabel1.setVisible(true);
        }
      }      
    }
}
