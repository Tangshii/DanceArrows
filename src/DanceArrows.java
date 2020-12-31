import javax.swing.JFrame;
public class DanceArrows
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Dance");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DanceArrowsPanel());
		frame.pack();
		frame.setVisible(true);
	}
}