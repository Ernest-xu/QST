/**
 * 
 */
package Ernest.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PmFolderclass;

/**
 * 文档管理Dao
 * @author Ernest
 *
 */
@Repository
public interface pmFolderclassDaoI {

	/**
	 * 查找所有的文档列表
	 * @return
	 */
	List<PmFolderclass> findAll();
	
	/**
	 * 获取项目数量
	 * @param ProjectId
	 * @return
	 */
	List<HashMap<String,Object>> findByProjectId(String ProjectId);
	
}
