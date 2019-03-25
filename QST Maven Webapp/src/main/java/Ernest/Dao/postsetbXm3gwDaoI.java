/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PostsetbXm3gw;


/**
 * @author Ernest
 *
 */
@Repository
public interface postsetbXm3gwDaoI {

	
	List<PostsetbXm3gw> findByProjectIdAndUser(String ProjectId, String UserId);
}
