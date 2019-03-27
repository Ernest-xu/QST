/**
 * 
 */
package Ernest.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import Ernest.Dao.saOporgDaoI;
import Ernest.Entity.SaOporg;

/**
 * @author Ernest
 *
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/applicationContext.xml", "classpath:conf/spring-servlet.xml" })
public class saOporgTest {

	private static final Logger logger = Logger.getLogger(saOporgTest.class);
	@Autowired
	private saOporgDaoI saOporgDao;
	
	@Test
	public void selectBy(){
//		SaOporg saOporg = saOporgDao.findDetail("1106");
//		List<SaOporg> list= saOporgDao.findSubclass("18");
//		for(SaOporg saOporg:list){
//			logger.info(saOporg.toString());
//		}
//			logger.info(saOporg.toString());
//		List<String> list = new ArrayList<String>();
//		list.add("1106");
//		list.add("1107");
//		list.add("1110");
//		int a =saOporgDao.deleteByIds(list);
//		logger.info(a);
	}
	
	
}
