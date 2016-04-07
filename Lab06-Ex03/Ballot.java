import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Ballot implements ActionListener{
  private JPanel panel;

  private JLabel firstName;
  private JTextField firstNameText;
  private JLabel lastName;
  private JTextField lastNameText;

  private JButton submitButton;

  private ButtonGroup candidates;
  private JRadioButton candidate1;
  private JRadioButton candidate2;
  private JRadioButton candidate3;
  private JRadioButton candidate4;

  String c1 = "Donald Trump";
  String c2 = "Bernie Sanders";
  String c3 = "Hillary Clinton";
  String c4 = "J. W. Gibbons";


  public Ballot() {
    panel = new JPanel(new GridLayout(0,1));

    // Voters name
    firstName = new JLabel("First Name: ");
    firstNameText = new JTextField(10);

    lastName = new JLabel("Last Name: ");
    lastNameText = new JTextField(10);

    submitButton = new JButton("Submit Vote!");
    submitButton.addActionListener(this); // add action listener in this class

    // Candidates
    candidate1 = new JRadioButton(c1);
    candidate1.setSelected(true); // set candidate 1 as selected by default
    candidate2 = new JRadioButton(c2);
    candidate3 = new JRadioButton(c3);
    candidate4 = new JRadioButton(c4);

    // Group candidate buttons
    ButtonGroup candidates = new ButtonGroup();
    candidates.add(candidate1);
    candidates.add(candidate2);
    candidates.add(candidate3);
    candidates.add(candidate4);

    // Add components to panel
    panel.add(firstName);
    panel.add(firstNameText);

    panel.add(lastName);
    panel.add(lastNameText);

    panel.add(candidate1);
    panel.add(candidate2);
    panel.add(candidate3);
    panel.add(candidate4);
    panel.add(submitButton);
  }

  public Component getPanel(){
    return(panel);
  }

  public void actionPerformed(ActionEvent e){
    // extract names from form
    String firstNameInput = firstNameText.getText();
    String lastNameInput = lastNameText.getText();

    // extract selected candidate
    String candidateInput = ""; //must initialize
    if(candidate1.isSelected()) {
      candidateInput = c1;
    }
    else if(candidate2.isSelected()) {
      candidateInput = c2;
    }
    else if(candidate3.isSelected()) {
      candidateInput = c3;
    }
    else if(candidate4.isSelected()) {
      candidateInput = c1;
    }

    // Write this information to a text file named after voter
    String fileName = lastNameInput + "_" + firstNameInput + "_ballot.txt";

    try {
      // Java createNewFile() method only creates file if one hasn't
      // been created with that name before
      File file = new File(fileName);

      if (file.createNewFile()){
        JOptionPane.showMessageDialog(null, "File is created!");
        System.out.println("File is created!");

        // Write ballot information to file
        FileWriter writer = new FileWriter(fileName);
        writer.write(candidateInput);
        writer.close();
      }
      else{
        JOptionPane.showMessageDialog(null, "Field already exists!");
        System.out.println("File already exists.");
      }

    }
    catch(Exception exception){

    }

    return;
  }

}
