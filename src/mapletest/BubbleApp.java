package mapletest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Initable{
	// ���ؽ�Ʈ�� �׻� ����
	private BubbleApp bubbleApp = this;
	// �±� �ʼ�
	private static final String TAG = "BubbleApp : ";
	JLabel laBackground;
	private Player player;
	private Enemy enemy;
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
					player.moveRight();
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.moveLeft();
				} else if(e.getKeyCode() == KeyEvent.VK_UP) {
					player.moveUp();
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

}
