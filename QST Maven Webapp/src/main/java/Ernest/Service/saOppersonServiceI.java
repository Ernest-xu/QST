/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.SaOpperson;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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
	/**
	 * 根据md5和部门id导出excel表格
	 * @param md5
	 * @param id
	 * @return
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	JSONObject ExportExcel(String id,String md5Str);
	/**
	 * 读取excel传入的json创建人员
	 * @param excel
	 * @param md5Str
	 * @return
	 */
	JSONObject ToLeadExcel(String excel,String md5Str);
	/**
	 * 返回说明表路径
	 * @param md5
	 * @return
	 */
	String Instruction(String md5);
	
	/**
	 * 根据id查找内容
	 * @param id
	 * @return
	 */
	List<SaOpperson> findListById(String id);
}
