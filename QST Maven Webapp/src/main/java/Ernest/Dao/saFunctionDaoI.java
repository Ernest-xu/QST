/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.SaFunction;

/**
 * @author Ernest
 *
 */
@Repository
public interface saFunctionDaoI {

	/**
	 * 创建一个新的功能
	 * @param saFunction
	 * @return 数据影响条数
	 */
	int save(SaFunction saFunction);
	/**
	 * 修改功能
	 * @param saFunction
	 * @return 数据影响条数
	 */
	int updateById(SaFunction saFunction);
	/**
	 * 批量插入
	 * @param list
	 */
	void batchSaves(List<SaFunction> list);
	/**
	 * 根据角色id删除
	 * @param id 角色id
	 * @return
	 */
	int deleteByRoleId(String id);
	/**
	 * 根据角色list的id删除
	 * @param list
	 * @return
	 */
	int deleteByRoleIds(List<String> list);
}
