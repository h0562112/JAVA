package lab01.xml;

public class Car implements ICar {
	private Integer speed;
	private Double hour;
    
	public Car() {
	}
	
	@Override
	public void getComment() {
		System.out.println("此車走了" + speed * hour + "公里");
	}

	@Override
	public Integer getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	public Double getHour() {
		return hour;
	}

	@Override
	public void setHour(Double hour) {
		this.hour = hour;
	}
	
}
