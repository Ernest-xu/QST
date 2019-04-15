/**
 * 
 */
package Ernest.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.postinformationtabDaoI;
import Ernest.Entity.Postinformationtab;

/**
 * @author Ernest
 *
 */
public class postinformationtabTest extends TestBase {

	private static final Logger logger = Logger.getLogger(postinformationtabTest.class);
	@Autowired
	private postinformationtabDaoI postinformationtabDao;
	
	
//	@Before
	public void init(){
		postinformationtabDao = super.getContext().getBean("postinformationtabDaoI",postinformationtabDaoI.class);
	}
	
//	@Test
	public void finf (){
		List<String> list1 = new ArrayList<String>();
		String fid1 = "C82BF44F7A700001887D171078D01361";
		String fid2 = "C837DECABAA000017EBA78F018E754B0";
		list1.add(fid1);
		list1.add(fid2);
		List<Postinformationtab> list = postinformationtabDao.findListByListMasterIds(list1);
		for(Postinformationtab postinformationtab :list){
			logger.info(postinformationtab.getFid()+","+postinformationtab.getFmsterId());
		}
	}
	
}
