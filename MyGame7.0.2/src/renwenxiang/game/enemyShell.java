package renwenxiang.game;

import java.awt.Color;
import java.awt.Graphics;

public class enemyShell extends GameObject{
	
	public enemyShell() {
		
	}
	
	public enemyShell(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void drawSelf(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillRect(this.x+45, this.y + 30, 2, 7);
		g.fillRect(this.x + 15, this.y + 30, 2, 7);
	}
	public void move() {
		this.y+=4;
	}
}