/**
 * 
 */
package Ernest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.informationTableServiceI;

/**
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/informationTableController")
public class informationTableController {

	@Autowired
	private informationTableServiceI informationTableService;
	
	@GetMapping("/SelectProjectList")
	public JSONObject SelectProjectList(String UserID){
		JSONObject json = informationTableService.findMainList(UserID);
		return json;
	}
	
	
}
