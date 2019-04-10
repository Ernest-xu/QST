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
	
	/**
	 * 添加项目岗位
	 * @param Class
	 * @param fID
	 * @param UserID
	 * @param fPostName
	 * @return
	 */
	JSONObject insertProjectPost(String Class,String fID,String UserID ,String fPostName);
	
	/**
	 * 修改项目名称
	 * @param fID
	 * @param fPostName
	 * @return
	 */
	JSONObject updateProjectPost(String fID,String fPostName);
	
	
	/**
	 * 删除项目岗位
	 * @param fID
	 * @return
	 */
	JSONObject DeleteJobList(String fID);
}
