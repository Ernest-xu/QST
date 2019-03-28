/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.SaOppersonOprole;

/**
 * @author Ernest
 *
 */
@Repository
public interface saOppersonOproleDaoI {

	/**
	 * 保存
	 * @param saOppersonOprole
	 * @return
	 */
	int save(SaOppersonOprole saOppersonOprole);
	/**
	 * 修改
	 * @param saOppersonOprole
	 * @return
	 */
	int updateById(SaOppersonOprole saOppersonOprole);
	
	SaOppersonOprole findById(String id);
	/**
	 * 删除根据主键
	 * @param id
	 * @return
	 */
	int deletById(String id);
	/**
	 * 删除根据人员
	 * @param id
	 * @return
	 */
	int deletByUserId(String id);
	/**
	 * 根据人员列表删除
	 * @param list
	 * @return
	 */
	int deleteByUserIds(List<String> list);
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSaves(List<SaOppersonOprole> list);
	/**
	 * 根据列表id删除
	 * @param list
	 * @return
	 */
	int deletByIds(List<String> list);
}
