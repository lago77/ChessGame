package main.game_logic;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;

import main.gui.Chess;
import main.pieces.Piece;
import utilities.CustomJButton;

public class Actions {
	//public static String turn = "black";
	public static List<CustomJButton> moveStack = new ArrayList<>();
	
//	public Component[] components;
//	public CustomJButton[][] locations;
//	
	
	public static Map<CustomJButton, List<Integer>> availableMoves = new HashMap<>();
	
	public static void move(String turn, Component component) throws TurnValidation {
		
		String color =((CustomJButton)component).getPiece().getColor();
		
		
		if (!Chess.turn.substring(0,1).equals(color )) {
		
			throw new TurnValidation("Not the right turn yet");
		//	return true;
			
		}

		
		//return false;
		
	}
	
	public Actions(Component[] components,  CustomJButton[][] locations) {

			// This for loop is called which iterates over every component and adds an action listener to the jbuttons
		  for(Component component: components)
		    {
			  
			((JButton)component).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {


					/*
					 * At the start of a players turn, the movestack size is 0. When the player chooses an appropriate piece
					 * the component and piece is added to the list 
					 */
					if (moveStack.size() == 0) {
						
					//input validation to see if it's the user's turn
						
						try {
							
							move(Chess.turn, component);
							moveStack.add(((CustomJButton)component));
							
						}
						catch (TurnValidation err1) {
							System.out.println(err1.getMessage());
						}
						catch (Exception err2) {
							
							System.out.println("not a valid piece");
						}
						

	
					}
					
					else {//If the movestack size is greater than 0, than the game checks to see if the player has moved into an empty space
						
					
						if ( ((CustomJButton)component).getPiece() == null && (moveStack.get(0).getPiece() != null)) {
							
						
							Validation.moves(components, component);
							
							moveStack.add((CustomJButton)component);
							Piece piece = moveStack.get(0).getPiece();
							System.out.println(piece.getMoves());


							moveStack.get(1).setPiece(piece);
							moveStack.get(0).setPiece(null);
							moveStack.clear();			
							((CustomJButton)component).getPiece().clearMoves();
							
							if (Chess.turn.substring(0,1).equals("b")) {
								
								Chess.turn = "white";
								Chess.playerTurn.setText("Player turn: " + Chess.turn);
								System.out.println(Chess.playerTurn.getText());
							}
							
							else {
								Chess.turn = "black";
								Chess.playerTurn.setText("Player turn: " + Chess.turn);
								System.out.println(Chess.playerTurn.getText());
							}
							
							Validation.Refresh(components);
						}
						
						
						
						
					}

					for (Component comp: moveStack) {
						System.out.println("Size "+ moveStack.size());
						System.out.println(((CustomJButton)comp).getPiece());
					}
					System.out.println("turn "+Chess.turn);
					
					
					
				}
			});
			
			//keeps track of the location of all components
			int y = ((CustomJButton)component).getCoord().get(0); 
			int x = ((CustomJButton)component).getCoord().get(1); 
			locations[y][x] =(CustomJButton)component;

			
		}//for loop ends here
	}

}






//for (List<Integer> pmoves : piece.getMoves()) {
//if ( ((CustomJButton)component).getCoord().equals(pmoves) ) {
//	
//	System.out.println("They are equal");
//
//	moveStack.get(1).setPiece(piece);
//	moveStack.get(0).setPiece(null);
//	moveStack.clear();			
//	((CustomJButton)component).getPiece().clearMoves();
//	
//}
//
//else {
//	
//	System.out.println("we cannot move there " + piece.getMoves() + " + " + ((CustomJButton)component).getCoord());
//}
//
//}
