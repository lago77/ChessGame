package main; 

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class CustomJButton extends JButton {
	
	public List<Integer> coord = new ArrayList<>();
	public String mystring = "test";

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