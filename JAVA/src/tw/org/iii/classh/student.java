package tw.org.iii.classh;

import java.io.Serializable;

public class student implements Serializable{
	private int math,eng,ch;
	private String name;
	
	public student(int math,int eng,int ch,String name) {
		this.math = math; this.eng = eng ; this.ch = ch;
		this.name =name;
	}
	public int sum() {return math+eng+ch;}
	public double avg() {return sum() /3.0;}
	public String getName() {return name;}
}

