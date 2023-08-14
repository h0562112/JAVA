package lab05.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab05.solution.Circle;


public class CircleMain {
    public static void main(String args[]) {
//       	ICircle c = new Circle();
//       	c.setRadius(10);
//       	System.out.println("半徑為" + c.getRadius() + "之圓的面積為: " + c.getArea());
    	ApplicationContext ctx = 
    			new ClassPathXmlApplicationContext("lab05/anno/Beans.xml");
       	ICircle c = ctx.getBean(ICircle.class);
       	System.out.println("半徑為" + c.getRadius() + "之圓的面積為: " + c.getArea());
       	((ConfigurableApplicationContext)ctx).close();
 
    
    }
}
