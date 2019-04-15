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
}
