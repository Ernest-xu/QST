/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.PmProjectBasicDetail;

/**
 * @author Ernest
 *
 */
public interface pmProjectBasicDetailServiceI {

	
	
	/**
	 * 查找所有基础配置从表信息
	 * @return
	 */
	List<PmProjectBasicDetail> findAll();
}
