import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HiloSeleccion extends Thread{
	JPanel panel;
	int array[];
	JButton botones[];
	
	public HiloSeleccion(JPanel panel, int[] array)
	  {
		        this.panel = panel;
		        this.array = array;
	  }
	
	public void run (){
		int i, j, menor, pos, tmp;
		
        for (i = 0; i < array.length; i++) 
        {      
              menor = array[i];                                
              pos = i;                            
              for (j = i + 1; j < array.length; j++)
              { 
                    if (array[j] <= menor) 
                    {           
                        menor = array[j];             
                        pos = j;   
                    }
              }
              if (pos != i)
              {                                          
                  tmp = array[i];
                  array[i] = array[pos];
                  array[pos] = tmp;                
   
              }
              ((JButton)this.panel.getComponent(i)).setText(""+ array[i]);
              try {
					sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              this.panel.getComponent(i).setBackground(Color.green);
        }
	}
        
}
