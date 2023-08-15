package lab05.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("cilly")
@PropertySource("/lab04_05.properties")
public class Circle implements ICircle {
	
//	@Autowired
//	@Qualifier("side")
	@Value("${lab05.radius}")
	public double radius;

	public Circle() {
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}