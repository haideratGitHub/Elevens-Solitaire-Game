/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new ElevensBoard();
	CardGameGUI gui = new CardGameGUI(board);
	gui.displayGame();
    }
    
}
