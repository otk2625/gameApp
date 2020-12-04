package mapletest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Initable{
	// 컨텍스트는 항상 저장
	private BubbleApp bubbleApp = this;
	// 태그 필수
	private static final String TAG = "BubbleApp : ";
	JLabel laBackground;
	private Player player;
	private Enemy enemy;
	public BubbleApp() {
		init(); //new
		setting();
		batch(); 
		listener();
		
		setVisible(true); //마지막 고정
	}

	public static void main(String[] args) {
		new BubbleApp();
	}

	@Override
	public void init() {
		laBackground = new JLabel(new ImageIcon("image/background.png"));
		player = new Player();
		enemy = new EnemyMushroom("image/주황버섯.gif",555,400);
		
	}
	
	@Override
	public void setting() {
		setTitle("메이플 테스트");
		setSize(1290, 759);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setContentPane(laBackground);
	}

	@Override
	public void batch() {
		add(player); //getContentPane()생략 가능 
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
