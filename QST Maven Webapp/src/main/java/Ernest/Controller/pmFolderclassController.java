/**
 * 
 */
package Ernest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * 图片
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/pmFolderclassController")
public class pmFolderclassController {

	
	@GetMapping("/getPhotoOrg")
	public JSONObject getPhotoOrg(String projectId){
		JSONObject json = new JSONObject();
		
		return json;
	}
}
