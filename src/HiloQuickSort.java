import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HiloQuickSort extends Thread{
	static JPanel panel;
	int array[];
	JButton botones[];
	
	public HiloQuickSort(JPanel panel, int[] array)
	  {
		        this.panel = panel;
		        this.array = array;
	  }
	
	public void run() {
		for(int vuelta = 0; vuelta<2; vuelta++) {
			quicksort(array, 0, array.length-1);
		}
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void quicksort(int array[], int izq, int der) {

		  int pivote=array[izq]; // tomamos primer elemento como pivote
		  int i=izq;         // i realiza la búsqueda de izquierda a derecha
		  int j=der;         // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i < j){                          // mientras no se crucen las búsquedas                                   
		     while(array[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
		     while(array[j] > pivote) j--;           // busca elemento menor que pivote
		     if (i < j) {                        // si no se han cruzado                      
		         aux= array[i];                      // los intercambia
		         array[i]=array[j];
		         array[j]=aux; 
		         ((JButton)panel.getComponent(i)).setText(""+ array[i]);
		         panel.getComponent(i).setBackground(Color.cyan);
		         ((JButton)panel.getComponent(j)).setText(""+ array[j]);
		         panel.getComponent(j).setBackground(Color.CYAN);
		         try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
		   }
		   
		   array[izq]=array[j];      // se coloca el pivote en su lugar de forma que tendremos		   
		   array[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
		   ((JButton)panel.getComponent(j)).setText(""+ pivote);
		   panel.getComponent(j).setBackground(Color.CYAN);
		   if(izq < j-1)
		      quicksort(array,izq,j-1);          // ordenamos subarray izquierdo
		   if(j+1 < der)
		      quicksort(array,j+1,der);          // ordenamos subarray derecho
		   
		}
}
