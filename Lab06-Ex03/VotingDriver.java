import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class VotingDriver {
  private static void createAndDisplayGUI() {
    // Create frame and instance of Ballot
    JFrame frame = new JFrame();
    Ballot ballot = new Ballot();

    frame.getContentPane().add(ballot.getPanel());
    frame.setSize(400,200);
    // Enable the exit button on frame to close application
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    createAndDisplayGUI();
  }
}
