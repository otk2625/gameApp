package mapletest;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	public Enemy enemy = this;
	public final static String TAG = "Enemy : ";

	public ImageIcon enemyMove;
	public int x = 555;
	public int y = 400;

	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isUp = false;
	public boolean isDown = false;
	public boolean isMove = false;
	public boolean seewhere = true;

	public int floor = 1; // 535, 415, 295, 177

	Random rd = new Random();// ���� ��ü ����

	public Enemy() {
		enemyMove = new ImageIcon("image/��Ȳ����.gif");

		setIcon(enemyMove);
		setSize(200, 210);
		setLocation(x, y);

		moveRight2();
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
