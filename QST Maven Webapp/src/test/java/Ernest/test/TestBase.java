package Ernest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class TestBase {
	public ApplicationContext getContext(){
		String[] conf={
				"conf/applicationContext.xml",
				"conf/spring-servlet.xml"};
		ApplicationContext ac
			= new ClassPathXmlApplicationContext(conf);
		return ac;
	}
}





