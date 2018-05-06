package control;

import java.io.IOException;

import model.WebPage;

public class Controller {

	private WebPage _web;
	private String _passwd;
	
	public Controller(WebPage web, String passwd) {
		_web = web;
		_passwd = passwd;
	}
	
	public void store(){
		try {
			_web.store();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getFilename(){
		try { 
			return _web.getFilename(_passwd);
		
		} catch (SecurityException e){
			e.printStackTrace();
			System.err.println("Wrong password!");
			return "ERROR";
		}
	}
	
	public void setFilename(String filename, String passwd){
	
		try {
			_web.setFilename(filename, passwd);
		} catch (SecurityException e){
			e.printStackTrace();
			System.err.println("Wrong password!");
		}
	}
	
	public boolean login(String username){
		return _web.login(username, _passwd);
	}
	
	public void registerUser(String username, String password, int age, String email){
		_web.registerUser(username, password, age, email);
	}
}
