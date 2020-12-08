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
	int �����=0;
	public boolean isRight = false;
	public boolean isLeft = false;

	public boolean isMove = false;
	int width = 200;
	int height = 210;

	public int floor; // 535, 415, 295, 177

	Random rd = new Random();// ���� ��ü ����
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
							setLocation(x, y); // ���ο� repaint() ����
							try {
								Thread.sleep(5);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if (33333 < wait || wait < 66666) {
							x--;
							setLocation(x, y); // ���ο� repaint() ����
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
							����� = 1;
						} else if(34<=nn && nn <= 66) {
							����� = 2;
						} else if((67<=nn && nn <= 99))
							����� = 0;
						
//						if(n%5 == r || n%5 == r) {
//							����� = 1;
//						} else if(n%5 == r || n%5 == r) {
//							����� = 2;
//						} else if(n%5 == 0)
//							����� = 0;
						
						if (����� == 1) {
							x++;
							if (x >= 1100) {
								����� = 2;
							}
							setLocation(x, y); // ���ο� repaint() ����
							try {
								Thread.sleep(5);

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if(����� == 2) {

							x--;
							if (x <= 05) {
								����� = 1;
							}
							setLocation(x, y); // ���ο� repaint() ����
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

						} else if(����� == 0) {
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
							setLocation(x, y); // ���ο� repaint() ����
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
							setLocation(x, y); // ���ο� repaint() ����
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

	// ��������
	public void attack() {

	}
}
