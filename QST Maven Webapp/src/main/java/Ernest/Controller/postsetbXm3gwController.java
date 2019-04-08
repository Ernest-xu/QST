/**
 * 
 */
package Ernest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.postsetbXm3gwServiceI;

/**
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/postsetbXm3gwController")
public class postsetbXm3gwController {

	@Autowired
	private postsetbXm3gwServiceI postsetbXm3gwService;
	
	@GetMapping("/SelectJobList")
	public JSONObject SelectJobList(String id,String UserID){
		JSONObject json = new JSONObject();
		json = postsetbXm3gwService.findByProjectIdAndUser(id, UserID);
		return json;
	}
	
	@PostMapping("/UpdateJobList")
	public JSONObject UpdateJobList(String fID,String fPostName){
		
		JSONObject json = new JSONObject();
		return json;
	}
	
	@PostMapping("/AddJobList")
	public JSONObject AddJobList(String Class,String fID,String UserID,String fPostName){
		
		JSONObject json = new JSONObject();
		return json;
	}
}
