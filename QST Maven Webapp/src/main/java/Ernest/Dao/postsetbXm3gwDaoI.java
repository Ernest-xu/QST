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
	
	//根据项目查找
	List<PostsetbXm3gw> findByProjectId(String ProjectId);
	
	//一条新增
	int save(PostsetbXm3gw postsetbXm3gw);
	
	//多条新增
	int batchSaves(List<PostsetbXm3gw> list);
	
	//一条修改
	int UpdateById(PostsetbXm3gw postsetbXm3gw);
	
	//删除多条
	int batchDelete(List<String> list);
	
	//查找所有子类id和fPostWriteID
	List<PostsetbXm3gw> findChildById(String fID);
	
	//根据id查找内容
	List<PostsetbXm3gw> findById(String fID);
	
	//以子类为主
	List<PostsetbXm3gw> findByChildId(String fID);
	
	/**
	 * 
	 * @param fPostxmid2
	 * @param fPostName
	 * @return
	 */
	List<PostsetbXm3gw> findfPostxmid2AndfPostName(String fPostxmid2,String fPostName);
	
	
}
