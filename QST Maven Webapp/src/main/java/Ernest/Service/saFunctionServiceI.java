/**
 * 
 */
package Ernest.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ernest
 *
 */
public interface saFunctionServiceI {
	
	JSONObject saveAllFunction(String roleId,String companyId);
	
	JSONObject deleteFunctionByRole(String id);
}
