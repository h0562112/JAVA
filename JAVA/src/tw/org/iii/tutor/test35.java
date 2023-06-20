package tw.org.iii.tutor;

public class test35 {

	public static void main(String[] args) {
		shape s1 = new RecShap(10,4);
		shape s2 = new CircleShape(3);
		System.out.println(s1.);
		sumArea(s1,s2);
	}
	static void sumArea(Shape s1, Shape s2) {
		System.out.println(s1.);
	}
}
abstract class shape{
	abstract double calArea();
	abstract double calLength();
}
class RecShap extends shape{
	double w,h;
	RecShap(double w,double h){this.w=w; this.h=h;}
	double calArea() {
		return w*h;
	}
	double calLength() {
		return (w+h)*2;
	}
}
class CircleShae extends shape{
	double r;
	CircleShae(double r){this.r = r;}
	double calArea() {
		return Math.PI * r * r;
	}
	double calLength() {
		
	}
}