package lab06.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab05.anno.ICircle;



public class CarMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
			ctx.scan("lab05.anno");
		
			ICar car1 = ctx.getBean(ICar.class);
			car1.getComment();
			
			ICircle c = ctx.getBean(ICircle.class);
			System.out.println("半徑為" + c.getRadius() + "之圓的面積為: " + c.getArea());
			
			
			ctx.close();
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("lab06/Beans.xml");
//		ICar car1 = ctx.getBean(ICar.class);
//		car1.getComment();
//		((ConfigurableApplicationContext)ctx).close();
	}
}