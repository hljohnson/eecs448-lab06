/**
 * @file: Dice.java
 * @author: Hannah Johnson
 * @date: 3/27/16
 * @brief: Implementation file for Dice class
 */


import javax.swing.*;

public class DiceDriver {
	
	// Create GUI and show it
	private static void createAndShowGUI() {
		// Create frame
		JFrame frame = new JFrame ("Dice Roller"); // Window title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		
		// Create panel
		//JPanel panel = new JPanel(); 
		
		// Create Dice, field, button, and label for dice roll
		/*JButton submitButton = new JButton("Submit");
		JTextField numberSides = new JTextField(3); // 3 Columns
		JLabel rollResult = new JLabel("Roll Result DEBUG");*/
		Dice die = new Dice();
		
		
		// Add field, button, and label to panel
		/*panel.add(numberSides);
		panel.add(submitButton);
		System.out.println("\n"); 
		panel.add(rollResult);*/

		// Add content to the main pane
		frame.getContentPane().add(die.getContent());
		
		// Display the window
		frame.pack(); // Put everything together
		frame.setVisible(true); // Make window visible
		frame.setSize(175, 150); // Set size of window
	}

	public static void main(String[] args) {
		createAndShowGUI();
	}
}
