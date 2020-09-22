package renwenxiang.game;

import java.awt.Graphics;
import java.awt.Image;

public class Enemy extends GameObject{
	
	
   public  Image armyImg;

	public Enemy(String path,int x,int y) {
		this.armyImg=GameUtil.getImage(path);
		this.x = x;
		this.y = y;
	}
	public void drawSelf(Graphics g){
		if(live){
			g.drawImage(armyImg,x, y, null);
		}
	 }

	public void  move() {
		this.y+=2;
	}
}
