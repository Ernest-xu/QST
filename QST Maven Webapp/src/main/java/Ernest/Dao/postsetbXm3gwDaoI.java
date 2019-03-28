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

	//根据项目id和人员id查找出相关的项目
	List<PostsetbXm3gw> findByProjectIdAndUser(String ProjectId, String UserId);
}
