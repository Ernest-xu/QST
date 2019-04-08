/**
 * 
 */
package Ernest.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import Ernest.Entity.PostsetbXm;

/**
 * @author Ernest
 *
 */
@Repository
public interface postsetbXmDaoI {

	
	List<PostsetbXm> findList (@Param("params") Map<String , Object> map);
	
	List<PostsetbXm> findList2 ( Map<String , Object> map);
	
	List<PostsetbXm> findList3 ( Map<String , Object> map);
	
	List<PostsetbXm> findList4 ( Map<String , Object> map);
	
}
