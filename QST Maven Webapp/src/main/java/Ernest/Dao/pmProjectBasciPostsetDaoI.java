/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PmProjectBasciPostset;

/**
 * 标准岗位Dao
 * @author Ernest
 *
 */
@Repository
public interface pmProjectBasciPostsetDaoI {
	
	/**
	 * 查找所有的标准岗位
	 * @return 返回查到的所有的信息
	 */
	List<PmProjectBasciPostset> findAll();

}
