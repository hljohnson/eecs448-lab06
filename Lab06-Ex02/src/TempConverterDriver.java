import javax.swing.JFrame;


public class TempConverterDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Temperature Converter");
		TempConverter converter = new TempConverter();


		frame.getContentPane().add(converter.getContent());
    frame.setSize(500, 300);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
