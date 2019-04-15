/**
 * 
 */
package Ernest.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.postinformationtabQuduanDaoI;
import Ernest.Entity.PostinformationtabQuduan;

/**
 * @author Ernest
 *
 */
public class postinformationtabQuduanTest extends TestBase {

	private static final Logger logger = Logger.getLogger(postinformationtabQuduanTest.class);
	@Autowired
	private postinformationtabQuduanDaoI postinformationtabQuduanDao;
	
	
//	@Before
	public void init(){
		postinformationtabQuduanDao = super.getContext().getBean("postinformationtabQuduanDaoI",postinformationtabQuduanDaoI.class);
	}
	
//	@Test
	public void find(){
		String fid = "C82BF43AEBB0000123221B4159871D1F";
		List<PostinformationtabQuduan> list = postinformationtabQuduanDao.findListByfMsterID(fid);
		for(PostinformationtabQuduan postinformationtabQuduan:list){
			logger.info(postinformationtabQuduan.getFid());
		}
	}
	
}
