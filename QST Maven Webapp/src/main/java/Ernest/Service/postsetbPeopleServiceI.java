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
	
	/**
	 * 查找人员
	 * @return
	 */
	JSONObject SelectPerson(String fProjectID ,String sMd5Str);
	
	/**
	 * 删除分配的项目岗位
	 * @param fID
	 * @return
	 */
	JSONObject DeleteJobPeople(String fID);
}
