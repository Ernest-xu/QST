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

	
	int save(SaFunction saFunction);
	
	int updateById(SaFunction saFunction);
	
	void batchSaves(List<SaFunction> list);
	
	int deleteByRoleId(String id);
	
	int deleteByRoleIds(List<String> list);
}
