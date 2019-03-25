/**
 * 
 */
package Ernest.test;


import org.apache.log4j.PropertyConfigurator;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ernest
 *
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {
	 
	static {
		PropertyConfigurator.configure("src/main/resources/conf/log4j.properties");
	}
	
	public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}
 

}
