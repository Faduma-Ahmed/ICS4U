package Ahmed;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * This is a game that is very similar to "Flappy Bird".I personally liked the game so I decided to recreate it. 
 * November 22-27, 2015
 * @author Faduma Ahmed
 *
 */

public class BallFromMove extends MovingObject {

	/**
	 * integers that hold the speed and radius of the ball
	 */
	
	//private int  xspeed, yspeed;
	
	
	
	/**
	 * 
	 * This constructors uses the parameters inherited from Moving Object to make an object
	 * @param x
	 * @param y
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 */
	public BallFromMove(double x, double y, int left, int right, int top, int bottom
			) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		
		
	}

	/** This method draws a ball on the screen
	 * @see Ahmed.MovingObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE.brighter());
		g.fillRect((int) x,(int) y,left,right);
	}

	/** 
	 * THis method controls how the object will move
	 * @see Ahmed.MovingObject#animateOneStep()
	 */
	@Override
	public void animateOneStep() {
		
		
		x += getxSpeed();
		y += getySpeed();
		
		
		if (x < 0)
			setX((int)Math.abs(getxSpeed()));
		if (y < 0)
			setY((int)Math.abs(getySpeed()));
	}

}
