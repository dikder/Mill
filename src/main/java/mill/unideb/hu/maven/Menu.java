package mill.unideb.hu.maven;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Menu extends JFrame implements ActionListener {
	
	/**
	 * Logger to debug, log information and warnings.
	 */
	private static Logger logger = LoggerFactory.getLogger(Menu.class);
	
	/**
	 * File chooser to able to load saved games.
	 */
	private JFileChooser fc = new JFileChooser();
	
	/**
	 * Button to start a new game.
	 */
	private JButton newGame;
	
	/**
	 * Button to load a saved game.
	 */
	private JButton load;
	
	/**
	 * Button to exit the game
	 */
	private JButton exit;
	
	/**
	 * Panel for button.
	 */
	private JPanel buttonPanel;
	
	/**
	 * Layout for pop up window.
	 */
	private GridBagLayout buttonPanelLayout;
	
	/**
	 * Set constraints for {@code buttonPanelLayout}.
	 */
	private GridBagConstraints gbc;
	
	/**
	 * Constructor of the Menu.
	 */
	public Menu(){
		initMenu();
	}
	
	
	private void initMenu() {
		setBounds(500,500,200,200);
		setLocationRelativeTo(null);
		setTitle("Mill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		setResizable(false);
		
		gbc = new GridBagConstraints();
		buttonPanelLayout = new GridBagLayout();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(buttonPanelLayout);
		
		add(buttonPanel);
		
		newGame=new JButton("New Game");
		newGame.addActionListener(this);
		
		load=new JButton("Load");
		load.addActionListener(this);
		
		exit=new JButton("Exit");
		exit.addActionListener(this);
		
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 3;
		buttonPanel.add(newGame,gbc);
		
		//gbc.insets = new Insets(100, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 4;
		buttonPanel.add(load,gbc);
		
		//gbc.insets = new Insets(150, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 5;
		buttonPanel.add(exit,gbc);
		
		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==newGame){
			Names n=new Names();
			this.dispose();
		} else
			if(e.getSource()==exit){
				this.dispose();
	        	System.exit(0);
			} else
				if(e.getSource()==load){
					int returnVal = fc.showOpenDialog(this);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						String[] s=file.getName().split("_vs_");
						Control c=new Control(new Player(s[0]), new Player(s[1].split(".xml")[0]));
						new LoadXml(file.getName());
						this.dispose();
						
					}
				}
		
		
		
	}

}
