package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.pieces.Piece;

public class Chess {
	
	static JFrame MainFrame = new JFrame();
	
	static List<CustomJButton> moveStack = new ArrayList<>();

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		JPanel p = new JPanel(new BorderLayout(100,100)); 
		Chess.MainFrame.setSize(1000,1000);
		Chess.MainFrame.add(p);
		
		JPanel p2 = new JPanel(); 
		//p2.setBackground(Color.red); 
		p2.setSize(500,500);
		
		JPanel north = new JPanel(); 
		//north.setBackground(Color.yellow); 
		JPanel south = new JPanel(); 
		//south.setBackground(Color.yellow); 
		JPanel east = new JPanel(); 
		//east.setBackground(Color.yellow); 
		JPanel west = new JPanel(); 
		//west.setBackground(Color.yellow);  
		p2.setLayout(new GridLayout(8,8, 0, 0));
		JLabel l = new JLabel("panel label"); 
		JButton b3 = new JButton("button4"); 
		JButton b4 = new JButton("button4"); 
		JButton b5 = new JButton("button4"); 
		JButton b6 = new JButton("button4"); 
		JButton b7 = new JButton("button7"); 
		
		int alt = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				//JButton button = new CustomJButton();
				JButton button = new CustomJButton();
				
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
		 
		  for(Component component: components)
		    {
			// System.out.println("test");
			//System.out.println(components.length);
			//System.out.println(((CustomJButton)component).getCoord());
			//System.out.println(((CustomJButton)component).getPiece());
			((JButton)component).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (Chess.moveStack.size() == 0) {
						
						System.out.println("Empty moves");
						if ( ((CustomJButton)component).getPiece() != null) {
							
							Chess.moveStack.add((CustomJButton)component);
				
						}
	
					}
					
					else {
						if ( ((CustomJButton)component).getPiece() == null) {
							
							System.out.println("We're moving "+Chess.moveStack.get(0).getPiece().getColor() + " to "+((CustomJButton)component).getCoord() );
							
						}
						
						
					}
					System.out.println("Pressing "+((CustomJButton)component).getPiece() +": "+ ((CustomJButton)component).getCoord() );
					
				}
			});
			//MainFrame.setVisible(true);
			
		}
		
		
//		p2.add(b3);
		p.add(north,BorderLayout.NORTH);
		p.add(south,BorderLayout.SOUTH);
		p.add(west,BorderLayout.WEST);
		p.add(east,BorderLayout.EAST);
		//p.add(l ,BorderLayout.CENTER);
		p.add(p2 ,BorderLayout.CENTER);
		Chess.MainFrame.show();
	}

}
