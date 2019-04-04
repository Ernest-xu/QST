/**
 * 
 */
package Ernest.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ernest
 *
 */
public interface postsetbPeopleServiceI {
	
	/**
	 * 根据项目ID查找人员信息
	 * @param ProjectId
	 * @return
	 */
	JSONObject findPeopleListByProjectId(String ProjectId);
}
