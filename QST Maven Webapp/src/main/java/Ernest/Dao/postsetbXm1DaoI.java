/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PostsetbXm1;

/**
 * @author Ernest
 *
 *
 */
@Repository
public interface postsetbXm1DaoI {
	
	/**
	 * 批量插入
	 * @param list
	 * @return 返回影响数据条数
	 */
	int batchSave(List<PostsetbXm1> list);
	
	/**
	 * 根据项目id删除
	 * @param fProjectId 项目id
	 * @return 返回影响数据条数
	 */
	int deleteByfProjectId(String fProjectId);
	
	
}
