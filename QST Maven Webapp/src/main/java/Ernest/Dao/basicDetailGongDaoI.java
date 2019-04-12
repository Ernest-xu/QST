/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.BasicDetailGong;

/**
 * @author Ernest
 *
 */
@Repository
public interface basicDetailGongDaoI {

	/**
	 * 
	 * @param fMasterID
	 * @param fBz
	 * @return
	 */
	List<BasicDetailGong> findbyfMasterIdAndfBz(String fMasterID,String fBz);
	
}
