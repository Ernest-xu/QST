/**
 * 
 */
package Ernest.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.postsetbPeopleServiceI;

/**
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/postsetbPeopleController")
public class postsetbPeopleController {
	private static final Logger logger = Logger.getLogger(postsetbPeopleController.class);
	
	@Autowired
	private postsetbPeopleServiceI postsetbPeopleService;
	
	
	@GetMapping("/SelectUserList")
	public JSONObject SelectUserList(String id){
		JSONObject json = new JSONObject();
		json = postsetbPeopleService.findPeopleListByProjectId(id);
		return json;
	}
	
	@GetMapping("/SelectPerson")
	public JSONObject SelectPerson(String fProjectID,String sMd5Str){
		JSONObject json = new JSONObject();
		json = postsetbPeopleService.SelectPerson(fProjectID, sMd5Str);
		logger.info(json.toString());
		return json;
	}
	
	@PostMapping("/DeleteJobPeople")
	public JSONObject DeleteJobPeople(String fID){
		JSONObject json = new JSONObject();
		
		return json;
	}
	
	@PostMapping("/AddJobPeople")
	public JSONObject AddJobPeople(String BumchfID1,String BumchfID2,String fID,String fProjectID,String Class){
		JSONObject json = new JSONObject();
		logger.info("BumchfID1:"+BumchfID1+",BumchfID2:"+BumchfID2+",fID:"+fID+",fProjectID:"+fProjectID+",Class:"+Class);
		json = postsetbPeopleService.AddJobPeople(BumchfID1, BumchfID2, fID, fProjectID, Class);
		return json;
	}
	
}
