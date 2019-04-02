/**
 * 
 */
package Ernest.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.informationTableDaoI;
import Ernest.Entity.InformationTable;

/**
 * @author Ernest
 *
 */
public class informationTest extends TestBase {
	private static final Logger logger = Logger.getLogger(informationTest.class);
	@Autowired
	private informationTableDaoI informationTableDao;
	
	@Before
	public void init(){
		informationTableDao = super.getContext().getBean("informationTableDaoI",informationTableDaoI.class);
	}
	
//	@Test
	public void select(){
		List<InformationTable> list = informationTableDao.findList("3fd612fa7fc042869f8ec3e30a7117e9");
		for(InformationTable information:list){
			logger.info(information.toString());
		}
	}
	
	
	
}
