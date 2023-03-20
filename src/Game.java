
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private Paddle player1, player2;
	private Ball b;
	private ImageIcon background, ball, paddle1, paddle2;
	private Boolean changeScreen, playMusic;
	private Player p;
	
	
	public Game() {
		back=null;
		p =new Player();
		p.playmusic("Someday.wav");
		new Thread(this).start();
		this.addKeyListener(this);
		key=-1;
		b=new Ball(250,50,2,2);
		changeScreen=false;
		ball= new ImageIcon(b.getBallImg());
		background= new ImageIcon(b.getBackground());
		paddle1= new ImageIcon(b.getPaddle1());
		paddle2= new ImageIcon(b.getPaddle2());
		
		player1 = new Paddle (30);
		player2=new Paddle (1200);
		
	
		
		
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.drawImage(background.getImage(), 0,0, getWidth(), getHeight(), this);
		g2d.drawImage(ball.getImage(),b.getX(), b.getY(), b.getW(), b.getH(), this);
		
		g2d.drawImage(paddle1.getImage(), player1.getX(),  player1.getY(), player1.getW(), player1.getH(),this);
		g2d.drawImage(paddle2.getImage(), player2.getX(),  player2.getY(), player2.getW(), player2.getH(),this);
		
		g2d.setFont(new Font ("Times", Font.BOLD, 78));
		Color mynewcolor = new Color(255,255,255);
		g2d.setColor(mynewcolor);
		g2d.drawString("Player 1 = " + player1.getScore() ,50, 50);
		g2d.drawString("Player 2 =" + player2.getScore(), 800, 50);
		
		
		if (player1.getScore()>=10)
			
		{
				p.playmusic("Victory sound effect.wav");	
				
				g2d.setFont(new Font("Times", Font.BOLD, 20));
				g2d.drawString("Final score for player 1: " + player1.getScore(), 500, 150);
				g2d.drawString("Final score for player 2: "+ player2.getScore(), 500,200);
				
				playMusic=false;
				b.stop();
			}
		if (player2.getScore()>=10)
	
		{
			p.playmusic("Victory sound effect.wav");
			
			g2d.setFont(new Font("Times", Font.BOLD, 20));
			g2d.drawString("Final score for player 1: " + player1.getScore(), 500, 150);
			g2d.drawString("Final score for player 2: "+ player2.getScore(), 500,200);
			b.stop();
			
		}
	
			
		
		

		collision();
	b.move();
    
		twoDgraph.drawImage(back, null, 0, 0);

	}


public void collision() {
	if(!b.paddleCollison(player1)&& b.getX()<player1.getX())	
	{
		//increase score for player 2
		// reset method
		b.reset();
		player2.setScore();
		player2.getScore();
		
	}
	

	else if(!b.paddleCollison(player2)&& b.getX()+b.getW()>(player2.getX()))
	 { //Increase score for player 1
	   //reset method
     	b.reset();
     	player1.setScore();
		player1.getScore();
     	
	 }
	 
	else
		b.move();
}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if (key==87) {
			player1.moveUp();
		}
		if (key==83) {
			player1.moveDown();
		}
		if (key==79) {
			player2.moveUp();
		}
		if (key==76) {
			player2.moveDown();
		}
		if (key==84) {
			b.vert();
		}
		if (key==70) {
			b.horz();
		}
		if(key==112) {
			b.stop();
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}
}

