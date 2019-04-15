/**
 * 
 */
package Ernest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.postinformationtabQuduanServiceI;

/**
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/postinformationtabQuduanController")
public class postinformationtabQuduanController {
	
	@Autowired
	private postinformationtabQuduanServiceI postinformationtabQuduanService;
	
	@GetMapping("/SelectZoneList")
	public JSONObject SelectZoneList(String fProjectID){
		JSONObject json = new JSONObject();
		json = postinformationtabQuduanService.SelectZoneList(fProjectID);
		return json;
	}
	
	
	
}
