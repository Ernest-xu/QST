/**
 * 
 */
package Ernest.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.postsetbPeopleDaoI;
import Ernest.Entity.PostsetbPeople;

/**
 * @author Ernest
 *
 */
public class postsetbPeopleTest extends TestBase {
	private static final Logger logger = Logger.getLogger(postsetbPeopleTest.class);
	@Autowired
	private postsetbPeopleDaoI postsetbPeopleDao;
//	@Before
	public void init() {
		postsetbPeopleDao = super.getContext().getBean("postsetbPeopleDaoI",postsetbPeopleDaoI.class);
	}
	
//	@Test
	public void findlist(){//成功
		List<PostsetbPeople> list = postsetbPeopleDao.findPeopleListByProjectId("C82BF43AEBB0000123221B4159871D1F");
		for(PostsetbPeople pp : list){
			logger.info(pp.getFid());
		}
	}
}
