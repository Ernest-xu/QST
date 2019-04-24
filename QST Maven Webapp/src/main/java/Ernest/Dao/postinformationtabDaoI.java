/**
 * 
 */
package Ernest.Dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.Postinformationtab;

/**
 * @author Ernest
 *
 */
@Repository
public interface postinformationtabDaoI {

	/**
	 * 根据list中区段id获取下面桩号
	 * @param list
	 * @return
	 */
	List<Postinformationtab> findListByListMasterIds(List<String> list);
	
	
	/**
	 * 根据实体类主键修改
	 * @param postinformationtab
	 * @return 返回影响数据条数
	 */
	int UpdateById(Postinformationtab postinformationtab);
	
	/**
	 * 根据项目id统计数量
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
	 * @return 返回影响数据条数
	 */
	int batchSave(List<Postinformationtab> list);
	
	
	/**
	 * 插入桩号
	 * @param postinformationtab
	 * @return 返回影响数据条数
	 */
	int saveById(Postinformationtab postinformationtab);
	
	/**
	 * 根据id删除桩
	 * @param fID 主键id
	 * @return 返回影响数据条数
	 */
	int deleteById(String fID);
	
	/**
	 * 根据id列表删除桩
	 * @param list id列表
	 * @return 返回影响数据条数
	 */
	int batchDelete(List<String> list);
	
	
	/**
	 * 根据区段id删除
	 * @param fMasterId 区段id
	 * @return 返回影响数据条数
	 */
	int deleteByfMasterId(String fMasterId);
	
	/**
	 * 根据项目id删除桩
	 * @param fProjectCode 项目id
	 * @return 返回影响数据条数
	 */
	int deleteByfProjectCode(String fProjectCode);
	
}
