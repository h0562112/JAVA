package tw.org.iii.tutor;

import java.util.Timer;
import java.util.TimerTask;
public class test61 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask1(),3*1000,1000);
		timer.schedule(new StopTask(timer), 10*1000);
		System.out.println("main");
	}

}

class MyTask1 extends TimerTask{
	
		private int i;
		
		public void run() {
			System.out.println("OK" + i++);
		}
		
	}
class StopTask extends TimerTask{
	private Timer timer;
	public void run(Timer timer) {
		this.timer = timer;
	}
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	
	
	}
	

}


