package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chess {
	
	static JFrame MainFrame = new JFrame();

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
				JButton button = new CustomJButton();
				if ((i+j) % 2 == 0) {
					button.setBackground(Color.WHITE);
				}
				else {
					button.setBackground(Color.BLACK);
					
				}
				((CustomJButton) button ).setCoord(i,j);
				//System.out.println(((CustomJButton) button ).getCoord());
				// button.setText("testing");
				// System.out.println(button);
				p2.add(button);
				
			}
			//p2.add(new JButton("button " + i));
		}
		
		
		 Component[] components = p2.getComponents();
		 
		  for(Component component: components)
		    {
			 System.out.println("test");
			System.out.println(components.length);
			System.out.println(((CustomJButton)component).getCoord());


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
