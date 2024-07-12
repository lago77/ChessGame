package main;

import main.gui.Chess;

public class Main {

	public static void main(String[] args) {
		
		//creates a Chess object to start up the board
		Chess myChess = new Chess();
		//initializes the JFrame window to show
		Chess.MainFrame.show();
	}

}
