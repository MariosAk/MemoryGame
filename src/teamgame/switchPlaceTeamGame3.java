/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import static teamgame.teamGame.counter1;
import static teamgame.teamGame.counter2;

/**
 *
 * @author admin
 */
public class switchPlaceTeamGame3 extends teamGame3 {
      int a;
        int b;
      
     JButton aButton ;
    JButton aButton2;
    JButton aButton3;
    ImageIcon img;
    int counter = 0;
    int numClicks = 0;
    String compare2;
    

    public switchPlaceTeamGame3(){
        super();
    }

    
     public void actionPerformed(ActionEvent e){
     button2 = (JButton) e.getSource();
 
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
                   if(p1 == true){
                   counter1 = counter1 + 1;
                   }
                   else if(p2 == true){
                      counter2 = counter2 + 1; 
                   }
                   else{
                       counter3 = counter3 + 1;
                   }
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
      }
    if((counter1 + counter2 + counter3) == 12){
      getContentPane().removeAll();
      repaint();
      winner();
         }   
   }
     
}
 

