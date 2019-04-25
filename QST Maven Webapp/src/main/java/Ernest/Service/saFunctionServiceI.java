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
	/**
	 * 根据传过来的角色id和公司id创建功能
	 * @param roleId
	 * @param companyId
	 * @return
	 */
	JSONObject saveAllFunction(String roleId,String companyId);
	/**
	 * 根据角色id删除对应的功能
	 * @param id
	 * @return
	 */
	JSONObject deleteFunctionByRole(String id);
	
	

}
