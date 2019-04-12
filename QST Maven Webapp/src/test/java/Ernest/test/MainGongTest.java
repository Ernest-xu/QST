/**
 * 
 */
package Ernest.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.basicMainGongDaoI;
import Ernest.Entity.BasicMainGong;
import Ernest.Service.Imp.basicMainGongServiceimpl;

/**
 * @author Ernest
 *
 */
public class MainGongTest extends TestBase {
	private static final Logger logger = Logger.getLogger(MainGongTest.class);
	@Autowired
	private basicMainGongServiceimpl basicMainGongService;
	@Autowired
	private basicMainGongDaoI basicMainGongDao;
//	@Before
	public void init (){
		basicMainGongService = super.getContext().getBean("basicMainGongServiceimpl",basicMainGongServiceimpl.class);
	}
//	@Before
//	public void init1 (){
//		basicMainGongDao = super.getContext().getBean("basicMainGongDaoI",basicMainGongDaoI.class);
//	}
	
//	@Test
//	public void select(){
//		String fMasterID = "C82BF43AEBB0000123221B4159871D1F";
//		List<BasicMainGong> list = basicMainGongDao.findByfMasterId(fMasterID);
//		for(BasicMainGong BasicMainGong :list){
//			logger.info(BasicMainGong.toString());
//		}
//	}
//	@Test
	public void select2(){
		String fMasterID = "C82BF43AEBB0000123221B4159871D1F";
		JSONObject  json = basicMainGongService.SelectProcess(fMasterID);
		logger.info(json.toString());		
	}
	
	
}
