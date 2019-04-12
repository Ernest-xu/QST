/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.BasicMainGong;

/**
 * @author Ernest
 *
 */
public interface basicMainGongServiceI {
	
	/**
	 * 根据外键查找
	 * @param fMasterID
	 * @return
	 */
	List<BasicMainGong> findByfMasterId(String fMasterID);
	
	
	JSONObject SelectProcess(String fProjectID);
	
}
