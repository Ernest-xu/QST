/**
 * 
 */
package Ernest.Service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.SaFunction;

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
	
	/**
	 * 
	 * @param id
	 * @param sMainOrgID
	 */
	JSONObject SelectFunctionTier(String id,String sMainOrgID);

	
	/**
	 * 根据roleId和company获取
	 * @param map roleId and companyId
	 * @return
	 */
	List<SaFunction> findByroleandcompany(Map<String,Object> map);
	
}
