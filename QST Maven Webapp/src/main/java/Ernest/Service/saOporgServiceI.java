/**
 * 
 */
package Ernest.Service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.SaOporg;

/**
 * @author Ernest
 *
 */
public interface saOporgServiceI {
	/**
	 * 找到管理员用户信息
	 * @param md5
	 * @param kind
	 * @return
	 */
	SaOporg findAdmin(String md5,String kind);
	/**
	 * 新增部门
	 * @param sFName
	 * @param sMd5Str
	 * @param sParentID
	 * @return
	 */
	JSONObject save(String sFName,String sMd5Str,String sParentID);
	/**
	 * 根据id修改
	 * @param json
	 * @return
	 */
	String updateSaOporgById(JSONObject json);
	/**
	 * 根据MD5
	 * 查找部门列表
	 * @param md5
	 * @return
	 */
	String findRoleList(String md5);
	/**
	 * 根据MD5查找所有部门
	 * @param md5
	 * @return
	 */
	Map<String ,Object> AllDepartment(String md5);
	/**
	 * 修改名称
	 * @param sFName
	 * @param sID
	 * @return
	 */
	JSONObject updateSaOporgById(String sFName,String sID);
	/**
	 * 根据父亲id删除子数据
	 * @param sParentID
	 * @return
	 */
	JSONObject deleteByParentId(String sParentID);
	/**
	 * 根据MD5找公司信息
	 * @param md5
	 * @return
	 */
	SaOporg findTopByMd5(String md5);
	/**
	 * 
	 * @param saOporg
	 * @return
	 */
	int save(SaOporg saOporg);
	/**
	 * 修改
	 * @param saOporg
	 * @return
	 */
	int update(SaOporg saOporg);
	/**
	 * 根据sparentid2查找
	 * @param sParentID2
	 * @return
	 */
	List<SaOporg> findBysParentID2(String sParentID2);
	/**
	 * 根据id列表查找
	 * @param list
	 * @return
	 */
	List<SaOporg> findByListId(List<String> list);
	/**
	 * 根据parentId2列表删除
	 * @param list
	 * @return
	 */
	int DeleteParentID2(List<String> list);
	/**
	 * 根据sid列表删除
	 * @param list
	 * @return
	 */
	int DeleteByListId(List<String> list);
	
	/**
	 * 根据类型获取部门、人员或公司
	 * @param md5
	 * @param kind
	 * @return
	 */
	List<SaOporg> getAllDepartment(String md5,String kind);
	
	
}
