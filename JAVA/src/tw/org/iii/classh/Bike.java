package tw.org.iii.classh;



public class Bike {
	protected double speed;
	public String owner;
	
	
	//建構式=物件初始化
	//建構式只會執行一次
	public Bike (){
		
	}
	public Bike(String name) {
		System.out.println("Bike(String)");
		owner = name;
	}
 public	void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}
	
 public void downSpeed() {
		speed = speed < 1 ? 0:speed * 0.5;
 }
		
 public double getSpeed() {
			return speed;
    }
}
