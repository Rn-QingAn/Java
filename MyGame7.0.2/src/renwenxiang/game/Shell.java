package renwenxiang.game;

import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameObject{
	
	public Shell() {
		
	}
	
	public Shell(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void drawSelf(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillRect(this.x, this.y - 10, 2, 7);
		g.fillRect(this.x + 60, this.y - 10, 2, 7);
		g.fillRect(this.x+40, this.y - 30, 2, 7);
		g.fillRect(this.x + 20, this.y - 30, 2, 7);
	}
	public void move() {
		this.y-=10;
	}
}
