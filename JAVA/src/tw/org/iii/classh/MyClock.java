package tw.org.iii.classh;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.util.SimpleAnnotationValueVisitor14;
import javax.swing.JLabel;
import javax.xml.crypto.Data;

public class MyClock extends JLabel{
	private Timer timer;

	public MyClock() {
		timer = new Timer();
		timer.schedule(new ClockTask(), 0, 100);
	}

	private class ClockTask extends TimerTask{
		@Override
	public void run() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		setText(sdf.format(now));
		}
	}
}
