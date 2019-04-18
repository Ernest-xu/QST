/**
 * 
 */
package Ernest.Dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import Ernest.Entity.InformationTable;

/**
 * 项目表语句
 * @author Ernest
 *
 */
@Repository
public interface informationTableDaoI {

	/**
	 * 查找该人员创建的项目
	 * @param writeId 创建人id
	 * @return
	 */
	List<InformationTable> findList(String writeId);
	
	/**
	 * 查找项目信息
	 * @param fID 项目id
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
