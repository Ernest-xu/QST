/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.PostinformationtabQuduan;

/**
 * @author Ernest
 *
 */
public interface postinformationtabQuduanServiceI {

	
	/**
	 * 根据外键查找区段
	 * @param fMsterID 外键（项目id）
	 * @return
	 */
	List<PostinformationtabQuduan> findListByfMsterID(String fMsterID) ; 
	
	/**
	 * 查找区段和桩的列表
	 * @param fProjectID
	 * @return
	 */
	JSONObject SelectZoneList(String fProjectID);
	
}
