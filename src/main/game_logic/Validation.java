package main.game_logic;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.pieces.Piece;
import utilities.CustomJButton;

public class Validation {
	

	//Provides a list of list of integers that keeps track of which parts of the board are taken up by pieces.
	public static List< List<Integer>> Taken = new ArrayList<>();
	
	
	//Checks the components to see which moves are available
	public static void Availability(Component[] components) {
		
		for (Component comp: components) {
			
			Piece piece = ((CustomJButton)comp).getPiece();
		
			if (piece != null ) {
				
	
				if (piece.getType().equals("Pawn")) { //Checks which piece is which, in this case if it's a pawn it 
					//will call the pawn move method.
					
					System.out.println("validating pawns");
					pawnMove( components, comp);
				}
			}



		}

	}
	//This refreshes the taken list to get an up to date tally of where every piece is
	public static void Refresh(Component[] components) {
		Taken.clear();
		for (Component comp: components) {
			
			Piece piece = ((CustomJButton)comp).getPiece();
			
			if (piece != null ) {
			
				Taken.add(((CustomJButton)comp).getCoord());
			}

		
		}
		
	}
	
	//
	
	
	//This sets up the business logic for where pawns can move, This compares itself to the current state of the board
	public static void pawnMove(Component[] components, Component comp){
		
		CustomJButton b = (CustomJButton)comp;
	
		List<Integer> coord = b.getCoord();
		Piece piece = b.getPiece();
	
		
		
		List<Integer> coordi = new ArrayList<>();
		//move up
		int num1 =coord.get(0);
		int num2 = coord.get(1);
		
		coordi.add(num1 + 1);
		coordi.add(num2);

//		for (List<Integer> took: Taken) {
//			if (took.equals(coordi)) {
//				
//				System.out.println("Something is here " + b.getCoord());
//			}
//			
//		}

		piece.setMoves(coordi);
		coordi = new ArrayList<>();

		
		piece.setMoves(coordi);
		//move diagonally

		coordi.add(num1 + 1);
		coordi.add(num2 + 1);
		coordi = new ArrayList<>();
		
		coordi.add(num1 + 1);
		coordi.add(num2 - 1 );
		piece.setMoves(coordi);
		
		Validation.Refresh(components);

		
		
	}
	
	
	public static void moves(Component[] components, Component comp) {
	
	Piece piece = ((CustomJButton)comp).getPiece();
	if (piece != null ) {
		
		//System.out.println("We have " +piece);
		
		if (piece.getType().equals("Pawn")) {
			
			//System.out.println("validating pawns");
			pawnMove(components, comp);
		}
	}
}


}
