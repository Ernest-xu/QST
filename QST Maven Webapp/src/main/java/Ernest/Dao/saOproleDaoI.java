/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.saOprole;

/**
 * @author Ernest
 *
 */
@Repository
public interface saOproleDaoI {
	
	/**
	 * 
	 */
	int save(saOprole saOprole);
	
	saOprole findBySaOproleId(String Id); 
		
	List<saOprole> findAllBySaOproleSmd5str(String smd5str);
	
	int update(saOprole saOprole);
	
	int deleteById(String id);
	
	List<saOprole> findJob(String id);

	List<saOprole> findgroup(String id);
}
