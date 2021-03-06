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
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSaves(List<BasicMainGong> list);
	
	/**
	 * 根据项目id删除
	 * @param fMasterId 项目id
	 * @return
	 */
	int deleteByfMasterId(String fMasterId);
}
