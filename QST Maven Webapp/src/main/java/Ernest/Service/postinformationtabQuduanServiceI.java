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
	
	
	/**
	 * 区段修改
	 * @param PostinformationtabQuduan
	 * @return
	 */
	int UpdateByfID(PostinformationtabQuduan postinformationtabQuduan);
	
	
	/**
	 * 新增区段
	 * @param fProjectID 项目id
	 * @param fPostName 区段名称
	 * @param fPostNameState 区段开始
	 * @param fPostNameEnd 区段结束
	 * @param fSpanSum 档距
	 * @return
	 */
	JSONObject insertZone(String fProjectID ,String fPostName,String fPostNameState,String fPostNameEnd,String fSpanSum);
	
	
	/**
	 * 传入的区段实体类新建区段
	 * @param PostinformationtabQuduan
	 * @return
	 */
	int saveById(PostinformationtabQuduan postinformationtabQuduan);
	
	
	/**
	 * 删除区段
	 * 删除区段下的桩号
	 * 修改项目档距
	 * @param fID
	 * @param fProjectID
	 * @return
	 */
	JSONObject deleteZone(String fID,String fProjectID);
	
	
	
	/**
	 * 根据区段id删除区段
	 * @param fID
	 * @return 返回影响数据条数
	 */
	int deleteById(String fID);
	
	/**
	 * 修改区段
	 * @param fID  区段id
	 * @param fPostName 区段名称
	 * @param fPostNameState 开始桩
	 * @param fPostNameEnd	结束桩
	 * @return
	 */
	JSONObject updateZone(String fID,String fPostName,String fPostNameState ,String fPostNameEnd);
	
	
	/**
	 * 根据项目id删除
	 * @param fMsterId 项目id
	 * @return 返回影响数据条数
	 */
	int deleteByfMsterId(String fMsterId);
	
}
