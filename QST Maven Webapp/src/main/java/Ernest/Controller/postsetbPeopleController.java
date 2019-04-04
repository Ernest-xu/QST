/**
 * 
 */
package Ernest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	@Autowired
	private postsetbPeopleServiceI postsetbPeopleService;
	
	
	@GetMapping("/SelectUserList")
	public JSONObject SelectUserList(String id){
		JSONObject json = new JSONObject();
		json = postsetbPeopleService.findPeopleListByProjectId(id);
		return json;
	}
	
}
