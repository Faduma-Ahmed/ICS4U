package Ahmed;


import java.awt.Graphics;


import javax.swing.JPanel;

/**
 * 
 * This is a game that is very similar to "Flappy Bird".I personally liked the game so I decided to recreate it.
 * @version December 3rd, 2015
 * @author Faduma Ahmed
 * 
 * 
 */

public class Renderer extends JPanel {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		// repaints the screen back to its original background as the circle moves in the game 
		super.paintComponent(g);

		// constantly repaints the screen
		Bird.flap.repaint(g);
	}
}