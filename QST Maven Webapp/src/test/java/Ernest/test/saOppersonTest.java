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

import Ernest.Dao.saOppersonDaoI;

/**
 * @author Ernest
 *
 */
public class saOppersonTest extends TestBase {
	private static final Logger logger = Logger.getLogger(saOppersonTest.class);
	@Autowired
	private saOppersonDaoI saOpersonDao;
	
//	@Before
	public void init(){
		saOpersonDao = super.getContext().getBean("saOppersonDaoI",saOppersonDaoI.class);
	}
	
//	@Test
	public void delete(){
//		List<String> list = new ArrayList<String>();
//		int a = saOpersonDao.deleteByIds(list);
//		logger.info(a);
	}
	
}
