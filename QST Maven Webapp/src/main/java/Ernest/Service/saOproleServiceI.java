/**
 * 
 */
package Ernest.Service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.saOprole;

/**
 * @author Ernest
 *
 */
public interface saOproleServiceI {
	JSONObject listSaOprole(String md5);
	
	JSONObject selectSaOproleList(String md5);
	
	saOprole selectSaOprole(String id);
	
	void addSaOprole(saOprole saOprole);
	
	JSONObject updateById(String sID,String sName);
	
	List<Map<String, Object>> selectJobName(String id);
	
	JSONObject CreateRoleAndFunction(String fRoleName,String companyId,String md5Str);
	
	JSONObject DeleteRole(String id);
	
}
