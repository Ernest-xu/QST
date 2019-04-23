/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.PmProjectBasicMain;

/**
 * @author Ernest
 *
 */
public interface pmProjectBasicMainServiceI {

	
	/**
	 * 查找所有的基础配置主表信息
	 * @return 
	 */
	List<PmProjectBasicMain> findAll();
}
