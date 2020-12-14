package mapletest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Player extends JLabel {

	public Player player = this;
	public final static String TAG = "Player : ";
	EnemyMushroom enemy;
	public ImageIcon icPlayerR, icPlayerL, icPlayerW, icPlayerJ, icPlayerWL, icPlayerJL;
	public int x = 55;
	public int y = 490;
	public int speed = 0;
	public int hp = 100;
	int width = 80;
	int height = 110;

	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isUp = false;
	public boolean isDown = false;
	public boolean isMove = false;
	public boolean seewhere = true;

	public int floor = 1; // 535, 415, 295, 177

	public Player() {
		icPlayerR = new ImageIcon("image/ĳ�������ʰȱ�1.png");
		icPlayerL = new ImageIcon("image/ĳ�����ʰȱ�1.png");
		icPlayerW = new ImageIcon("image/������.png");
		icPlayerWL = new ImageIcon("image/���ʴ�����.png");
		icPlayerJ = new ImageIcon("image/ĳ������.png");
		icPlayerJL = new ImageIcon("image/ĳ����������.png");

		setIcon(icPlayerW);
		setSize(80, 110);
		setLocation(x, y);

	}

	public void ����() {

		// �浹 ȣ��
		System.out.println("�����");
		if (Crash(player.x, player.y, enemy.x, enemy.y, player.width, player.height, enemy.width, enemy.height)) {
			System.out.println("�浹 �߻�");
			int result = JOptionPane.showConfirmDialog(null, "�׾����ϴ�...", "�����ý��丮", JOptionPane.OK_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.exit(0);
			}

		}
		// �浹 ȣ��

	}

	public void moveWating() {
		System.out.println("������ ����");
		if (isMove == false) {
			setIcon(icPlayerW);
		}
	}

	public void moveWatingleft() {
		if (isMove == false) {
			setIcon(icPlayerWL);
		}
	}

	public void motionRight() {
		new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setIcon(new ImageIcon("image/ĳ�������ʰȱ�2.png"));
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setIcon(new ImageIcon("image/ĳ�������ʰȱ�3.png"));
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setIcon(new ImageIcon("image/ĳ�������ʰȱ�4.png"));
			}
		}).start();
	}

	public void moveRight1() {
		System.out.println(TAG + "moveRight()");

		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {

					isRight = true;
					while (isRight) {
						// ���������� ������
						x++;
						setLocation(x, y); // ���ο� repaint() ����
						try {
							Thread.sleep(3);
							setIcon(icPlayerW);

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					setIcon(icPlayerW);

				}
			}).start();
		}
	}

	public void moveRight() {
		System.out.println(TAG + "moveRight()");

		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {

					setIcon(icPlayerR);
					isMove = true;
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(300);
								setIcon(new ImageIcon("image/ĳ�������ʰȱ�2.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/ĳ�������ʰȱ�3.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/ĳ�������ʰȱ�4.png"));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();

					isRight = true;
					seewhere = true;
					while (isRight) {

						x++;
						setLocation(x, y); // ���ο� repaint() ����

						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					moveWating();
				}

			}).start();
		}

	}

	public void moveLeft() {
		System.out.println(TAG + "moveLeft()");

		if (isLeft == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isMove = true;
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(300);
								setIcon(new ImageIcon("image/ĳ�����ʰȱ�2.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/ĳ�����ʰȱ�3.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/ĳ�����ʰȱ�4.png"));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();
					isLeft = true;
					seewhere = false;
					while (isLeft) {
						x--;
						setLocation(x, y); // ���ο� repaint() ����
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					moveWatingleft();
				}
			}).start();
		}

	}

	public void moveUp() {
		System.out.println(TAG + "moveUp()");
		if (isUp == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isMove = true;
					isUp = true;
					if (seewhere == true) {
						setIcon(icPlayerJ);
					} else if (seewhere == false)
						setIcon(icPlayerJL);

					for (int i = 0; i < 130; i++) {
						y--;
						setLocation(x, y); // ���ο� repaint() ����
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					moveDown();
				}
			}).start();
		}
	}

	public void moveDown() {
		System.out.println(TAG + "moveDown()");
		if (isDown == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isDown = true;
					while (isDown) {
						y++;
						setLocation(x, y); // ���ο� repaint() ����
						if (floor == 1 && /* X��ǥ */ y > 435) {
							isDown = false;
							isUp = false;
							break;
						}

						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (seewhere == true) {
						moveWating();
					} else if (seewhere == false) {
						moveWatingleft();
					}

				}
			}).start();
		}

	}

	// �浹 �Լ�
	public boolean Crash(int playerX, int playerY, int enemyX, int enemyY, int playerW, int playerH, int enemyW,
			int enemyH) {
		boolean check = false;
		if (Math.abs((playerX + (playerW / 2)) - (enemyX + enemyW / 2 + 20)) < (enemyW / 2 + playerW / 2 - 60)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	// end �浹

	// ��������
	public void attack() {
		
	}
	
	public skil skilshot() {
		skil s = new skil(x,y);
		return s;
	}

	static int c = 0;
}

class skil extends JLabel {
	public int x;
	public int y;
	int width = 120;
	int height = 110;
	ImageIcon skill;
	boolean isattack = true;
	public skil(int x, int y) {
		this.x = x; this.y = y;
		skill = new ImageIcon("image/��ų��.png");
		
//		System.out.println(Player.c + "�����Ϸ�");
		Player.c++;
		setIcon(skill);
		setSize(400, 110);
		setLocation(x, y);
		
		skill();
	}

	public void skill() {
		new Thread(new Runnable() {
			@Override
			public void run() {

				while (isattack) {
					x++;
					setLocation(x, y); // ���ο� repaint() ����
					try {
						Thread.sleep(3);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

}
