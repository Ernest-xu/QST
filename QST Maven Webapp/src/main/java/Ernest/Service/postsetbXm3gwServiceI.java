/**
 * 
 */
package Ernest.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ernest
 *
 */
public interface postsetbXm3gwServiceI {
	/**
	 * 根据人员和项目id查找岗位
	 * @param ProjectId
	 * @param UserId
	 * @return
	 */
	JSONObject findByProjectIdAndUser(String ProjectId,String UserId);
	
}
