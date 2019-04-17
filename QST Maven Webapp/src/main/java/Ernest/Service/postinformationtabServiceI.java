/**
 * 
 */
package Ernest.Service;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.Postinformationtab;

/**
 * @author Ernest
 *
 */
public interface postinformationtabServiceI {

	
	/**
	 * 根据list中区段id获取下面桩号
	 * @param list
	 * @return
	 */
	List<Postinformationtab> findListByListMasterIds(List<String> list);
	
	
	/**
	 * 根据id修改桩号信息
	 * @param fID
	 * @param fMsterID
	 * @param fProjectCode
	 * @param fPostName
	 * @param fCubeSum
	 * @param fTonnageSum
	 * @param fSpanSum
	 * @return
	 */
	JSONObject updateZhuang(String fID,String fMsterID,String fProjectCode,String fPostName ,Float fCubeSum,Float fTonnageSum ,Float fSpanSum);
	
	/**
	 * 根据实体类主键修改
	 * @param postinformationtab
	 * @return
	 */
	int UpdateById(Postinformationtab postinformationtab);
	
	/**
	 * 根据id统计数量
	 * @param ProjectId
	 * @return
	 */
	HashMap<String ,Object> findMapByProjectId(String ProjectId);
	
	
	/**
	 * 根据materid统计
	 * @param MasterId
	 * @return
	 */
	HashMap<String , Object> findMapByMasterId(String MasterId);
}
