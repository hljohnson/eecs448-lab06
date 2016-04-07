/*Issue: right now, clicking the radio button you want in the menu is what is calling the action listener
* to making the temp conversions. But, the "Convert" button is what is checking for valid input. I want
* to fix/combine this so that the user selects an option from the menu, but then clicks the Convert button which
* will do the conversion and check for valid input
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TempConverter
{
	private JPanel panel;

	private JLabel fToC; // label for conversion display
	private JLabel fToK; // label for conversion display
	private JLabel cToF; // label for conversion display
	private JLabel cToK; // label for conversion display
	private JLabel kToC; // label for conversion display
	private JLabel kToF; // label for conversion display

  private JButton fToCButton; // button for conversion display
  private JButton fToKButton; // button for conversion display
  private JButton cToFButton; // button for conversion display
  private JButton cToKButton; // button for conversion display
  private JButton kToCButton; // button for conversion display
  private JButton kToFButton; // button for conversion display

	private JTextField fToCText;
	private JTextField fToKText;
	private JTextField cToFText;
	private JTextField cToKText;
	private JTextField kToCText;
	private JTextField kToFText;

	public TempConverter()
	{
		panel = new JPanel(new GridLayout(0,1));

    fToCButton = new JButton("Convert from F to C");
    fToKButton = new JButton("Convert from F to K");
    cToFButton = new JButton("Convert from C to F");
    cToKButton = new JButton("Convert from C to K");
    kToCButton = new JButton("Convert from K to C");
    kToFButton = new JButton("Convert from K to F");

    fToC = new JLabel("Enter a temperature from F to C");
    fToK = new JLabel("Enter a temperature from F to K");
    cToF = new JLabel("Enter a temperature from C to F");
    cToK = new JLabel("Enter a temperature from C to K");
    kToC = new JLabel("Enter a temperature from K to C");
    kToF = new JLabel("Enter a temperature from K to F");

		fToCText = new JTextField(3);
		fToKText = new JTextField(3);
		cToFText = new JTextField(3);
		cToKText = new JTextField(3);
		kToCText = new JTextField(3);
		kToFText = new JTextField(3);

    //Register a listener for the conversion buttons
    fToCButton.addActionListener(fToCAction());
    fToKButton.addActionListener(fToKAction());
    cToFButton.addActionListener(cToFAction());
    cToKButton.addActionListener(cToKAction());
    kToCButton.addActionListener(kToCAction());
    kToFButton.addActionListener(kToFAction());


		//load the panel
    panel.add(fToC);
		panel.add(fToCText);
    panel.add(fToCButton);

    panel.add(fToK);
		panel.add(fToKText);
    panel.add(fToKButton);

    panel.add(cToF);
		panel.add(cToFText);
    panel.add(cToFButton);

    panel.add(cToK);
		panel.add(cToKText);
    panel.add(cToKButton);

    panel.add(kToC);
		panel.add(kToCText);
    panel.add(kToCButton);

    panel.add(kToF);
		panel.add(kToFText);
    panel.add(kToFButton);

	}

	public Component getContent()
	{
		return (panel);
	}

	private ActionListener fToCAction()
	{
		//Create and define an action listener for button1
    ActionListener action = new ActionListener() {
    	@Override
      	public void actionPerformed(ActionEvent e)
        {
        	String input = fToCText.getText();

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

					double tempInF = Double.parseDouble(input);//convert String to double
					double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
					String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
					//only display 2 places past decimal
					fToC.setText(newText);
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
					String input = fToKText.getText();

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
					fToK.setText(newText);
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
        String input = cToFText.getText();

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

				double tempInC = Double.parseDouble(input);//convert String to double
				double tempInF = ((tempInC)*(5.0/9.0))+32.0; //convert C to F
				String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
				//only display 2 places past decimal
				cToF.setText(newText);
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
        	String input = cToKText.getText();

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

					double tempInC = Double.parseDouble(input);//convert String to double
					double tempInK = (tempInC) + 273.15; //convert C to K
					String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
											       //only display 2 places past decimal
				cToK.setText(newText);
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
          String input = kToCText.getText();

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

					double tempInK = Double.parseDouble(input);//convert String to double
					double tempInC = (tempInK) - 273.15; //convert K to C
					String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
					//only display 2 places past decimal
					kToC.setText(newText);
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
          String input = kToFText.getText();

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

					double tempInK = Double.parseDouble(input);//convert String to double
					double tempInF = ((tempInK)*(5.0/9.0)) - 459.67; //convert K to F
					String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
					//only display 2 places past decimal
					kToF.setText(newText);
					System.out.println(newText);
        }
      };
      return action;
    }
}
