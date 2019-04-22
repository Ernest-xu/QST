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
	 * @return 返回list<实体类>
	 */
	List<PostinformationtabQuduan> findListByfMsterID(String fMsterID) ; 
	
	/**
	 * 区段修改
	 * @param PostinformationtabQuduan
	 * @return 返回影响数据条数
	 */
	int UpdateByfID(PostinformationtabQuduan postinformationtabQuduan);
	
	
	/**
	 * 新增区段
	 * @param PostinformationtabQuduan
	 * @return 返回影响数据条数
	 */
	int saveById(PostinformationtabQuduan postinformationtabQuduan);
	
	/**
	 * 获取区段的数量
	 * @param fMasterId
	 * @return 返回影响数据条数
	 */
	int findByfMasterId(String fMasterId);
	
	
	/**
	 * 根据区段id删除区段
	 * @param fID
	 * @return 返回影响数据条数
	 */
	int deleteById(String fID);
	
	
}
