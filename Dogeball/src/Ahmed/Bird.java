package Ahmed;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;
/**
 * 
 * This is a game that is very similar to "Flappy Bird".I personally liked the game so I decided to recreate it.
 * @version December 3rd, 2015
 * @author Faduma Ahmed
 * 
 * 
 */
public class Bird implements ActionListener, MouseListener, KeyListener {

	// these are all the feilds for the game.


	/**
	 * Object of BallFromMove class 
	 */
	
	private BallFromMove ball;

	/**
	 * Object of this class to be used in Rendering
	 */
	public static Bird flap;

	/**
	 * Width and height of the Panel
	 */
	public final int WIDTH = 800, HEIGHT = 800;
	/**
	 * Object of Renderer class
	 */
	public Renderer renderer;

	/**
	 * Object of Rectangle class
	 */
	public Rectangle birdy;

	/**
	 * Array List to Store Columns
	 */
	public ArrayList<Rectangle> columns;

	/**
	 * Will control the movements of the ball and the score
	 */
	public int moves, ySpeed, score;
	/**
	 * Boolean to check if the person has started the game of if the lost
	 */
	public boolean gameEnded, gameBegin;

	/**
	 * Random Object to make the columns
	 */
	public Random random;

	/**
	 * This constructor helps to initialize the jPanel with a jFrame and make
	 * four initial columns appear on the screen
	 */
	public Bird() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		// new object of Renderer class
		renderer = new Renderer();
		// New Object
		random = new Random();
		// adds the object Renderer to current frame
		jframe.add(renderer);
		// sets the title
		jframe.setTitle("Obstacle");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		// Adds mouse and key detection so the user can start the game
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		// Prohibits the user from resizing the screen
		jframe.setResizable(false);
		jframe.setVisible(true);

		// Make new objects
		birdy = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		columns = new ArrayList<Rectangle>();

		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);

		timer.start();
	}

	/**
	 * This method makes two columns and randomly decides the height between
	 * them. It will initially make the four columns when the user starts the
	 * game but will add new columns of different height after
	 * 
	 * @param start
	 *            , checks if the user just started the game
	 * 
	 */
	public void addColumn(boolean start) {
		int space = 300;
		int width = 100;
		int height = 50 + random.nextInt(300);

		// adds the initial columns
		if (start) {
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		// adds the new column as the user proceeds in the game
		else {
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
		}
	}

	/**
	 * 
	 * This Method pints the columns on the screen so they are visible to the
	 * user
	 * 
	 * @param g
	 *            , the graphics element
	 * @param column
	 *            , the rectangle columns to appear on the screen
	 */
	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.RED.darker().darker().darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	/**
	 * THis controls the motion of the ball. When the user presses the space
	 * button
	 * 
	 */
	public void jump() {
		// if the game is over the ball wont move and it will reset back to the
		// format with the 4 columns at the beginning of the game
		if (gameEnded) {
			birdy = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			// clears the arrayList of columns
			columns.clear();
			// resets the motion and score
			ySpeed = 0;
			score = 0;

			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);

			gameEnded = false;
		}

		if (!gameBegin) {
			gameBegin = true;
		} else if (!gameEnded) {
			if (ySpeed > 0) {
				ySpeed = 0;
			}

			ySpeed -= 10;
		}
	}

	/**
	 * This is an method overrides the actionPerformed() in its superclass,
	 * ActionListener It controls how the columns will appear and reappear on
	 * the screen
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 6;

		moves++;

		if (gameBegin) {
			for (int i = 0; i < columns.size(); i++) {
				// reduces the length of the columns to mimic a moving screen
				Rectangle column = columns.get(i);

				column.x -= speed;
			}

			// if the remainder of the ticks is less then zero then the motion
			// increases
			if (moves % 2 == 0 && ySpeed < 15) {
				ySpeed += 2;
			}

			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);

				if (column.x + column.width < 0) {
					// removes the column if it has been passed during the game
					columns.remove(column);

					if (column.y == 0) {
						// adds new columns to the screen but in a way where it
						// wont be painted twice
						addColumn(false);
					}
				}
			}

			birdy.y += ySpeed;

			for (Rectangle column : columns) {
				// checks if the user went through the column and adds to the
				// score
				if (column.y == 0 && birdy.x + birdy.width / 2 > column.x + column.width / 2 - 10
						&& birdy.x + birdy.width / 2 < column.x + column.width / 2 + 10) {
					score += 1;
				}
				// checks if the two objects intersect each other . It the do
				// the game will end
				if (column.intersects(birdy)) {
					gameEnded = true;

					if (birdy.x <= column.x) {
						birdy.x = column.x - birdy.width;

					} else {
						if (column.y != 0) {
							birdy.y = column.y - birdy.height;
						} else if (birdy.y < column.height) {
							birdy.y = column.height;
						}
					}
				}
			}

			// checks if the birds height surpasses the height of the screeen or
			// the ground
			if (birdy.y > HEIGHT - 120 || birdy.y < 0) {
				gameEnded = true;
			}

			if (birdy.y + ySpeed >= HEIGHT - 120) {
				birdy.y = HEIGHT - 120 - birdy.height;
				gameEnded = true;
			}
		}

		// constantly repaints
		renderer.repaint();
	}

	public void drawBall(Graphics g) {
		ball = new BallFromMove(birdy.x, birdy.y, birdy.width, birdy.height, 5, 8);
		ball.draw(g);

	}

	/**
	 * this draws the background of the screen, displays the score to the user
	 * and if the lost
	 * 
	 * @param g
	 *            , Graphic Element
	 */
	public void repaint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.WHITE);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);

		g.setColor(Color.BLACK);
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);

		g.setColor(Color.ORANGE.brighter());
		g.fillOval(birdy.x, birdy.y, birdy.width, birdy.height);
		ball = new BallFromMove(birdy.x, birdy.y, birdy.width, birdy.height, 5, 8);
		ball.draw(g);

		for (Rectangle column : columns) {
			// paints the columns to the screen
			paintColumn(g, column);
		}

		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", 1, 50));

		if (!gameBegin) {
			// begins the game
			g.drawString("Click to begin the game", 0, HEIGHT / 2 - 50);
		}

		if (gameEnded) {
			// appear if the user lost the game
			g.drawString("You have lost", 0, HEIGHT / 2 - 50);
		}

		if (!gameEnded && gameBegin) {
			// shows the value of the sore
			g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		}
	}

	public static void main(String[] args) {
		// creates a new object
		flap = new Bird();
	}

	/**
	 * this calls on the jump method if the user clicks the screen
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// calls on the movement method if cicked
		jump();
	}

	/**
	 * If the user presses the space key the bird motion will move
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {

	}
}
