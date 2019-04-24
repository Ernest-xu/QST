/**
 * 
 */
package Ernest.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ernest.Service.basicMainGongServiceI;

/**
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/basicMainGongController")
public class basicMainGongController {
	private static final Logger logger = Logger.getLogger(basicMainGongController.class);
	@Autowired
	private basicMainGongServiceI basicMainGongService; 
	
	@GetMapping("/SelectProcess")
	public JSONObject SelectProcess(String fProjectID){
		JSONObject json = new JSONObject();
		json = basicMainGongService.SelectProcess(fProjectID);
//		logger.info(json.toString());
		return json;
	}
	
}
