package mapletest;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class BubbleApp extends JFrame implements Initable{
	// ���ؽ�Ʈ�� �׻� ����
	private BubbleApp bubbleApp = this;
	// �±� �ʼ�
	private static final String TAG = "BubbleApp : ";
	
	JLabel laBackground;
	public Player player;
	public EnemyMushroom enemy;
	skil sr;
	Container c = getContentPane();
	public BubbleApp() {
		init(); //new
		setting();
		batch(); 
		listener();
		
		setVisible(true); //������ ����
	}

	public static void main(String[] args) {
		new BubbleApp();
	}
	
	
	@Override
	public void init() {
		laBackground = new JLabel(new ImageIcon("image/background.png"));
		player = new Player();
		enemy = new EnemyMushroom("image/��Ȳ����.gif",555,400);
	    Thread c = new Thread(new col());
	    c.start();
	}
	
	@Override
	public void setting() {
		setTitle("������ �׽�Ʈ");
		setSize(1290, 759);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setContentPane(laBackground);
	}

	@Override
	public void batch() {
		add(player); //getContentPane()���� ���� 
		add(enemy);
	}

	@Override
	public void listener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.moveRight1();
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.moveLeft();
				} else if(e.getKeyCode() == KeyEvent.VK_UP) {
					player.moveUp();
				} else if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
					add(player.skilshot());
					sr = player.skilshot();
					
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.isRight = false;
					player.isMove = false;
					
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.isLeft = false;
					player.isMove = false;
					
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.isUp = false;
					player.isMove = false;
				} 
				
			}
		});
		
	}
	
	class col extends Thread {
		@Override
		public void run() {
			
			while(true) {
				try {
					System.out.println("asd");
					Thread.sleep(10);
					if (Crash(sr.x, sr.y, enemy.x, enemy.y, sr.width, sr.height, enemy.width, enemy.height)) {
						System.out.println("��ų ����!");
						enemy.hp -= 20;
						System.out.println("���� :" + enemy.hp);
						if(enemy.hp == 0) {
							enemy.setIcon(null);
							enemy.x = 99999;
							c.remove(enemy);
						}
						sr.x = -99999;
						c.remove(sr);
					}
					if (Crash(player.x, player.y, enemy.x, enemy.y, player.width, player.height, enemy.width, enemy.height)) {
						System.out.println("�浹 �߻�");
						player.hp -= 10;
						System.out.println("�����hp"+ player.hp);
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
	}
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
}
