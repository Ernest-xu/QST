/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.PmProjectBasciPostset;

/**
 * @author Ernest
 *
 */
public interface pmProjectBasciPostsetServiceI {

	
	/**
	 * 查找所有的标准岗位
	 * @return 返回查到的所有的信息
	 */
	List<PmProjectBasciPostset> findAll();
}
