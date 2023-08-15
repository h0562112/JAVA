package lab06.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"lab06.properties", "lab04_05.properties"})
public class JavaConfig {
	
	@Value("${lab06.car.speed}")
	Integer speed;
	
	@Value("${lab06.car.hour}")
	Double hour;
	
	@Bean
	public Car car1() {
		Car c = new Car();
		c.setSpeed(speed);
		c.setHour(hour);
		return c;
	}
}
