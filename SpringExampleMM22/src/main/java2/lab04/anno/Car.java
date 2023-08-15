package lab04.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements ICar {
	@Value("${lab04.car.speed}")
	private Integer speed;

	@Value("${lab04.car.hour}")
	private Double hour;
	
	@Value("${lab04.car.brand}")
	private String brand; 
	
	public Car() {
	}
	
	@Override
	public void getComment() {
		System.out.println(brand +"車走了"+ speed * hour + "公里");
	}

	@Override
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	public Double getHour() {
		return hour;
	}

	public void setHour(Double hour) {
		this.hour = hour;
	}
	
}
