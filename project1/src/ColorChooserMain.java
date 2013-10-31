


import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.security.auth.callback.Callback;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooserMain {

	public static void main(String[] args) throws Exception {
		JFrame jf = new JFrame();
		Color jfcolor = null;
		ColorChooserMain ccm = new ColorChooserMain();
		ColorChooserDemo jfccd = new ColorChooserDemo();
		/*
		 * Threading 
		 */
		Thread t = new Thread(jfccd.new RunImpl(jfccd, jfcolor));
		t.start();
//		System.print.out("chosen color: "+thiscolor);
		jf.add(jfccd);
		jf.pack();
		jf.setVisible(true);
		
		/*
		 * call service
		 */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Color> jfccdout = executor.submit(jfccd.new Task());
        System.out.println(jfccdout.get()); // Prints "result" after 2 secs.

        // Or if you have multiple tasks.
        // List<Future<String>> futures = executor.invokeAll(Arrays.asList(new Task()));
        // for (Future<String> future : futures) {
        //     System.out.println(future.get());
        // }

        executor.shutdown(); // Important!
        System.out.println("newcolor afer callable: "+jfccdout);
        
        
        // Callbacks examples with the interface instream 
        Caller caller = ccm.new Caller();

        Fruit apple = ccm.new Apple(); // Apple version of Fruit

        Fruit banana = ccm.new Banana(); // Banana version of Fruit

        caller.register(apple); // displays "Callback - Apple"

        caller.register(banana); // displays "Callback - Banana"
        

	} // End of main

	/*
	 *  Implement a callback mechanism
	 */
	
	interface Fruit {

		void callback_method();

		}

	public class Apple implements Fruit {

			public void callback_method() {

				System.out.println("Callback - Apple");

			}

		}

		public class Banana implements Fruit {

			public void callback_method() {

				System.out.println("Callback - Banana");

			}

		}


	public class Caller {

		public void register(Fruit fruit) {

			fruit.callback_method();

		}

	} // end of Caller class

	
} // End of class ColorChooserDemo
