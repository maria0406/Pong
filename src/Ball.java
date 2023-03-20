import java.awt.Rectangle;

public class Ball {
	
	private int x,y,w,h,  dx, dy;
	private String ballImg, bck, paddle1, paddle2;

	public Ball() {
		
		x=200;
		y=100;
		w=50;
		h=50;
		dx=2;
		dy=4;
		bck="grassbg.JFIF";
		ballImg="golfball.PNG";
		paddle1="golfclub.PNG";
		paddle2="golfclub2.PNG";

	
		
	}
	public Ball(int xV, int yV, int dxV, int dyV) {
		x=xV;
		y=yV;
		w=50;
		h=50;
		dx=dxV;
		dy=dyV;
		bck="grassbg.JFIF";
		ballImg="golfball.PNG";
		paddle1= "golfclub.PNG";
		paddle2="golfclub2.PNG";


	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
		
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public String getBallImg() {
		return ballImg;
	}
	public String getPaddle1() {
			return paddle1;
	}
	public String getPaddle2() {
				return paddle2;
	}
	public String getBackground() {
		return bck;
	}
	public void setX(int xV) {
		x=xV;
		
	}
	public void vert (){
		dy*=-1;
	}
	public void horz() {
		dx*=-1;
	}
	
	public void move() {
		
		x+=dx;
        y+=dy;

        System.out.println(x+w);
        System.out.println(dx);
		if (y<=0||y>=700) {
			
		    vert();		
		}
		
	}
	
	
public Boolean paddleCollison(Paddle p) {
	

	//if collision
	if(getX()<=(p.getX()+p.getW())&& (getY()+getH())>p.getY()&&p.getX()<(getX()+getW())&& getY()<(p.getY()+p.getH())) {
	
		 System.out.println("collision!!! px" + p.getX());
		 System.out.println("collision!!! x" + (getX()+getW()));
		horz();
	 
	
	 return true;
	
}

	//move();
	return false;
}


public void stop() {
	//TODO Auto-generated method stub
	
	x=300;
	y=300;
	dx=0;
	dy=0;
}
public void reset() {
	//TODO Auto-generated method stub
	x=300;
	y=300;
	
}
	
	// 
}

		

		   