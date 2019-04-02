/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.InformationTable;

/**
 * @author Ernest
 *
 */
@Repository
public interface informationTableDaoI {

	
	List<InformationTable> findList(String writeId);
	
}
