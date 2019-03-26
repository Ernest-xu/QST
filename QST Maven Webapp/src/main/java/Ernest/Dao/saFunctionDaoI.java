/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.SaFunction;

/**
 * @author Ernest
 *
 */
@Repository
public interface saFunctionDaoI {

	
	void save(SaFunction saFunction);
	
	void updateById(SaFunction saFunction);
	
	void batchSaves(List<SaFunction> list);
	
	void deleteByRoleId(String id);
}
