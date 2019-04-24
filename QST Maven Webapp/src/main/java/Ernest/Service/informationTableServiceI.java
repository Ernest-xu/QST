/**
 * 
 */
package Ernest.Service;

import java.text.ParseException;
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

	/**
	 * 修改项目信息
	 * @param informationTable
	 * @return
	 */
	int updateByMapId(InformationTable informationTable);
	
	/**
	 * 新增项目
	 * @param UserID 创建人id
	 * @param md5Str 创建人组织md5
	 * @param fProjectQuanName 项目全名
	 * @param fProjectMessage 项目简介
	 * @param fStateTime 开始时间
	 * @param fEndTime 结束时间
	 * @param fProjectAddress 施工地点
	 * @param fPrjoectName 项目目简称
	 * @return 返回成功与否信息
	 */
	JSONObject CreateProjectgx(String UserID,String UserName,String md5Str,String fProjectQuanName,String fProjectMessage,
			String fStateTime,String fEndTime,String fProjectAddress,String fPrjoectName)throws ParseException;
	
	/**
	 * 删除项目及项目下的信息
	 * @param fProjectID
	 * @return
	 */
	JSONObject delectProjectgx(String fProjectID);
	
}
