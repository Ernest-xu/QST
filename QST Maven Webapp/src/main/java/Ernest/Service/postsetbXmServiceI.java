/**
 * 
 */
package Ernest.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import Ernest.Entity.PostsetbXm;

/**
 * @author Ernest
 *
 */

public interface postsetbXmServiceI {
	/**
	 * 根据人员和项目id查找岗位
	 * @param ProjectId
	 * @param UserId
	 * @return
	 */
	List<PostsetbXm> findByProjectIdAndUser(String ProjectId,String UserId);
	
	/**
	 *根据项目id查找
	 * @param ProjectId
	 * @return
	 */
	Map<String,String> findByProjectId(String ProjectId);
	
	
	
}
