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
	 * @return
	 */
	int batchSave(List<PostsetbXm1> list);
	
}
