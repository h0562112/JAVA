package tw.org.iii.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.org.iii.classh.Mypanel;

public class MyBallGame extends JFrame{
	private Mypanel myPanel;
	
	public MyBallGame() {
		setLayout(new BorderLayout());
	
		myPanel = new Mypanel();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MyBallGame();
	}

}
