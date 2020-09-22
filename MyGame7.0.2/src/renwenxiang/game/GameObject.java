package renwenxiang.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject implements IGameObject{
	public int x,y;
	boolean up,down,left,right,live=true;
	Image img;
	public int speed;
	public int width, height;
	Image enemyImg;
	public  Image armyImg;

	
	public GameObject(String path,int x,int y) {
		this.armyImg=GameUtil.getImage(path);
		this.x = x;
		this.y = y;
	}
	
	public GameObject(int x,int y,int speed,int width,int height) {
		super();
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.width=width;
		this.height=height;
	}
	public GameObject(Image img, int x, int  y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public GameObject(int x,int y,String path) {
		this.x = x;
		this.y = y;
		this.enemyImg=GameUtil.getImage(path);
	}
	public GameObject() {
	}
	public void drawSelf(Graphics g){
		if(live){
			g.drawImage(img,x, y, null);
		}else
		{ 
		}
	 }
	public void move() {
		if(left){
			if(x>4)this.x-=5;
		 }
		 if(right){
			if(x<580)this.x+=5;
		 }
		 if(up){
			if(y>40)this.y-=5;
		 }
		 if(down){
			if(y<530)this.y+=5;
		 }
	}
	public Rectangle getRect(){
	      return  new Rectangle((int)x,(int) y, width, height);
	}

}
