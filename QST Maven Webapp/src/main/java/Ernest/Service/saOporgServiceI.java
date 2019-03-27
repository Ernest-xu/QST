/**
 * 
 */
package Ernest.Service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.SaOporg;

/**
 * @author Ernest
 *
 */
public interface saOporgServiceI {
	
	SaOporg findAdmin(String md5,String kind);
	
	JSONObject save(String sFName,String sMd5Str,String sParentID);
	
	String updateSaOporgById(JSONObject json);
	
	String findRoleList(String md5);
	
	Map<String ,Object> AllDepartment(String md5);
	
	JSONObject updateSaOporgById(String sFName,String sID);
	
	JSONObject deleteByParentId(String sParentID);
	
	SaOporg findTopByMd5(String md5);
	
	int save(SaOporg saOporg);
}
