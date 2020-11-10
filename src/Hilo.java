import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
public class Hilo extends Thread{

	JPanel panel;
	int array[];
	JButton botones[];
	
	public Hilo(JPanel panel, int[] array)
	  {
		        this.panel = panel;
		        this.array = array;
	  }
	
	public void run() {
		int i, j, aux;
        for(i=0;i<array.length;i++) 
        {
             for(j=0;j<array.length-i-1;j++) 
             {
                  if(array[j+1]<array[j])
                  {
                     aux=array[j+1];
                     array[j+1]=array[j];
                     ((JButton)this.panel.getComponent(j+1)).setText(""+array[j]);
                     try {
						sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                     array[j]=aux;
                     ((JButton)this.panel.getComponent(j)).setText(""+aux);
                     try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  }
                  
             }
             this.panel.getComponent(array.length-i-1).setBackground(Color.pink);
             
             
        } 
	}
}
