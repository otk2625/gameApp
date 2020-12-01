package bubblebubble;

import javax.swing.*;

public class Player2 extends JLabel {
	public Player2 player = this;
	public final static String TAG = "Player : ";
	public ImageIcon icPlayerR, icPlayerL;
	public int x = 55, y = 535; // 라벨 좌표
	public boolean isRight = false;
	public boolean isJump = false;
	public int floor = 1; // 535

	public Player2() {
		icPlayerR = new ImageIcon("image/PlayerR.png");
		icPlayerL = new ImageIcon("image/PlayerL.png");
		setIcon(icPlayerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void moveRight() {
		System.out.println(TAG + "moveRight()");

		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isRight = true;

					while (isRight) {
						x = x + 1;
						setLocation(x, y); // repaint() 호출 안해도됨 내부에 존재
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}

		setIcon(icPlayerR);
	}

	public void moveLeft() {
		System.out.println(TAG + "moveLeft()");
		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isRight = true;
					while (isRight) {
						x--;
						setLocation(x, y); // repaint() 호출 안해도됨 내부에 존재
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		setIcon(icPlayerL);
	}

	public void moveUp() {
		System.out.println(TAG + "moveUp()");

		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isRight = true;
					while (isRight) {
						y--;
						if (y < 435) {
							break;
						}
						setLocation(x, y); // repaint() 호출 안해도됨 내부에 존재
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}).start();
		}

	}

	public void moveJump() {
		System.out.println(TAG + "moveJump()");

		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isRight = true;
					while (isRight) {
						y--;
						if (y < 435) {
							break;
						}
						setLocation(x, y); // repaint() 호출 안해도됨 내부에 존재
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					while (isRight) {
						y++;
						if (floor == 1 && /* X좌표 */ y == 535) {
							isRight = false;
							isJump = false;
							break;
						}
						setLocation(x, y); // repaint() 호출 안해도됨 내부에 존재
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block

							e.printStackTrace();
						}
					}
				}
			}).start();
		}

	}

	// 구현안함
	public void attack() {

	}

}
