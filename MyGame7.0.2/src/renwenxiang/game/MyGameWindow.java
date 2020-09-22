package renwenxiang.game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MyGameWindow  extends Frame{
	private Image offScreenImage = null;
	
	Image bg=GameUtil.getImage("images/bg.jpg");
	Image planeImg=GameUtil.getImage("images/plane.png");
	public int planeX = 300;
	public int planeY = 500;
	Plane plane = new Plane(planeImg,planeX, planeY);
	ArrayList<GameObject> gameObject=new ArrayList<GameObject>();
	
	
	public void runGame() {
		this.setTitle("Rn_QingAn");
		this.setSize(640, 590);
		this.setLocation(650, 250);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new EnemyThread().start();
		new PaintThread().start(); //重绘线程
		new ShellThread().start();
		addKeyListener(new KeyMonitor());	//给窗口增加键盘的监听
	}
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	
		plane.drawSelf(g);
		
		plane.move();
		int i;

		for(i=0;i<gameObject.size();i++) {
			GameObject object=gameObject.get(i);
			object.drawSelf(g);
			object.move();
			if(object.y>590 || object.y<20) {
				gameObject.remove(object);
			}
			System.out.println("飞机的数量呢？"+gameObject.size());
			
		}
		
		
		
		/*for(GameObject object:gameObject) {
		object.drawSelf(g);
		object.move();
		if(object.y>590 || object.y<35) {
			gameObject.remove(object);
		}
		System.out.println("飞机的数量呢？"+gameObject.size());
	
	}*/
	}
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自动生成的方法存根
			plane.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根
			plane.minusDirection(e);
		}
	}
	
	class  ShellThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
				if(plane.shoot) {
					Shell s=new Shell(plane.x,plane.y);
					gameObject.add(s);
				}
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}	
	}
	
	class  PaintThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
				repaint();		//重画
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}	
	}
	
	class  EnemyThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
				int x=(int) (Math.random()*575+1);
				int num=(int) (Math.random()*6+1);
				System.out.println(num);
				Enemy enemy =new Enemy("images/enemy_"+num+".png",x,40);
				enemyShell s2=new enemyShell(enemy.x,enemy.y);
				gameObject.add(enemy);
				gameObject.add(s2);
				try {
					Thread.sleep(3000);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}	
	}
	
	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(640, 590);// 这是游戏窗口的宽度和高度
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
