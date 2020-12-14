package mapletest;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	public Enemy enemy = this;
	public final static String TAG = "Enemy : ";

	public ImageIcon enemyMove;
	
	public int x = 555;
	public int y = 400;
	public int speed;
	
	int moveState=0;
	
	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isMove = false;
	
	int width = 200;
	int height = 210;

	public int floor; // 535, 415, 295, 177

	Random rd = new Random();// 랜덤 객체 생성
	Timer tTimer = new  Timer();
	public Enemy() {
		
	}
	public Enemy(String string,int x, int y) {
		this.x = x;
		this.y = y;
		enemyMove = new ImageIcon(string);

		setIcon(enemyMove);
		setSize(200, 210);
		setLocation(x, y);

		moveRight3();
		
	}

	public void moveRight3() {
		System.out.println(TAG + "moveRight()");
		
		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
//					isRight = rd.nextBoolean();
					
					while (true) {
						
						long n = (long)(System.currentTimeMillis())/1000;
						
						int nn = (int) (n % 100);
						
						if(0<=nn && nn <= 33) {
							moveState = 1;
						} else if(34<=nn && nn <= 66) {
							moveState = 2;
						} else if((67<=nn && nn <= 99))
							moveState = 0;
						
//						if(n%5 == r || n%5 == r) {
//							moveState = 1;
//						} else if(n%5 == r || n%5 == r) {
//							moveState = 2;
//						} else if(n%5 == 0)
//							moveState = 0;
						
						if (moveState == 1) {
							x++;
							if (x >= 1100) {
								moveState = 2;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(5);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if(moveState == 2) {

							x--;
							if (x <= 05) {
								moveState = 1;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						} else if(moveState == 0) {
							setLocation(x, y);
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}

			}).start();
		}
	}
	
	

	public void moveLeft() {

	}

	// 구현안함
	public void attack() {

	}
}
