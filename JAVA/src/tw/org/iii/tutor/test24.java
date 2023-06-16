package tw.org.iii.tutor;

import javax.swing.JFrame;

public class test24 extends JFrame{
	public test24(){
		super("我的視窗");
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new test24(); //需要呼叫才需要宣告
	}

}
