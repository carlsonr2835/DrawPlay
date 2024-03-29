import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 75;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;

	private static final int EAR_HEIGHT = 20;
	private static final int EAR_WIDTH = 10;
	private static final int EAR_X = HEAD_DIMENSION;
	private static final int EAR_Y = HEAD_DIMENSION / 4;
	private static final int BODY_X = 60;
	private static final int BODY_Y = 40;

	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.blue);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.white);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.yellow);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);

		g2.setColor(Color.pink);
		x = catX + EAR_X;
		y = catY + EAR_Y;
		g2.fillPolygon(new int[] {x, x + EAR_WIDTH / 2, x + EAR_WIDTH}, new int[] {y, y - EAR_HEIGHT, y}, 3);
		//g2.rotate(45);

		g2.fillPolygon(new int[] {x - 8 * EAR_WIDTH, x - 7 * EAR_WIDTH , x - 6 * EAR_WIDTH}, new int[] {y, y - EAR_HEIGHT, y}, 3);
		//g2.rotate(-45);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing

		g2.setColor(Color.green);
		x = catX + BODY_X;
		y = catY + BODY_Y;
		g2.fillPolygon(new int[] {x + 20, x + BODY_X / 2, x + BODY_Y}, new int[] {y+20, y - BODY_Y, y+20}, 3);

		g2.setColor(Color.yellow);
		g2.fillRect(x, y, x + BODY_Y, y + 10);


		g2.setColor(Color.pink);

		g2.drawString("I hate ryon", catX, catY+HEAD_DIMENSION+10);	
		g2.drawString("I'm a very silly cat", catX+HEAD_DIMENSION+30, catY+HEAD_DIMENSION+40);	
		g2.drawString("Here is my green magic wand!", catX+HEAD_DIMENSION+50, catY+HEAD_DIMENSION+70);
	}
}
