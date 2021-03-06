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

import Ernest.Service.saFunctionServiceI;

/**
 * @author Ernest
 *
 */
@RestController
@RequestMapping("/saFunctionController")
public class saFunctionController {
	private static final Logger logger = Logger.getLogger(saFunctionController.class);
	@Autowired
	private saFunctionServiceI saFunctionService;
	
	@PostMapping("/allFunction")
	public JSONObject allFunction(String roleId,String companyId){
		JSONObject json = saFunctionService.saveAllFunction(roleId, companyId);
		return json;
	}

	@GetMapping("/SelectFunctionTier")
	public JSONObject SelectFunctionTier(String sID,String sMainOrgID){
		JSONObject json = new JSONObject();
		json = saFunctionService.SelectFunctionTier(sID, sMainOrgID);
		return json ;
	}
	
	
	@PostMapping("/UpdateFunction")
	public JSONObject UpdateFunction(String sID,int isShow){
		JSONObject json = new JSONObject();
		json = saFunctionService.UpdateFunction(sID, isShow);
		return json ;
	}
}
