/**
 * 
 */
package Ernest.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Ernest.Entity.InformationTable;

/**
 * @author Ernest
 *
 */
@Repository
public interface informationTableDaoI {

	/**
	 * 查找该人员创建的项目
	 * @param writeId
	 * @return
	 */
	List<InformationTable> findList(String writeId);
	
	/**
	 * 查找项目信息
	 * @param fID
	 * @return
	 */
	List<InformationTable> findById(String fID);
	
	/**
	 * 
	 * @param informationTable
	 * @return
	 */
	int updateByMapId(InformationTable informationTable);
}
