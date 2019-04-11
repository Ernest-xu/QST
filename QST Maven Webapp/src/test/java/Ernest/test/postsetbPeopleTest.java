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

import Ernest.Dao.postsetbPeopleDaoI;
import Ernest.Entity.PostsetbPeople;
import Ernest.Service.Imp.postsetbPeopleServiceimpl;

/**
 * @author Ernest
 *
 */
public class postsetbPeopleTest extends TestBase {
	private static final Logger logger = Logger.getLogger(postsetbPeopleTest.class);
	@Autowired
	private postsetbPeopleDaoI postsetbPeopleDao;
	
	@Autowired
	private postsetbPeopleServiceimpl postsetbPeopleService;
	
//	@Before
	public void init() {
		postsetbPeopleDao = super.getContext().getBean("postsetbPeopleDaoI",postsetbPeopleDaoI.class);
	}
//	@Before
	public void init1() {
		postsetbPeopleService = super.getContext().getBean("postsetbPeopleServiceimpl",postsetbPeopleServiceimpl.class);
	}
	
//	@Test
	public void delete() {
		String fID = "6a300c81-d6d4-4d8a-93a9-d6e00396e4be";
		JSONObject json = postsetbPeopleService.DeleteJobPeople(fID);
		logger.info(json.toString());
	}
//	@Test
	public void add() {
		String BumchfID1="66fb26ee-0e9a-40fb-bbe7-20bc06586623";
		String BumchfID2="";
		String fID="ae165db275d744a78aac0a633d48d692";
		String fProjectID="C82BF43AEBB0000123221B4159871D1F";
		String Class="班组";
		JSONObject json = postsetbPeopleService.AddJobPeople(BumchfID1, BumchfID2, fID, fProjectID, Class);
		logger.info(json.toString());
	}
	
//	@Test
	public void findlist(){//成功
		List<PostsetbPeople> list = postsetbPeopleDao.findPeopleListByProjectId("C82BF43AEBB0000123221B4159871D1F");
		for(PostsetbPeople pp : list){
			logger.info(pp.getFid());
		}
	}
//	@Test
	public void findlist1(){//
		List<PostsetbPeople> list = postsetbPeopleDao.findPersonByProjectAndmd5("C82BF43AEBB0000123221B4159871D1F", "a5456473bddfaa1db1f7bd3b29fc8c8a");
		for(PostsetbPeople pp : list){
			logger.info(pp.getSaOpperson().getSname());
		}
	}
}
