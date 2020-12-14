package mapletest;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemyMushroom extends JLabel {
	public EnemyMushroom EnemyMushroom = this;
	public final static String TAG = "EnemyMushroom : ";
	int hp = 100;
	public ImageIcon enemyMove;
	public int x = 555;
	public int y = 400;
	public int speed = 10;
	int moveState = 0;
	public boolean isRight = false;
	

	int width = 200;
	int height = 210;

	Random rd = new Random();// 랜덤 객체 생성
	Timer tTimer = new Timer();

	public EnemyMushroom(String string, int x, int y) {
		this.x = x;
		this.y = y;
		
		enemyMove = new ImageIcon(string);

		setIcon(enemyMove);
		setSize(200, 210);
		setLocation(x, y);

		이게실행될까제발();
		moveRight3();
		
	}

	
	
	
	public void 이게실행될까제발(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					long n = System.currentTimeMillis()/1000;
					if(n % 5 == 0) {
						speed = 100;
						moveState = rd.nextInt(3);
					}
					speed = 5;	
				}	
			}
		}).start();
	}
	
	public void moveRight3() {
		System.out.println(TAG + "moveRight()");

		
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
	
						if (moveState == 1) {
							setIcon(new ImageIcon("image/주황버섯.gif"));
							x++;
							if (x >= 1100) {
								moveState = 2;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(speed);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if (moveState == 2) {
							setIcon(new ImageIcon("image/주황버섯왼쪽.gif"));
							x--;
							if (x <= 05) {
								moveState = 1;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(speed);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						} else if (moveState == 0) {
							setLocation(x, y);
							try {
								Thread.sleep(speed);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}

			}).start();
		
	}

}
