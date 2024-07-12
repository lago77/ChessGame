package main.pieces;

import java.util.ArrayList;
import java.util.List;

public class Piece {
	
	/*This sets up the piece object which comes with type (knight, king, rook etc) and color (black/white) 
	* This object also comes with a list of a list that keeps track of the moves it can currently take
	*/
	
	public String type;
	public String color;
	public List<List<Integer>> moves = new ArrayList<>();
	
	
	public Piece(String type, String color) {
		this.type = type;
		this.color = color;
		
	}




	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	

	public String getColor() {
		return color;
	}


	void setColor(String color) {
		this.color = color;
	}



	

	public List<List<Integer>> getMoves() {
		return moves;
	}




	public void setMoves(List<Integer> moves) {
		this.moves.add(moves);
	}

	public void clearMoves () {
		

		this.moves.clear();
	
	}


	public static boolean movement() {
		return true;
	}
	
	
	
	public String toString() {
		
		return this.getType()+this.getColor();
	}

}
