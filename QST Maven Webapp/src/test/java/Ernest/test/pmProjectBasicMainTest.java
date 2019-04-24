/**
 * 
 */
package Ernest.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.pmProjectBasicMainDaoI;
import Ernest.Entity.PmProjectBasicMain;
import Ernest.Service.Imp.pmProjectBasicMainServiceimpl;

/**
 * @author Ernest
 *
 */
public class pmProjectBasicMainTest extends TestBase {
	private static final Logger logger = Logger.getLogger(pmProjectBasicMainTest.class);
	@Autowired
	private pmProjectBasicMainDaoI pmProjectBasicMainDao;
	@Autowired
	private  pmProjectBasicMainServiceimpl pmProjectBasicMainService;
//	@Before
	public void init(){
		pmProjectBasicMainDao = super.getContext().getBean("pmProjectBasicMainDaoI",pmProjectBasicMainDaoI.class);
	}
//	@Before
	public void init2(){
		pmProjectBasicMainService = super.getContext().getBean("pmProjectBasicMainServiceimpl",pmProjectBasicMainServiceimpl.class);
	}
//	@Test
	public void select(){
		List<PmProjectBasicMain> list = pmProjectBasicMainDao.findAll();
		for(PmProjectBasicMain pmProjectBasicMain :list){
			logger.info(pmProjectBasicMain.toString());
		}
	}
//	@Test
	public void select2(){
		List<PmProjectBasicMain> list = pmProjectBasicMainService.findAll();
		for(PmProjectBasicMain pmProjectBasicMain :list){
			logger.info(pmProjectBasicMain.toString());
		}
	}
}
