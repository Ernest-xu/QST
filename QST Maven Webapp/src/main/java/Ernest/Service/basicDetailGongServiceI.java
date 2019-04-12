/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.BasicDetailGong;

/**
 * @author Ernest
 *
 */
public interface basicDetailGongServiceI {

	
	List<BasicDetailGong> basicDetailGongMap(String fMasterID,String fBz);
}
