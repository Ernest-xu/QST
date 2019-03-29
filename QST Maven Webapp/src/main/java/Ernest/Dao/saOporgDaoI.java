/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.SaOporg;

/**
 * 组织
 * @author Ernest
 *
 */
@Repository
public interface saOporgDaoI {
	
	/**
	 * 根据md5查找管理员
	 * @param md5
	 * @return
	 */
	SaOporg findAdmin(String md5,String kind);
	/**
	 * 根据MD5和管理员判断状态查找
	 * @param md5 md5
	 * @param kind 理员判断状态
	 * @return list
	 */
	List<SaOporg> getAllDepartment(String md5,String kind);
	/**
	 * 新增人员返回影响条数
	 * @param saOporg
	 * @return
	 */
	int save(SaOporg saOporg);
	/**
	 * 
	 * @param saOporg
	 * @return
	 */
	int updateById(SaOporg saOporg);
	/**
	 * 
	 * @param md5
	 * @return
	 */
	List<SaOporg> findByMd5(String md5);
	/**
	 * 根据list的id删除
	 * @param list
	 * @return
	 */
	int deleteByIds(List<String> list);
	/**
	 * 根据id查找内容
	 * @param id
	 * @return
	 */
	SaOporg findDetail(String id);
	/**
	 * 根据父类id查找
	 * @param sParentID
	 * @return
	 */
	List<SaOporg> findSubclass(String sParentID);
	/**
	 * 根据md5查找顶级父类
	 * @param md5
	 * @return
	 */
	SaOporg findTopByMd5(String md5);
	/**
	 * 根据只读管理员查找人员
	 * @param sParentID2
	 * @return
	 */
	List<SaOporg> findBysParentID2(String sParentID2);
	/**
	 * 根据列表的id获取人员
	 * @param list
	 * @return
	 */
	List<SaOporg> findListByIds(List<String> list);

	/**
	 * 根据只读管理员list删除人员
	 * @param list
	 * @return
	 */
	int DeleteParentID2(List<String> list);
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSaves(List<SaOporg> list);
	
}
