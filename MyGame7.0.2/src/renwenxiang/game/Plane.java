package renwenxiang.game;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	public boolean shoot;
	public Plane(Image img,int x,int y){
		this.img = img;
		this.x = x;
		this.y = y;		
	}
	
	
	

	//�ɻ��ƶ��ķ�λ
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_SPACE:
			shoot=true;
		}
	}
	
	//ȡ����Ӧ�ķ���
	public void minusDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_SPACE:
			shoot=false;
		}
	}
	public void shoot(){
		this.y+=7;
	}
}
