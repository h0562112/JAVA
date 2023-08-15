package lab07.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("lab07.properties")
public class JavaConfig {
	@Value("${lab07.circle.radius}")
	Double radius;
	
	@Bean
	public Circle circle() {
		Circle c = new Circle();
		c.setRadius(radius);
		return c;
	}
	
	
}
