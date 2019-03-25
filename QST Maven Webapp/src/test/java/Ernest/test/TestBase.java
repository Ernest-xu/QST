package Ernest.test;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class TestBase {
	public ApplicationContext getContext(){
		PropertyConfigurator.configure("src/main/resources/conf/log4j.properties");
		String[] conf={
				"conf/applicationContext.xml",
				"conf/spring-servlet.xml"};
		ApplicationContext ac
			= new ClassPathXmlApplicationContext(conf);
		return ac;
	}
}





