/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ernest
 *
 */
public interface saOppersonOproleServiceI {
	
	String addSaOpersonOprole(JSONObject json);

	String updateSaOpersonOprole(JSONObject json);
	
	String DeleteSaOpersonOprole(String id);
	
	String findSaOpersonOprole(String id);
	
	JSONObject deletByUserId(String id);
	
	int deleteByUserIds(List<String> list);
}
