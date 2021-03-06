/**
 * 
 */
package Ernest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.postinformationtabServiceI;

/**
 * 桩
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/postinformationtabController")
public class postinformationtabController {

	@Autowired
	private postinformationtabServiceI postinformationtabService;
	
	
	@PostMapping("/updateZhuang")
	public JSONObject updateZhuang(String fID,String fMsterID,String fProjectCode,String fPostName ,Float fCubeSum,Float fTonnageSum ,Float fSpanSum){
		JSONObject json = new JSONObject();
		json = postinformationtabService.updateZhuang(fID, fMsterID, fProjectCode, fPostName, fCubeSum, fTonnageSum, fSpanSum);
		return json;
	}
	
	@PostMapping("/insertZhuang")
	public JSONObject insertZhuang(String fMsterID,String fProjectCode,String fPostName ,Float fCubeSum,Float fTonnageSum ,Float fSpanSum){
		JSONObject json = new JSONObject();
		json = postinformationtabService.insertZhuang(fMsterID, fProjectCode, fPostName, fCubeSum, fTonnageSum, fSpanSum);
		return json;
	}
	
	@PostMapping("/deleteZhuang")
	public JSONObject deleteZhuang(String fID,String fMsterID,String fProjectCode ){
		JSONObject json = new JSONObject();
		json = postinformationtabService.deleteZhuang(fID, fMsterID, fProjectCode);
		return json;
	}
	
	
}
