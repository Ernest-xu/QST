/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.InformationTable;

/**
 * @author Ernest
 *
 */
public interface informationTableServiceI {
	/**
	 * 根据项目创建人查找项目
	 * @param writeId
	 * @return
	 */
	JSONObject findMainList(String writeId);
	
	
	/**
	 * 查找项目信息
	 * @param fID
	 * @return
	 */
	List<InformationTable> findById(String fID);
	
	
}
