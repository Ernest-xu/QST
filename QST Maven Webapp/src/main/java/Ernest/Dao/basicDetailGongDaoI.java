/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.BasicDetailGong;

/**
 * 
 * @author Ernest
 *
 */
@Repository
public interface basicDetailGongDaoI {

	/**
	 * 
	 * @param fMasterID
	 * @param fBz
	 * @return
	 */
	List<BasicDetailGong> findbyfMasterIdAndfBz(String fMasterID,String fBz);
	
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSaves(List<BasicDetailGong> list);
	
	/**
	 * 根据项目id删除
	 * @param fMasterId 项目id
	 * @return
	 */
	int deleteByfMasterId(String fMasterId);
}
