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

public class Player {
	
	/**
	 * Logger to debug, log information and warnings.
	 */
	private static Logger logger=LoggerFactory.getLogger(Player.class);
	
	
	/**
	 * Player's name.
	 */
	private String name;

    public String getName() {
		return name;
	}


	/**
     * Stones number put on board of the player
     */
    private int numberOfStones=0;

	/**
     * Number of stones left to board of the player
     */
	private int numberOfStonesLeftToBoard=0;
    
    /**
     * Constructor of Player.
     */
    public Player(String name){
    	this.name=name;
	}
    
    /**
	 * Get Stones number of the player.
	 * @return player's Stones number on board.
	 */
    public int getNumberOfStones() {
		return numberOfStones;
	}
    
    public void setNumberOfStones(int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}

	
    /**
	 * Get Stones number left to place of the player.
	 * @return player's Stones number what it left to board.
	 */
	public int getNumberOfStonesLeftToBoard() {
		return numberOfStonesLeftToBoard;
	}
	
	public void setNumberOfStonesLeftToBoard(int numberOfStonesLeftToBoard) {
		this.numberOfStonesLeftToBoard = numberOfStonesLeftToBoard;
	}

    
	
	public void raiseNumberOfStonesOnBoard() {
        numberOfStones++;
    }
	
	public void raiseNumberOfStonesLeftToBoard() {
        numberOfStonesLeftToBoard++;
    }

	
}
