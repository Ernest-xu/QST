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
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	JSONObject LoginBy(String name,String password);
	/**
	 * 新增人员
	 * @param saOpperson
	 */
	void save(SaOpperson saOpperson);
	/**
	 * 查找人员
	 * @param id
	 * @param md5Str
	 * @return
	 */
	JSONObject findPerson(String id,String md5Str);
	/**
	 * 模糊查询查找人员
	 * @param id
	 * @param md5Str
	 * @param name
	 * @return
	 */
	JSONObject likeFind(String id,String md5Str,String name);
	
	/**
	 * 删除人员根据id列表
	 * @param list
	 * @return
	 */
	int deleteByIds(List<String> list);
	/**
	 * 创建人员
	 * @param realName
	 * @param account
	 * @param sex
	 * @param password
	 * @param md5Str
	 * @param roleIds
	 * @param orgId
	 * @return
	 */
	JSONObject CreatePerson(String realName,String account,String sex,String password,String md5Str ,String roleIds,String orgId);
	/**
	 * 修改人员
	 * @param fID
	 * @param realName
	 * @param account
	 * @param sex
	 * @param password
	 * @param md5Str
	 * @param roleIds
	 * @param orgId
	 * @return
	 */
	JSONObject UpdatePerson(String fID,String realName,String account,String sex,String password,String md5Str ,String roleIds,String orgId);
	/**
	 * 根据id串删除
	 * @param fIDs
	 * @return
	 */
	JSONObject DeletePerson(String fIDs);
}
