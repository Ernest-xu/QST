/**
 * 
 */
package Ernest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.postsetbXmDaoI;
import Ernest.Entity.PostsetbXm;

/**
 * @author Ernest
 *
 */
public class postsetbXmTest extends TestBase {
	private static final Logger logger = Logger.getLogger(postsetbXmTest.class);
	@Autowired
	private postsetbXmDaoI postsetbXmDao;
	
	@Before
	public void init(){
		postsetbXmDao = super.getContext().getBean("postsetbXmDaoI",postsetbXmDaoI.class);
	}
	
	@Test
	public void selectbymd5(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("fMasterID", "C82BF43AEBB0000123221B4159871D1F");
		map.put("fWriteID", "3fd612fa7fc042869f8ec3e30a7117e9");
		List<PostsetbXm> list = postsetbXmDao.findList(map);
		for(PostsetbXm postsetbXm:list){
			logger.info(postsetbXm.toString());
		}
	}
//	@Test
	public void selectbymd52(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("fMasterID", "C82BF43AEBB0000123221B4159871D1F");
		map.put("fWriteID", "3fd612fa7fc042869f8ec3e30a7117e9");
		List<PostsetbXm> list = postsetbXmDao.findList2(map);
		for(PostsetbXm postsetbXm:list){
			logger.info(postsetbXm.toString());
		}
	}
//	@Test
	public void selectbymd53(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("fMasterID", "C82BF43AEBB0000123221B4159871D1F");
		map.put("fWriteID", "3fd612fa7fc042869f8ec3e30a7117e9");
		List<PostsetbXm> list = postsetbXmDao.findList2(map);
		for(PostsetbXm postsetbXm:list){
			logger.info(postsetbXm.toString());
		}
	}
//	@Test
	public void selectbymd54(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("fMasterID", "C82BF43AEBB0000123221B4159871D1F");
		map.put("fWriteID", "3fd612fa7fc042869f8ec3e30a7117e9");
		List<PostsetbXm> list = postsetbXmDao.findList2(map);
		for(PostsetbXm postsetbXm:list){
			logger.info(postsetbXm.toString());
		}
	}
	
}
