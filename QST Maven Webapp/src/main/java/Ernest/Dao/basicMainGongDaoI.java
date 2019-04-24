/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.BasicMainGong;

/**
 * @author Ernest
 *
 */
@Repository
public interface basicMainGongDaoI {

	
	List<BasicMainGong> findByfMasterId(String fMasterID);
	
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSaves(List<BasicMainGong> list);
	
	/**
	 * 根据项目id删除
	 * @param fMasterId 项目id
	 * @return
	 */
	int deleteByfMasterId(String fMasterId);
}
