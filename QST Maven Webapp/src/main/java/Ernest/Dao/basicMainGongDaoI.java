/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.BasicMainGong;

/**
 * @author Ernest
 *
 */
@Repository
public interface basicMainGongDaoI {

	
	List<BasicMainGong> findByfMasterId(String fMasterID);
	
	
	
	
}
