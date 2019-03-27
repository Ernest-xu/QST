/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.SaOporg;

/**
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

	List<SaOporg> getAllDepartment(String md5,String kind);
	
	int save(SaOporg saOporg);
	
	int updateById(SaOporg saOporg);
	
	List<SaOporg> findByMd5(String md5);
	
	int deleteByIds(List<String> list);
	
	SaOporg findDetail(String id);
	
	List<SaOporg> findSubclass(String sParentID);
	
	SaOporg findTopByMd5(String md5);
}
