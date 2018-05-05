package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class that represents the logic of a WebPage
 * 
 * It has a list of the users registered to the page and a HashMap linking 
 * the user-names to the respective passwords.
 * 
 * The page has the functionalities to:
 * 
 * 1) registering a user to the database
 * 2) verifying the presence of a user in the list of registered users
 * 3) storing the list of users on a file
 *  
 * The class belongs to the model layer, and can notify its observers when
 * some relevant event happen (ex: store). 
 *  
 * @author Alessio Papi
 */
public class WebPage implements Observable<Observer> {

	private List<User> users;
	
	/**
	 * Structure that maps a username to the respective password
	 */
	private HashMap<String, String> user_map;
	
	/**
	 * Filename where the file will be stored
	 */
	private String filename;
	
	/**
	 * List of observers for the web page
	 */
	private List<Observer> observers;
	
	/**
	 * Constructor
	 */
	public WebPage() {
				
		filename = null;
		users = new ArrayList<>();
		user_map = new HashMap<>();
		observers = new ArrayList<>();
	}
	
	/**
	 * Filename getter
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Method that sets the filename for the backup file
	 * @param filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Method that verifies the presence of a user among the registered users
	 */
	public boolean login(String username, String password) {
		if(user_map.get(username).equals(password))
			return true;
		return false;
	}
		
	/**
	 * Method that stores the content in a buffered writer
	 * @param bw
	 * @throws IOException 
	 */
	public void store() throws IOException {
		
		if(filename == null)
		{
			System.out.println("No filename inserted.");
			return;
		}
		
		try(FileWriter fw = new FileWriter(filename);
				BufferedWriter bw = new BufferedWriter(fw)) {
			
			for(User u : users)
			{
				bw.write(u.toString());
				bw.newLine();
			}
			
			notifyStore(true); // notify the correct storage to the observers (active control)
		}
		catch(IOException e) {
			System.out.println("A problem with your file has occurred.");
			File file = new File(filename);
			file.delete();
		}

	}
	
	/**
	 * Method that register a user into the database
	 */
	public void registerUser(String username, String password, int age, String email)
	{
		User u = new User(username, password, age, email);
		
		if(user_map.put(username, password) != null)
			for(User user : users)
				if(user.getUsername().equals(u.getUsername())) {
					users.remove(user);
					break;
				}
			
		users.add(u);
	}

	/**
	 * Method that notifies the store to the observers
	 * @param b
	 */
	public void notifyStore(boolean b) {
		for(Observer o : observers)
			o.onStore(b);
	}
	
	/**
	 * Method that adds an observer
	 */
	@Override
	public boolean addObserver(Observer o) {
		if(observers.contains(o))
			return false;
		observers.add(o);
		return true;
	}

	/**
	 * Method that removes an observer
	 */
	@Override
	public boolean removeObserver(Observer o) {
		return observers.remove(o);
	}

}

