/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PostsetbPeople;

/**
 * @author Ernest
 *
 */
@Repository
public interface postsetbPeopleDaoI {

	/**
	 * 根据项目id查找下面的人员信息
	 * @param ProjectId
	 * @return
	 */
	List<PostsetbPeople> findPeopleListByProjectId(String ProjectId);
	
}
