package main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.game_logic.Actions;
import main.game_logic.Validation;
import main.pieces.Piece;
import utilities.CustomJButton;

public class Chess {
	
	
	//JFrame which launches the main window
	public static JFrame MainFrame = new JFrame();
	
	//keeps track of the current number of moves
	static List<CustomJButton> moveStack = new ArrayList<>();
	
	//keeps track of the location of every jbutton
	
	static CustomJButton[][] locations = new CustomJButton[8][8];
	//keeps track of turns
	public static String turn = "black";
	public static JLabel playerTurn = new JLabel("Player turn: " + turn);

	public Chess() {
		

		//configuration the design of the main frame
		JPanel p = new JPanel(new BorderLayout(100,100)); 
		Chess.MainFrame.setSize(1000,1000);
		Chess.MainFrame.add(p);
		
		JPanel p2 = new JPanel(); 
	
		p2.setSize(500,500);
		
		//creating a set of panels to create margins for the actual board
		JPanel north = new JPanel(); 
		
		JPanel south = new JPanel(); 
		//JLabel jlabel = new JLabel("Player turn " + this.turn);
		south.add(playerTurn);

		JPanel east = new JPanel(); 
	
		JPanel west = new JPanel(); 

		p2.setLayout(new GridLayout(8,8, 0, 0));
		JLabel l = new JLabel("panel label"); 

		
		int alt = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				//JButton button = new CustomJButton();
				JButton button = new CustomJButton();
				List<Integer> coord = ((CustomJButton)button).getCoord();
				switch(i) {

				    case 0:{

				    	switch(j) {
				    		case 0:
							case 7: { 
								Piece rook = new Piece("Rook","b");
								((CustomJButton)button).setPiece(rook);
								break;
							}
							case 1:
							case 6: {
								
								Piece knight = new Piece("Knight","b");
								((CustomJButton)button).setPiece(knight);
								break;
							}
							
							case 2:
							case 5: {
								
								Piece bishop = new Piece("Bishop","b");
								((CustomJButton)button).setPiece(bishop);
								break;
							}
							
							case 3: {
								
								Piece queen = new Piece("Queen","b");
								((CustomJButton)button).setPiece(queen);
								break;
							}
							
							case 4: {
								
								Piece king = new Piece("King","b");
								((CustomJButton)button).setPiece(king);
								break;
							}
								
				    	
				    	}
				    	
				    	break;
				    }
					case 1: { 
						Piece pawn = new Piece("Pawn","b");
						((CustomJButton)button).setPiece(pawn);
						break;
					}
					
					case 6:{
						Piece pawn = new Piece("Pawn","w");
						((CustomJButton)button).setPiece(pawn);
						break;
					}
					
					case 7: {
				    	switch(j) {
			    		case 0:
						case 7: { 
							Piece rook = new Piece("Rook","w");
							((CustomJButton)button).setPiece(rook);
							break;
						}
						case 1:
						case 6: {
							
							Piece knight = new Piece("Knight","w");
							((CustomJButton)button).setPiece(knight);
							break;
						}
						
						case 2:
						case 5: {
							
							Piece bishop = new Piece("Bishop","w");
							((CustomJButton)button).setPiece(bishop);
							break;
						}
						
						case 3: {
							
							Piece queen = new Piece("Queen","w");
							((CustomJButton)button).setPiece(queen);
							break;
						}
						
						case 4: {
							
							Piece king = new Piece("King","w");
							((CustomJButton)button).setPiece(king);
							break;
						}
							
			    	
			    	}						
						
						
					break;
					}
				}
				

				if ((i+j) % 2 == 0) {
					button.setBackground(Color.WHITE);
				}
				else {
					
					button.setBackground(Color.BLACK);
				
				}
				((CustomJButton) button ).setCoord(i,j);

				p2.add(button);

			}
			//p2.add(new JButton("button " + i));
		}
		
		

		 Component[] components = p2.getComponents();
	
		 Actions action = new Actions(components, locations);
		


		p.add(north,BorderLayout.NORTH);
		p.add(south,BorderLayout.SOUTH);
		p.add(west,BorderLayout.WEST);
		p.add(east,BorderLayout.EAST);
		//p.add(l ,BorderLayout.CENTER);
		p.add(p2 ,BorderLayout.CENTER);
		Validation.Refresh(components);
		Validation.Availability(components);


		Chess.MainFrame.show();
	}




}
