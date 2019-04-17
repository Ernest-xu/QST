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
	 * @return
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
}
