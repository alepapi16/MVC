package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.Controller;
import model.Observer;
import model.WebPage;

public class MainWindow  extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;

	JPanel _mainPanel, _bottomPanel;
	JLabel _username, _password, _age, _email, _filename,  _done;
	JTextArea _usrArea, _psswArea, _ageArea, _emailArea, _filenameArea;
	JButton _register;
	//Logic attributes
	private WebPage _wp;
	private Controller _ctrl;
	
	public MainWindow(WebPage wp, Controller ctrl) {
		_wp = wp;
		_ctrl = ctrl;
		
		initGUI();
		
		_wp.addObserver(this);
	}
	
	private void initGUI() {
		_mainPanel= new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		
		_username = new JLabel("Username:");
		_password = new JLabel("Password:");
		_age = new JLabel("Age:");
		_email = new JLabel("Email:");
		_filename = new JLabel("Filename:");
		
		_username.setAlignmentX(CENTER_ALIGNMENT);
		_password.setAlignmentX(CENTER_ALIGNMENT);
		_age.setAlignmentX(CENTER_ALIGNMENT);
		_email.setAlignmentX(CENTER_ALIGNMENT);
		_filename.setAlignmentX(CENTER_ALIGNMENT);
		
		_usrArea = new JTextArea();
		_psswArea = new JTextArea();
		_ageArea = new JTextArea();
		_emailArea = new JTextArea();
		_filenameArea = new JTextArea();
		
		_mainPanel.add(_username);
		_mainPanel.add(_usrArea);
		_mainPanel.add(_password);
		_mainPanel.add(_psswArea);
		_mainPanel.add(_age);
		_mainPanel.add(_ageArea);
		_mainPanel.add(_email);
		_mainPanel.add(_emailArea);
		_mainPanel.add(_filename);
		_mainPanel.add(_filenameArea);
		
		_bottomPanel = new JPanel();
		_bottomPanel.setLayout(new BoxLayout(_bottomPanel, BoxLayout.X_AXIS));
		
		_register = new JButton("Register!");
		_register.setAlignmentX(LEFT_ALIGNMENT);
		
		_done = new JLabel();
		_done.setAlignmentX(RIGHT_ALIGNMENT);
		_done.setVisible(false);
		
		_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!_usrArea.getText().equals("") && !_psswArea.getText().equals("") && !_ageArea.getText().equals("") 
						&& !_emailArea.getText().equals("") && !_filenameArea.getText().equals("")) 
					ctrl.store(/*PARAMS*/); //Carlos, you should define something like a store method in the controller
				else {
					_done.setText("Please fill all the fields");
					_done.setVisible(true);
				}
				
			}
		});
		_bottomPanel.add(_register);
		_bottomPanel.add(_done);
		
		_mainPanel.add(_bottomPanel);
		
		this.add(_mainPanel);
		this.setPreferredSize(new Dimension(400, 250));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void onStore(boolean b) {
		if(b) {
		_done.setText("    DONE");
		_done.setVisible(true);
		}
		else
			System.out.println("Something went wrong while storing the data.");
	}

}
