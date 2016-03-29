import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

public class Dice implements ActionListener  {
	
	JPanel panel;
	JLabel message;
	JTextField numSides;
	JButton rollButton;
	JLabel rollResults;
	
	
	public Dice() {
		
		panel = new JPanel(new GridLayout (0,1)); //Create with a grid layout of a single column
		message = new JLabel("Enter number of sides: ");
		numSides = new JTextField(3); // 3 columns
		rollButton = new JButton("Roll");
		rollResults = new JLabel("Roll results");
		
		// Set up action listener
		rollButton.addActionListener(this); // this instance will handle the actions
		
		// Add elements to panel
		panel.add(message);
		panel.add(numSides);
		panel.add(rollButton);
		panel.add(rollResults);
		
	}
	
	public Component getContent() {
		return(panel);
	}
	
	public void actionPerformed(ActionEvent e) {
		// When the button is pressed ...
		String input = numSides.getText();
		int inputInt = Integer.parseInt(input); // convert String to int
		
		// Create random number in given range and then parse to String
		Random rand = new Random();
		int randNum = rand.nextInt((inputInt - 1) + 1) + 1;
		String result = Integer.toString(randNum);
		rollResults.setText(result);
		
		
		
		
	}
}
