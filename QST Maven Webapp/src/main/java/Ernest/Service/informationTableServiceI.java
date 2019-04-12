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
	 * 根据项目创建人查找项目
	 * @param writeId
	 * @return
	 */
	JSONObject findProjectGrid(String writeId);
	
	
	/**
	 * 查找项目信息
	 * @param fID
	 * @return
	 */
	List<InformationTable> findById(String fID);
	
	/**
	 * 查找项目详细信息
	 * @param fID
	 * @return
	 */
	JSONObject findProjectNote(String fID);
	
	/**
	 * 修改项目信息
	 * @param fID
	 * @param fPrjoectName
	 * @param fProjectQuanName
	 * @param fProjectAddress
	 * @param fProjectMessage
	 * @param fStateTime
	 * @param fEndTime
	 * @return
	 */
	JSONObject updateProjectDetail(String fID,String fPrjoectName,String fProjectQuanName,String fProjectAddress,String fProjectMessage,String fStateTime,String fEndTime);
}
