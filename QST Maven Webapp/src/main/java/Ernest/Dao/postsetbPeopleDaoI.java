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
	
	
	/**
	 * 查找人员根据项目id和md5
	 * @param fProjectID
	 * @param sMd5Str
	 * @return
	 */
	List<PostsetbPeople> findPersonByProjectAndmd5(String fProjectID ,String sMd5Str);
	
	
	List<PostsetbPeople> findById(String fID);
	
	/**
	 * 根据id列表删除
	 * @param list
	 * @return
	 */
	int deleteByIds(List<String> list);
	
	
	int batchSaves(List<PostsetbPeople> list);
	
	int save(PostsetbPeople postsetbPeople);
	
}
