package launcher;

import javax.swing.SwingUtilities;

import control.Controller;
import model.WebPage;
import view.MainWindow;

// authors Alessio Papi , Gabriele Marcozzi and Carlos Bilbao

public class Main {

	public static void main(String[] args) {
		String adminPass = "adminPsswd";
		WebPage wp = new WebPage(adminPass);
		Controller ctrl = new Controller(wp, adminPass);
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainWindow(wp, ctrl);
			}
		});
    }

}
