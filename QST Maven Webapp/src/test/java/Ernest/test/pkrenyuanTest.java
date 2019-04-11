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

import Ernest.Dao.pkrenyuanDaoI;
import Ernest.Entity.Pkrenyuan;
import Ernest.Service.pkrenyuanServiceI;

/**
 * @author Ernest
 *
 */
public class pkrenyuanTest extends TestBase {
	private static final Logger logger = Logger.getLogger(pkrenyuanTest.class);
	@Autowired
	private pkrenyuanServiceI pkrenyuanService;
	@Autowired
	private pkrenyuanDaoI pkrenyuanDao;
	
//	@Before
	public void init1(){
		pkrenyuanService = super.getContext().getBean("pkrenyuanServiceI",pkrenyuanServiceI.class);
	}
//	@Before
	public void init(){
		pkrenyuanDao = super.getContext().getBean("pkrenyuanDaoI",pkrenyuanDaoI.class);
	}
	
//	@Test
	public void insert(){
		Pkrenyuan pkrenyuan = new Pkrenyuan();
		pkrenyuan.setFid("aaa");
		int a = pkrenyuanDao.save(pkrenyuan);
		logger.info(a);
	}
	
//	@Test
	public void insert2(){
		List<Pkrenyuan> list = new ArrayList<Pkrenyuan>();
		Pkrenyuan pkrenyuan = new Pkrenyuan();
		pkrenyuan.setFid("aaa");
		pkrenyuan.setFmd5("aaa");
		pkrenyuan.setFprojectName("aaa");
		pkrenyuan.setFprojectCode("aaa");
		pkrenyuan.setFwriteName("aa");
		pkrenyuan.setFwriteCode("aaa");
		pkrenyuan.setFwriteId("aa");
		pkrenyuan.setFwriteTime(null);
		list.add(pkrenyuan);
		
		int a = pkrenyuanDao.batchSaves(list);
		logger.info(a);
	}
	
}
