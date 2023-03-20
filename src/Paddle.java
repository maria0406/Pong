import java.awt.Color;

public class Paddle {

	private int x, y, width, height;
	private int dy;
	private Color paddleColor;
	private int score;
	

	public Paddle() {
		x=0;
		y=0;
		width=0;
		height=0;
		score=0;
		dy=2;
		
	}
	
	public Paddle(int xV) {
		x=xV;
		y=0;
		width=200;
		height=400;
		score=0;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getW() {
		return width;
	}
	
	public int getH() {
		return height;
	}
	public int getScore() {
		return score;
	}
	
	public Color getColor() {
	return paddleColor;
    }
	
	public void setX(int dx) {
		x+=dx;
    }

	public void setY(int i) {
		// TODO Auto-generated method stub
		y+=i;
	}	
	public void setScore() {
		score++;
	}
	public void moveUp() {
		y=y-20;
		
	}
    public void moveDown() {
	y=y+20;
}   
}