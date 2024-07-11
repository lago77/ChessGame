package main; 

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.pieces.Knight;
import main.pieces.Piece;

public class CustomJButton extends JButton {
	
	public List<Integer> coord = new ArrayList<>();
	public String mystring = "test";
	public Piece piece;
	
	CustomJButton (){
		
		
		
	}
	
	
	
    Piece getPiece() {
		return piece;
	}


	public void setPiece(Piece piece) {
		this.piece = piece;
		//ImageIcon knightIcon = new ImageIcon("//resources//" + piece.getType() + ".jpg");
		//System.out.println(piece);
		ImageIcon icon = new ImageIcon(Knight.class.getResource("/resources/"+piece + ".png"));
		Image image = icon.getImage(); // transform it 
		
		Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); 
		this.setIcon(new ImageIcon(newimg));
	}


	public String getMystring() {
		return mystring;
	}

	List<Integer> getCoord() {
		return coord;
	}

	void setCoord(int i, int j) {
		this.coord.add(i);
		this.coord.add(j);
	}

//	public CustomJButton() {
//        this.setText("Custom JButton");
//        // initialize
//    }

    // add your own methods or override JButton methods
//    public void myFunc(){
//
//    }
}