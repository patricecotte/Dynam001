import java.awt.BorderLayout;
import java.awt.Color; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window12 extends JFrame{
/*
 * Window12 is invoked by the Sdz12 class
 */
		  private Panel12 pan12 = new Panel12();				
		  private Button12 b12 = new Button12("button #12");
		  private JPanel container = new JPanel();
		   
		  public Window12(){
		    this.setTitle("Customized buttons");
		    this.setSize(300, 300);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    container.setBackground(Color.white);
		    container.setLayout(new BorderLayout());
		    container.add(pan12, BorderLayout.CENTER);
		    container.add(b12, BorderLayout.SOUTH);
		    this.setContentPane(container);
		    this.setVisible(true);    
		    go();
		  }
		   
		  private void go(){  
		    //Les coordonn�es de d�part de notre rond
		    int x = pan12.getPosX(), y = pan12.getPosY();
		    //Le bool�en pour savoir si l'on recule ou non sur l'axe x
		    boolean backX = false;
		    //Le bool�en pour savoir si l'on recule ou non sur l'axe y
		    boolean backY = false;
		     
		    //Dans cet exemple, j'utilise une boucle while
		    //Vous verrez qu'elle fonctionne tr�s bien
		    while(true){
		      //Si la coordonn�e x est inf�rieure � 1, on avance
		      if(x < 1)backX = false;
		      //Si la coordonn�e x est sup�rieure � la taille du Panel moins la taille du rond, on recule
		      if(x > pan12.getWidth()-50)backX = true;
		      //Idem pour l'axe y
		      if(y < 1)backY = false;
		      if(y > pan12.getHeight()-50)backY = true;
		       
		      //Si on avance, on incr�mente la coordonn�e
		      if(!backX)
		        pan12.setPosX(++x);
		      //Sinon, on d�cr�mente
		      else
		        pan12.setPosX(--x);
		      //Idem pour l'axe Y
		      if(!backY)
		        pan12.setPosY(++y);
		      else
		        pan12.setPosY(--y);
		         
		      //On redessine notre Panel
		      pan12.repaint();
		      //Comme on dit : la pause s'impose ! Ici, trois milli�mes de seconde
		      try {
		        Thread.sleep(3);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }    
		  }  
		}	

