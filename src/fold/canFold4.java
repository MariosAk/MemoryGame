/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fold;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import static teamgame.teamGame.counter1;
import static teamgame.teamGame.counter2;
import static teamgame.teamGame3.counter3;
import static teamgame.teamGame3.p3;
import teamgame.teamGame4;
import static teamgame.teamGame4.counter4;

/**
 *
 * @author admin
 */
public class canFold4 extends teamGame4 {
public JButton selectButton;
public JLabel winLabel;
    public Timer fold = new Timer(300,new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(selectButton != null){
       selectButton.setIcon(null);
       
       if(p1 == true){
               jButton2.setBackground(Color.GREEN);
               jButton1.setBackground(null);
               p1 = false;
               p2 = true;
           }
       else if(p2 == true){
               jButton3.setBackground(Color.GREEN);
               jButton2.setBackground(null);
               p3 = true;
               p2 = false;
           }
       else if(p3 == true){
           jButton4.setBackground(Color.GREEN);
           jButton3.setBackground(null);
           p4 = true;
           p3=false;
       }
       else{
           jButton1.setBackground(Color.GREEN);
           jButton4.setBackground(null);
           p4 =false;
           p1 = true;
       }
       selectButton = null;
        }
    }
});
    


    /**
     * Creates new form canFold4
     */
    public canFold4() {
        super();
        initComponents();
        jButton83.addActionListener(this);
       selectButton = null;
       winLabel = new JLabel();
       setVisible(true);
    }

     public void actionPerformed(ActionEvent e) {
    
    button2 = (JButton) e.getSource();
    
    for(int i=0; i<NUM_BUTTONS; i++){
        if(jButton83.equals(button2)){
            fold.setRepeats(false);
            fold.start();
            
            compare = null;
            boo = false;
            break;
        }     
        if(buttons[i].equals(button2))
        {
            buttons[i].setIcon(iconArray[intArray[i]]);
            selectButton = button2;
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
                   else if(p3 == true){
                       counter3 = counter3 + 1;
                   }
                   else{
                       counter4 = counter4 + 1;
                   }
                
                   faceMatch.setRepeats(false);
                   faceMatch.start();
                   selectButton = null;
                   
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
                            p4 = true;
                          }
                          else{
                              if(p4 == true){
                                  p4 = false;
                                  p1 = true;
                              }
                          }
                      }
                   }
                    hideFace.setRepeats(false);
                    hideFace.start();
                   selectButton = null;
                }
                else
                {
                    button4.setIcon(iconArray[intArray[i]]);
                    boo = true;
                    selectButton = null;
                    break;
                }
                 boo = false;   
        
              }            
        }
      }
         if((counter1 + counter2 + counter3 + counter4) == 12){
             getContentPane().removeAll();
             repaint();
             winner();
         }
    }
     
    
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton83 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton83.setText("Fold");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(510, Short.MAX_VALUE)
                .addComponent(jButton83)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                                           
    private javax.swing.JButton jButton83;
                   
}
