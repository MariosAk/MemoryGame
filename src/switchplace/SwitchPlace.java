/**
 * S aythn thn parallagh o paikths paizei to aplo paixnidi
 * alla kathe fora pou anoigei 2 kartes autes allazoun thesh metaksu tous.
 * H klash klhronomei apo thn project
 */
package switchplace;
import SoloGame.soloGame;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 *
 * @author admin
 */
public class SwitchPlace extends soloGame{
     JButton aButton;
    JButton aButton2;
    JButton aButton3;
    
    /**
     * Constuctor
     */
    
    
    public SwitchPlace(){
        super();
        JButton aButton = new JButton();
    JButton aButton2= new JButton();
    JButton aButton3= new JButton();
    }
    
    int a;//apo8hkeuetai to i ths deuterhs kartas pou anoigei gia na mporoume na vroume th thesh thn eikona ston pinaka
    int b;//apo8hkeuetai to i ths prwths kartas pou anoigei gia na mporoume na vroume th thesh thn eikona ston pinaka
    String compare2;
    
     public void actionPerformed(ActionEvent e){
     button2 = (JButton) e.getSource();
 
     /**
     * Methodos pou kaleitai kathe fora pou enas paikths kanei klik sthn othonh.
     * Otan o paikths anoiksei mia karta to onoma ths k to jbutton pou vrisketai
     * apo8hkeuontai antistoixa se 2 metavlhtes. To idio tha ginei kai me thn 
     * deyterh karta. An oi 2 kartes einai idies kaleitai h faceMatch, an einai 
     * diaforetikes kaleitai h hideFace kai h duo kartes allazoun thesh metaksu tous.
     */
     
    for(int i=0; i<NUM_BUTTONS; i++){
          
        if(buttons[i].equals(button2))
            
        {
            buttons[i].setIcon(iconArray[intArray[i]]);
            if(boo == false)
            {
                compare = iconArray[intArray[i]].toString();
                b=i;
                boo = true;
                button3 = button2;
                button4 = button2;
                aButton =button2;
                
            }
            else
            {
                if(compare == iconArray[intArray[i]].toString() && button4 != button2)  
                {
                    counter = counter + 1;
                     compare2 = iconArray[intArray[i]].toString();
                   faceMatch.setRepeats(false);
                   faceMatch.start();
                   
                   
                }
                else if(compare != iconArray[intArray[i]].toString()&& button4!= button2)
                {
                     compare2 = iconArray[intArray[i]].toString();
                      a = i;
                      aButton3 = button2;
                   img = (iconArray[intArray[a]]);
                   (iconArray[intArray[a]]) = (iconArray[intArray[b]]);
                   (iconArray[intArray[b]]) = img;
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
                  numClicks = numClicks + 1;
              }            
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
