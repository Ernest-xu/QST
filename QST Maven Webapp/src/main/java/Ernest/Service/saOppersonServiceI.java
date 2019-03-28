/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.SaOpperson;

/**
 * @author Ernest
 *
 */
public interface saOppersonServiceI {
	
	JSONObject LoginBy(String name,String password);
	
	void save(SaOpperson saOpperson);
	
	JSONObject findPerson(String id,String md5Str);
	
	JSONObject likeFind(String id,String md5Str,String name);
	
	JSONObject deleteUserAndOrder(List<String> list);
	
	int deleteByIds(List<String> list);
	
	JSONObject CreatePerson(String realName,String account,String sex,String password,String md5Str ,String roleIds,String orgId);
	
	JSONObject UpdatePerson(String fID,String realName,String account,String sex,String password,String md5Str ,String roleIds,String orgId);
	
	JSONObject DeletePerson(String fIDs);
}
