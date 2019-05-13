/**
 * 
 */
package Ernest.Controller;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.informationTableServiceI;

/**
 * 项目
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/informationTableController")
public class informationTableController {
	private static final Logger logger = Logger.getLogger(informationTableController.class);
	@Autowired
	private informationTableServiceI informationTableService;
	
	@GetMapping("/SelectProjectList")
	public JSONObject SelectProjectList(String UserID){
		JSONObject json = informationTableService.findMainList(UserID);
		return json;
	}
	
	
	@GetMapping("/SelectProjectGrid")
	public JSONObject SelectProjectGrid(String UserID){
		JSONObject json = new JSONObject();
		json = informationTableService.findProjectGrid(UserID);
		return json;
	}
	
	@GetMapping("/ProjectDetail")
	public JSONObject ProjectDetail(String fProjectID){
		JSONObject json = new JSONObject();
		json = informationTableService.findProjectNote(fProjectID);
		return json;
	}
	
	@PostMapping("/updateProjectDetail")
	public JSONObject updateProjectDetail(String fID,String fPrjoectName,String fProjectQuanName,String fProjectAddress,String fProjectMessage,String fStateTime,String fEndTime){
		JSONObject json = new JSONObject();
		json = informationTableService.updateProjectDetail(fID, fPrjoectName, fProjectQuanName, fProjectAddress, fProjectMessage, fStateTime, fEndTime);
		return json;
	}
	
	@PostMapping("/CreateProjectgx")
	public JSONObject CreateProjectgx(String UserID,String UserName,String md5Str,String fProjectQuanName,String fProjectMessage,
			String fStateTime,String fEndTime,String fProjectAddress,String fPrjoectName){
		JSONObject json = new JSONObject();
		logger.info("UserID:"+UserID+",UserName:"+UserName+",md5Str:"+md5Str+",fProjectQuanName:"+fProjectQuanName+",fProjectMessage:"+fProjectMessage+",fStateTime:"+fStateTime+",fEndTime:"+fEndTime+",fProjectAddress:"+fProjectAddress+",fPrjoectName:"+fPrjoectName);
		try {
			json =informationTableService.CreateProjectgx(UserID,UserName, md5Str, fProjectQuanName, fProjectMessage, fStateTime, fEndTime, fProjectAddress, fPrjoectName);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}
	

	@PostMapping("/delectProjectgx")
	public JSONObject delectProjectgx(String fProjectID){
		JSONObject json = new JSONObject();
		json =informationTableService.delectProjectgx(fProjectID);
		return json;
	}
	
}
