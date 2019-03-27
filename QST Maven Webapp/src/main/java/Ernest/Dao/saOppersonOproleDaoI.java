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

	
	int save(SaOppersonOprole saOppersonOprole);
	
	int updateById(SaOppersonOprole saOppersonOprole);
	
	SaOppersonOprole findById(String id);
	
	int deletById(String id);
	
	int deletByUserId(String id);
	
	int deleteByUserIds(List<String> list);
	
	int batchSaves(List<SaOppersonOprole> list);
	
	int deletByIds(List<String> list);
}
