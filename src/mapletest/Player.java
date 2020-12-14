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
		icPlayerR = new ImageIcon("image/캐릭오른쪽걷기1.png");
		icPlayerL = new ImageIcon("image/캐릭왼쪽걷기1.png");
		icPlayerW = new ImageIcon("image/대기상태.png");
		icPlayerWL = new ImageIcon("image/왼쪽대기상태.png");
		icPlayerJ = new ImageIcon("image/캐릭점프.png");
		icPlayerJL = new ImageIcon("image/캐릭왼쪽점프.png");

		setIcon(icPlayerW);
		setSize(80, 110);
		setLocation(x, y);

	}

	public void 제드() {

		// 충돌 호출
		System.out.println("이즈리얼");
		if (Crash(player.x, player.y, enemy.x, enemy.y, player.width, player.height, enemy.width, enemy.height)) {
			System.out.println("충돌 발생");
			int result = JOptionPane.showConfirmDialog(null, "죽었습니다...", "메이플스토리", JOptionPane.OK_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.exit(0);
			}

		}
		// 충돌 호출

	}

	public void moveWating() {
		System.out.println("움직임 감지");
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
				setIcon(new ImageIcon("image/캐릭오른쪽걷기2.png"));
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setIcon(new ImageIcon("image/캐릭오른쪽걷기3.png"));
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setIcon(new ImageIcon("image/캐릭오른쪽걷기4.png"));
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
						// 오른쪽으로 보는중
						x++;
						setLocation(x, y); // 내부에 repaint() 존재
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
								setIcon(new ImageIcon("image/캐릭오른쪽걷기2.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/캐릭오른쪽걷기3.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/캐릭오른쪽걷기4.png"));
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
						setLocation(x, y); // 내부에 repaint() 존재

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
								setIcon(new ImageIcon("image/캐릭왼쪽걷기2.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/캐릭왼쪽걷기3.png"));
								Thread.sleep(300);
								setIcon(new ImageIcon("image/캐릭왼쪽걷기4.png"));
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
						setLocation(x, y); // 내부에 repaint() 존재
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
						setLocation(x, y); // 내부에 repaint() 존재
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
						setLocation(x, y); // 내부에 repaint() 존재
						if (floor == 1 && /* X좌표 */ y > 435) {
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

	// 충돌 함수
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
	// end 충돌

	// 구현안함
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
		skill = new ImageIcon("image/스킬샷.png");
		
//		System.out.println(Player.c + "생성완료");
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
					setLocation(x, y); // 내부에 repaint() 존재
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
