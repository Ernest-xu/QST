/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PostinformationtabQuduan;

/**
 * @author Ernest
 *
 */
@Repository
public interface postinformationtabQuduanDaoI {

	/**
	 * 根据外键查找区段
	 * @param fMsterID 外键（项目id）
	 * @return
	 */
	List<PostinformationtabQuduan> findListByfMsterID(String fMsterID) ; 
	
	/**
	 * 区段修改
	 * @param PostinformationtabQuduan
	 * @return
	 */
	int UpdateByfID(PostinformationtabQuduan postinformationtabQuduan);
	
	
	/**
	 * 新增区段
	 * @param PostinformationtabQuduan
	 * @return
	 */
	int saveById(PostinformationtabQuduan postinformationtabQuduan);
	
	/**
	 * 获取区段的数量
	 * @param fMasterId
	 * @return
	 */
	int findByfMasterId(String fMasterId);
	
	
}
