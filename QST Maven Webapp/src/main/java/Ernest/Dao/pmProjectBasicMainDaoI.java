/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PmProjectBasicMain;

/**
 * 基础配置主表Dao
 * @author Ernest
 *
 */
@Repository
public interface pmProjectBasicMainDaoI {

	/**
	 * 查找所有的基础配置主表信息
	 * @return 
	 */
	List<PmProjectBasicMain> findAll();
}
