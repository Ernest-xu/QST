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

import Ernest.Dao.postinformationtabQuduanDaoI;
import Ernest.Entity.PostinformationtabQuduan;
import Ernest.Service.Imp.postinformationtabQuduanServiceimpl;

/**
 * @author Ernest
 *
 */
public class postinformationtabQuduanTest extends TestBase {

	private static final Logger logger = Logger.getLogger(postinformationtabQuduanTest.class);
	@Autowired
	private postinformationtabQuduanDaoI postinformationtabQuduanDao;
	@Autowired
	private postinformationtabQuduanServiceimpl postinformationtabQuduanService;
	
//	@Before
	public void init(){
		postinformationtabQuduanDao = super.getContext().getBean("postinformationtabQuduanDaoI",postinformationtabQuduanDaoI.class);
	}
	@Before
	public void init2(){
		postinformationtabQuduanService = super.getContext().getBean("postinformationtabQuduanServiceimpl",postinformationtabQuduanServiceimpl.class);
	}
	
//	@Test
	public void find(){
		String fid = "C82BF43AEBB0000123221B4159871D1F";
		List<PostinformationtabQuduan> list = postinformationtabQuduanDao.findListByfMsterID(fid);
		for(PostinformationtabQuduan postinformationtabQuduan:list){
			logger.info(postinformationtabQuduan.getFid());
		}
	}
	
	@Test
	public void find2(){
		String fid = "C82BF43AEBB0000123221B4159871D1F";
		JSONObject json = postinformationtabQuduanService.SelectZoneList(fid);
		logger.info(json.toString());
	}
	
	
}
