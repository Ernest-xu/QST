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
	
	
	@PostMapping("/insertZone")
	public JSONObject insertZone(String fProjectID ,String fPostName,String fPostNameState,String fPostNameEnd,String fSpanSum){
		JSONObject json = new JSONObject();
		json = postinformationtabQuduanService.insertZone(fProjectID, fPostName, fPostNameState, fPostNameEnd, fSpanSum);
		return json;
	}
	
	@PostMapping("/deleteZone")
	public JSONObject deleteZone(String fID,String fProjectID){
		JSONObject json = new JSONObject();
		json = postinformationtabQuduanService.deleteZone(fID, fProjectID);
		return json;
	}
	
	@PostMapping("/updateZone")
	public JSONObject updateZone(String fID,String fPostName,String fPostNameState ,String fPostNameEnd){
		JSONObject json = new JSONObject();
		json = postinformationtabQuduanService.updateZone(fID, fPostName, fPostNameState, fPostNameEnd);
		return json;
	}
	
}
