/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */  
  
package comenzales;  
import java.awt.Color;
import java.util.Random;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
/** 
 * 
 * @author 
 */  
public class Filosofo implements Runnable{  
int id;  
Thread t;  
JButton filosofo;
JLabel derecho;
JLabel izquierdo;
Filosofo(int id,JLabel izquierdo, JLabel derecho,JButton filosofo){  
    this.id = id;  
    this.derecho = derecho;  
    this.izquierdo = izquierdo;  
    this.filosofo=filosofo;
    t = new Thread(this);
    t.start();  
    
}  
public void  run(){ 
    for(int i =0;i<3;i++){  
        synchronized(this.izquierdo){  
           synchronized(this.derecho){  
             comer();     
            } 
        }
        pensar();  
    } 
   
}  
void comer () {  
    derecho.setText("Ocupado");
    derecho.setForeground(Color.red);
  
    izquierdo.setText("Ocupado");
    izquierdo.setForeground(Color.red);
    
    filosofo.setText("Comiendo");
    filosofo.setBackground(Color.GREEN);

    System.out.println("\tFilosofo "+id+ " comiendo");  
    try{  
        Thread.sleep(5000);  
    }catch(InterruptedException e){  
    }
    derecho.setText("Libre");
    derecho.setForeground(Color.black);
    
    izquierdo.setText("Libre");
    izquierdo.setForeground(Color.black);
    
    filosofo.setText("Pensando");   
    filosofo.setBackground(Color.DARK_GRAY);
    System.out.println("\tFilosofo "+id+ " deja de comer para pensar liberando los tenedores"+ this.izquierdo.getName()+" y "+this.derecho.getName());  
}  
void pensar(){  
    derecho.setText("Libre");
    derecho.setForeground(Color.black);
    
    izquierdo.setText("Libre");
    izquierdo.setForeground(Color.black);
    
    filosofo.setText("Pensando");   
    filosofo.setBackground(Color.DARK_GRAY);

    try{  

        Thread.sleep(5000);  
    }catch(InterruptedException e){  
    }          
}  

}  