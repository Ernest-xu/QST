/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.SaOpperson;


/**
 * @author Ernest
 *
 */
@Repository
public interface saOppersonDaoI {
	/**
	 * 人员登录查找
	 * @param name
	 * @param password
	 * @return
	 */
	SaOpperson Login(String name,String password);
	/**
	 * 新增人员
	 * @param saOpperson
	 * @return
	 */
	int save(SaOpperson saOpperson);
	/**
	 * 根据父id查找所有子数据
	 * @param id 父类id
	 * @return
	 */
	List<SaOpperson> findPersonList(String id);
	/**
	 * 根据组织、部门id模糊查询
	 * @param md5
	 * @param id
	 * @param name
	 * @return
	 */
	List<SaOpperson> likeFindPersonList(String md5 ,String id,String name);
	/**
	 * 根据列表中的id删除
	 * @param list
	 * @return
	 */
	int deleteByIds(List<String> list);
	/**
	 * 修改人员信息根据主键
	 * @param saOpperson
	 * @return
	 */
	int update(SaOpperson saOpperson);
	/**
	 * 根据id查找列表
	 * @param id
	 * @return
	 */
	List<SaOpperson> findListById(String id);
	
	/**
	 * 批量保存
	 * @param list
	 * @return
	 */
	int batchSaves(List<SaOpperson> list);
}
