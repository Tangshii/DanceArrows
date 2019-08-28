import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DanceArrowsPanel extends JPanel
{
	private final int WIDTH = 1000, HEIGHT = 750;
	private ImageIcon up, down, right, left, currentImage, DDR, upgrey, downgrey, rightgrey, leftgrey;
	private int x, y, ax, ay;
	private int score;
	private int speed = 0;
	private JLabel label, combo, start, difficulty;
	
	public DanceArrowsPanel()
	{
		addKeyListener(new DirectionListener());
		setLayout(new BorderLayout());
		
		x = WIDTH / 2;
		y = HEIGHT / 2;
		ax = WIDTH / 2;
		ay = HEIGHT / 2;
		
		// images for arrow
		up = new ImageIcon("up.png");
		down = new ImageIcon("down.png");
		left = new ImageIcon("left.png");
		right = new ImageIcon("right.png");
		
		// images for grayed out arrows
		upgrey = new ImageIcon("upgrey.png");
		downgrey = new ImageIcon("downgrey.png");
		leftgrey = new ImageIcon("leftgrey.png");
		rightgrey = new ImageIcon("rightgrey.png");
		
		DDR = right;
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		
		// label shows score
		label = new JLabel();
		add(label, BorderLayout.NORTH);
		label.setFont(new Font("Bauhaus 93", Font.BOLD, 50));
		
		// label shows combo
		combo = new JLabel();
		add(combo, BorderLayout.SOUTH);
		combo.setFont(new Font("Bauhaus 93", Font.BOLD, 50));
		
		// start label
		start = new JLabel("PRESS SPACE TO START");
		start.setFont(new Font("Bauhaus 93", Font.BOLD, 75));
		add(start, BorderLayout.CENTER);
		start.setForeground(Color.white);
		
		// label shows difficulty
		difficulty = new JLabel("Easy(1)");
		difficulty.setFont(new Font("Bauhaus 93", Font.BOLD, 35));
		add(difficulty, BorderLayout.EAST);
		difficulty.setForeground(Color.white);
	}
	public void paintComponent(Graphics page)
	{
		// Random generator for next arrow direction 
		Random a = new Random();
		int song = a.nextInt(4);
		
		super.paintComponent(page);
		
		// paints grayed arrows
		leftgrey.paintIcon(this, page, x-400, y+200);
		downgrey.paintIcon(this, page, x-200, y+200);
		upgrey.paintIcon(this, page, x, y+200);
		rightgrey.paintIcon(this, page, x+200, y+200);
		
		// paints user controlled arrows   
		if (currentImage == left) 
			currentImage.paintIcon(this, page, x-400, y+200);
		if (currentImage == down)
			currentImage.paintIcon(this, page, x-200, y+200);
		if (currentImage == up)
			currentImage.paintIcon(this, page, x, y+200);
		if (currentImage == right)
			currentImage.paintIcon(this, page, x+200, y+200);
		
		// paints falling arrows, left, right, down, up
		if (DDR == left) {
			DDR.paintIcon(this, page, ax-400, ay-300);
				ay = ay + speed;
				repaint();
				 // arrows is beyond certain point, then assigns next arrow
				if(ay > 880) {
					ay = y;
					song = a.nextInt(4);
				 	if (song == 0)
				 		DDR = up;
				 	if (song == 1)
				 		DDR = down;
				 	if (song == 2)
				 		DDR = left;
				 	if (song == 3)
				 		DDR = right;
					repaint();
				}
		}
		if (DDR == down) {
	 		DDR.paintIcon(this, page, ax-200, ay-300);
	 		ay = ay + speed;
			repaint();
			if(ay > 880) {
				ay = y;
				song = a.nextInt(4);
			 	if (song == 0) 
			 		DDR = up;
			 	if (song == 1)
			 		DDR = down;
			 	if (song == 2)
			 		DDR = left;
			 	if (song == 3)
			 		DDR = right;
				repaint();
			}
		}
		if (DDR == up) {
	 		DDR.paintIcon(this, page, ax, ay-300);
	 		ay = ay + speed;
			repaint();
			if(ay > 880) {
				ay = y;
				song = a.nextInt(4);
			 	if (song == 0) 
			 		DDR = up;
			 	if (song == 1)
			 		DDR = down;
			 	if (song == 2)
			 		DDR = left;
			 	if (song == 3)
			 		DDR = right;
				repaint();
			}
		}
		if (DDR == right) {
	 		DDR.paintIcon(this, page, ax+200, ay-300);
	 		ay = ay + speed;
			repaint();
			if(ay > 880) {
				ay = y;
				song = a.nextInt(4);
			 	if (song == 0) 
			 		DDR = up;
			 	if (song == 1)
			 		DDR = down;
			 	if (song == 2)
			 		DDR = left;
			 	if (song == 3)
			 		DDR = right;
				repaint();
			}
		}
	}
	
	// key events listener 
	private class DirectionListener implements KeyListener
	{
		public void keyPressed(KeyEvent event)
		{
			switch (event.getKeyCode()) {
			// user press a certain direction then arrows shows that direction
			case KeyEvent.VK_UP:
				currentImage= up;
				// if falling arrow and user arrow matches score and combo incremented 
				if (currentImage == DDR) {
					score+=500;
					label.setText("SCORE: " + score);
					combo.setText(score/500 +"x COMBO!!");
					combo.setForeground(Color.magenta);
					label.setForeground(Color.magenta);
				}
			
				break;
			case KeyEvent.VK_DOWN:
				currentImage= down;
				if (currentImage == DDR) {
					score+=500;
					label.setText("SCORE: " + score);
					combo.setText(score/500 +"x COMBO!!");
					combo.setForeground(Color.blue);
					label.setForeground(Color.blue);
				}

				break;
			case KeyEvent.VK_LEFT:
				currentImage= left;
				if (currentImage == DDR) {
					score+=500;
					label.setText("SCORE: " + score);
					combo.setText(score/500 +"x COMBO!!");
					combo.setForeground(Color.green);
					label.setForeground(Color.green);
				}

				break;
			case KeyEvent.VK_RIGHT:
				currentImage= right;
				if (currentImage == DDR) {
					score+=500;
					label.setText("SCORE: " + score);
					combo.setText(score/500 +"x COMBO!!");
					combo.setForeground(Color.red);
					label.setForeground(Color.red);
				}
				break;
			
			// key for difficulty 
			case KeyEvent.VK_1:
				speed = 2;
				difficulty.setText("Easy(1)");
				break;
			
			case KeyEvent.VK_2:
				speed = 3;
				difficulty.setText("Med(2)");
				break;
			case KeyEvent.VK_3:
				speed = 5;
				difficulty.setText("Hard(3)");
				break;
			
			case KeyEvent.VK_4:
				speed = 99;
				difficulty.setText("INSANE(4)");
				break;
			
			case KeyEvent.VK_SPACE:
				speed = 2;
				start.setText("");
				break;
		}
		repaint();
	}
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}
	}
}
// arrow images from http://dancedancerevolution.wikia.com/wiki/Rainbow_(option)