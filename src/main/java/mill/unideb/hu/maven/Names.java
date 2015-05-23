package mill.unideb.hu.maven;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Names extends JFrame implements ActionListener{
	
	/**
	 * Logger to debug, log information and warnings.
	 */
	private static Logger logger = LoggerFactory.getLogger(Names.class);
	
	/**
	 * Button to finish entering player names.
	 */
	protected JButton continueButton;
	
	/**
	 * Textfield for the name of the light player.
	 */
	public JTextField lightNameField;
	

	/**
	 * Textfield for the name of the dark player.
	 */
	public JTextField darkNameField;
	
	/**
	 * Label to light player's name.
	 */
	private JLabel lightNameLabel;
	
	/**
	 * Label to dark player's name.
	 */
	private JLabel darkNameLabel;
	
	/**
	 * Set constraints for {@code buttonPanelLayout}.
	 */
	private GridBagConstraints gbc;
	
	/**
	 * Panel for textfields.
	 */
	private JPanel textFieldPanel;
	
	/**
	 * Panel for button.
	 */
	private JPanel buttonPanel;
	
	/**
     * Name of the light player.
     */
    private static String lightName;
    
    /**
     * Name of the dark player.
     */
    private static String darkName;
    
    /**
	 * Layout for pop up window.
	 */
	private GridBagLayout textFieldPanelLayout;
	
	/**
	 * Layout for pop up window.
	 */
	private GridBagLayout buttonPanelLayout;
	
	/**
	 * 
	 */
	private Player light;
	private Player dark;
       
    /**
     * Constructor of Names.
     */
	public Names(){
		initNames();
	}

	private void initNames(){
		setBounds(500,500,300,200);
		setLocationRelativeTo(null);
		setTitle("Players");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		setResizable(false);
		
		gbc = new GridBagConstraints();
		textFieldPanelLayout = new GridBagLayout();
		buttonPanelLayout  = new GridBagLayout();
		
		lightNameLabel = new JLabel("Light player: ");
		darkNameLabel = new JLabel("Dark player: ");
		textFieldPanel = new JPanel();
		buttonPanel = new JPanel();
		
		textFieldPanel.setLayout(textFieldPanelLayout);
		buttonPanel.setLayout(buttonPanelLayout);		
		
		add(textFieldPanel);
		
		add(buttonPanel);
		
		continueButton=new JButton("Continue");
		continueButton.addActionListener(this);
		
		gbc.insets=new Insets(15, 5, 5, 5);
		gbc.gridx=0;
		gbc.gridy=3;
		buttonPanel.add(continueButton, gbc);
		
		lightNameField=new JTextField(lightName,15);
		gbc.insets=new Insets(3, 0, 0, 0);
		gbc.gridx=0;
		gbc.gridy=0;
		textFieldPanel.add(lightNameLabel,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		textFieldPanel.add(lightNameField, gbc);
		
		darkNameField=new JTextField(darkName,15);
		gbc.gridx=0;
		gbc.gridy=1;
		textFieldPanel.add(darkNameLabel,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		textFieldPanel.add(darkNameField,gbc);
		
		
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JFrame frame=new JFrame();

		if(e.getSource()==continueButton){
			lightName=lightNameField.getText();
			darkName=darkNameField.getText();
			
			if(lightName.compareTo("")==0 || darkName.compareTo("")==0){
				JOptionPane.showMessageDialog(frame, "Fill out all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else{
				logger.info("The two players are: " + lightName + " and " + darkName);
				light=new Player(lightName);
				dark=new Player(darkName);
				Control c=new Control(light,dark);
				
				setVisible(false);
				
			}
			
		}
		
	}
	
}
