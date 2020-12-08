package mapletest;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemyMushroom extends JLabel {
	public EnemyMushroom EnemyMushroom = this;
	public final static String TAG = "EnemyMushroom : ";

	public ImageIcon enemyMove;
	public int x = 555;
	public int y = 400;
	public int speed = 10;
	int 이즈리얼 = 0;
	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isUp = false;
	public boolean isDown = false;
	public boolean isMove = false;
	public boolean seewhere = true;

	int width = 200;
	int height = 210;
	public int floor = 1; // 535, 415, 295, 177

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

	public void moveRight() {
		System.out.println(TAG + "moveRight()");
		isRight = rd.nextBoolean();
		if (isRight == true) {
			new Thread(new Runnable() {
				@Override
				public void run() {

					while (true) {
						int wait = rd.nextInt() + 99999;
						isRight = rd.nextBoolean();

						if (0 < wait || wait < 33333) {
							x++;
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(5);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if (33333 < wait || wait < 66666) {
							x--;
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(5);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else
							setLocation(x, y);

					}

				}

			}).start();
		}
	}
	
	
	public void 이게실행될까제발(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					long n = System.currentTimeMillis()/1000;
					if(n % 5 == 0) {
						speed = 100;
						이즈리얼 = rd.nextInt(3);
					}
					speed = 10;	
				}	
			}
		}).start();
	}
	
	public void moveRight3() {
		System.out.println(TAG + "moveRight()");

		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
	
						if (이즈리얼 == 1) {
							x++;
							if (x >= 1100) {
								이즈리얼 = 2;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(speed);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if (이즈리얼 == 2) {

							x--;
							if (x <= 05) {
								이즈리얼 = 1;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(speed);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						} else if (이즈리얼 == 0) {
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

	public void moveRight2() {
		System.out.println(TAG + "moveRight()");
		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isRight = rd.nextBoolean();
					while (true) {
						if (isRight == true) {
							x++;
							if (x >= 1100) {
								isRight = false;
							}
							setLocation(x, y); // 내부에 repaint() 존재
							try {
								Thread.sleep(5);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {

							x--;
							if (x <= 05) {
								isRight = true;
							}
							setLocation(x, y); // 내부에 repaint() 존재
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
