package main.pieces;

public class Piece {
	
	public String type;
	public String color;
	
	
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




	public static boolean movement() {
		return true;
	}
	
	public String toString() {
		
		return this.getType()+this.getColor();
	}

}
