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

import Ernest.Dao.basicMainGongDaoI;
import Ernest.Entity.BasicMainGong;

/**
 * @author Ernest
 *
 */
public class BasicMainGongTest extends TestBase {

	private static final Logger logger = Logger.getLogger(BasicMainGongTest.class);
	@Autowired
	private basicMainGongDaoI basicMainGongDao;
	
//	@Before
	public void init(){
		basicMainGongDao = super.getContext().getBean("basicMainGongDaoI",basicMainGongDaoI.class);
	}
	
//	@Test
	public void find(){
		List<BasicMainGong> list = new ArrayList<BasicMainGong>();
		BasicMainGong basicMainGong = new BasicMainGong();
		basicMainGong.setFid("112");
		basicMainGong.setFmasterId("112");			
		basicMainGong.setFprojectName("112");
		basicMainGong.setFprojectCode("112");
		basicMainGong.setFgxfId("112");
		basicMainGong.setFbz("112");
		basicMainGong.setFbasicType("112");
		basicMainGong.setFbasicCode("112");
		list.add(basicMainGong);
		int a = basicMainGongDao.batchSaves(list);
		logger.info(a);
	}
	
}
