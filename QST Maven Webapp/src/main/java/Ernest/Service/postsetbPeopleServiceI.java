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
	
	/**
	 * 创建人员岗位返回影响条数
	 * @param fID
	 * @param BumchfID
	 * @param fProjectID
	 * @param fProjectCode
	 * @param fProjectName
	 * @param md5
	 * @param sMd5Str
	 * @return
	 */
	int getAddPeople(String fID ,String BumchfID,String fProjectID,String fProjectCode,String fProjectName,String md5,String sMd5Str);
	
	/**
	 * 岗位分配人员
	 * @param BumchfID1
	 * @param BumchfID2
	 * @param fID
	 * @param fProject
	 * @param Class
	 * @return
	 */
	JSONObject AddJobPeople(String BumchfID1,String BumchfID2,String fID,String fProjectID,String Class);
	
}
