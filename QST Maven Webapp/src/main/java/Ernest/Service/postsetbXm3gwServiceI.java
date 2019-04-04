/**
 * 
 */
package Ernest.Service;

import java.util.List;
import java.util.Map;

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
	
	/**
	 *根据项目id查找
	 * @param ProjectId
	 * @return
	 */
	Map<String,String> findByProjectId(String ProjectId);
	
}
