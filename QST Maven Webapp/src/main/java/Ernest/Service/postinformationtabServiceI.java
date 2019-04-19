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
	
	
	/**
	 * 批量插入桩号
	 * @param list
	 * @return
	 */
	int batchSave(List<Postinformationtab> list);
	
	
	/**
	 * 插入桩号
	 * @param postinformationtab
	 * @return
	 */
	int saveById(Postinformationtab postinformationtab);
	
	/**
	 * 根据id删除桩
	 * @param fID 主键id
	 * @return
	 */
	int deleteById(String fID);
	
	/**
	 * 根据id列表删除桩
	 * @param list id列表
	 * @return
	 */
	int batchDelete(List<String> list);
	
	
	/**
	 * 新建桩号 
	 * 同时修改项目和区段的档距
	 * 同时创建图片关联表信息
	 * @param fMsterID 区段id
	 * @param fProjectCode 项目id
	 * @param fPostName 桩号名称
	 * @param fCubeSum 方量
	 * @param fTonnageSum 吨位
	 * @param fSpanSum 档距
	 * @return
	 */
	JSONObject insertZhuang(String fMsterID,String fProjectCode,String fPostName ,Float fCubeSum,Float fTonnageSum ,Float fSpanSum);
	
	
	/**
	 * 删除桩号
	 * 同时修改项目和区段的档距
	 * @param fID 桩号id
	 * @param fMsterID 区段id
	 * @param fProjectCode 项目id
	 * @return
	 */
	JSONObject deleteZhuang(String fID,String fMsterID,String fProjectCode );
	
}
