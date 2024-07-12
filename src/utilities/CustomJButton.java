package utilities; 

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.pieces.Knight;
import main.pieces.Piece;
/*
 * 
 * This is a custom jbutton that represents a tile on the board
 *  inherits from the JButton swing class. I extend it in order improve it's capabilities
 * So that it can hold a piece object (knight, rook etc) and coordinates for where this particular tile is on the board
 * 
 */
public class CustomJButton extends JButton {
	
	public List<Integer> coord = new ArrayList<>();
	public Piece piece;
	
	public CustomJButton (){
		
		
		
	}

	
    public Piece getPiece() {
		return piece;
	}

    //This configures the custom jbutton with a piece and it inputs the piece icon on the tile
	public void setPiece(Piece piece) {
		this.piece = piece;
		//ImageIcon knightIcon = new ImageIcon("//resources//" + piece.getType() + ".jpg");
		//System.out.println(piece);
		if (piece != null) {
			ImageIcon icon = new ImageIcon(Knight.class.getResource("/resources/"+piece + ".png"));
			Image image = icon.getImage(); // transform it 
			
			Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); 
			this.setIcon(new ImageIcon(newimg));
			
		}
		
		else {
			this.setIcon(null);
		}

	}



	//sets the coordinates and gets the coordinates
	public List<Integer> getCoord() {
		return coord;
	}

	public void setCoord(int i, int j) {
		this.coord.add(i);
		this.coord.add(j);
	}


}