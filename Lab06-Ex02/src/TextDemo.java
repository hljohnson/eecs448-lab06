import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TextDemo 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	private JMenuBar menuBar;
	private JMenu menu; // drop-down menu
	
	private JRadioButtonMenuItem fToC; //radio button menu item
	private JRadioButtonMenuItem fToK; //radio button menu item
	private JRadioButtonMenuItem cToF; //radio button menu item
	private JRadioButtonMenuItem cToK; //radio button menu item
	private JRadioButtonMenuItem kToC; //radio button menu item
	private JRadioButtonMenuItem kToF; //radio button menu item
	
	public TextDemo()
	{
		panel = new JPanel();
		button = new JButton("Convert");
		text = new JTextField(3);//3 cols, not 20 chars
		menuBar = new JMenuBar();
		menu = new JMenu("Choose Conversion Type");
		label = new JLabel("Enter a temp to convert");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		// Build the menu
		menu.setMnemonic(KeyEvent.VK_A); //Allows for hotkey access, Alt+a
		menuBar.add(menu); //Add to menu bar

		
		fToC = new JRadioButtonMenuItem("F to C");
		menu.add(fToC);
		fToK= new JRadioButtonMenuItem("F to K");
		menu.add(fToK);
		cToF= new JRadioButtonMenuItem("C to F");
		menu.add(cToF);
		cToK= new JRadioButtonMenuItem("C to K");
		menu.add(cToK);
		kToC= new JRadioButtonMenuItem("K to C");
		menu.add(kToC);
		kToF= new JRadioButtonMenuItem("K to F");
		menu.add(kToF);
		
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(fToC);
        group.add(fToK);
        group.add(cToF);
        group.add(cToK);
        group.add(kToC);
        group.add(kToF);
        
        //Register a listener for the radio buttons.
        fToC.addActionListener(fToCAction());
        fToK.addActionListener(fToKAction());
        cToF.addActionListener(cToFAction());
        cToK.addActionListener(cToKAction());
        kToC.addActionListener(kToCAction());
        kToF.addActionListener(kToFAction());
		
		
		//load the panel
		panel.add(text);
		panel.add(menuBar);
		panel.add(button);
		panel.add(label);

	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				
				// Check if field was empty and display error message if so
				if (input.trim().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Field was entered blank!");
				}
				// If field not empty, check if entry was numeric and display
				// error message if it wasn't numeric
				else {
					try {
				        float temp = Float.parseFloat(input);
				    } 
					catch (NumberFormatException x) {
				        JOptionPane.showMessageDialog(null, "Entry must be numeric!");
				    }
					
				}
				


			}
		};
		
		return listener;
	}	
	
	private ActionListener fToCAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String input = text.getText();
				double tempInF = Double.parseDouble(input);//convert String to double
				double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
				String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
            }
        };
        return action;
    }
	
	private ActionListener fToKAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
				String input = text.getText();
				
				// Check if field was empty and display error message if so
				if (input.trim().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Field was entered blank!");
				}
				// If field not empty, check if entry was numeric and display
				// error message if it wasn't numeric
				else {
					try {
				        float temp = Float.parseFloat(input);
				    } 
					catch (NumberFormatException x) {
				        JOptionPane.showMessageDialog(null, "Entry must be numeric!");
				    }
					
				}
            	//String input = text.getText();
				double tempInF = Double.parseDouble(input);//convert String to double
				double tempInK = (tempInF + 459.67)*(5.0/9.0); //convert F to K
				String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
            }
        };
        return action;
    }
	
	private ActionListener cToFAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String input = text.getText();
				double tempInC = Double.parseDouble(input);//convert String to double
				double tempInF = ((tempInC)*(5.0/9.0))+32.0; //convert C to F
				String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
            }
        };
        return action;
    }
	
	private ActionListener cToKAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String input = text.getText();
				double tempInC = Double.parseDouble(input);//convert String to double
				double tempInK = (tempInC) + 273.15; //convert C to K
				String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
            }
        };
        return action;
    }
	
	private ActionListener kToCAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String input = text.getText();
				double tempInK = Double.parseDouble(input);//convert String to double
				double tempInC = (tempInK) - 273.15; //convert K to C
				String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
            }
        };
        return action;
    }
	
	private ActionListener kToFAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String input = text.getText();
				double tempInK = Double.parseDouble(input);//convert String to double
				double tempInF = ((tempInK)*(5.0/9.0)) - 459.67; //convert K to F
				String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
											       //only display 2 places past decimal
				label.setText(newText);
				System.out.println(newText);
            }
        };
        return action;
    }
}