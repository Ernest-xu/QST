/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.PostsetbXm1;

/**
 * @author Ernest
 *
 */
public interface postsetbXm1ServiceI {

	
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSave(List<PostsetbXm1> list);
	
	
	/**
	 * 根据项目id删除
	 * @param fProjectId 项目id
	 * @return 返回影响数据条数
	 */
	int deleteByfProjectId(String fProjectId);
	
	
}
