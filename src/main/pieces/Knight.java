package main.pieces;

import java.awt.Image;

import javax.swing.ImageIcon;
//Used for the open close principle

public class Knight {
	
	public String type = "Knight";
	
			
	String getType() {
		return type;
	}




	void setType(String type) {
		this.type = type;
	}




	public static boolean movement() {
		return true;
	}

}
