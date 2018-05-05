package launcher;

import javax.swing.SwingUtilities;

import control.Controller;
import model.WebPage;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		WebPage wp = new WebPage();
		Controller ctrl = new Controller();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainWindow(wp, ctrl);
			}
		});
    }

}
