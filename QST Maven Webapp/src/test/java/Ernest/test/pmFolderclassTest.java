/**
 * 
 */
package Ernest.test;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import Ernest.Dao.pmFolderclassDaoI;

/**
 * @author Ernest
 *
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/applicationContext.xml", "classpath:conf/spring-servlet.xml" })
public class pmFolderclassTest {
	private static final Logger logger = Logger.getLogger(pmFolderclassTest.class);
	@Autowired
	private pmFolderclassDaoI pmFolderclassDao;
	
//	@Test
	public void findnum(){
		String  ProjectId= "C82BF43AEBB0000123221B4159871D1F";
		List<HashMap<String,Object>> list = pmFolderclassDao.findByProjectId(ProjectId);
		logger.info(list.isEmpty());
		for(HashMap map:list){
			logger.info(map.get("sid"));
		}
	}
	
	
}
