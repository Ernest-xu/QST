package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PmProjectBasicDetail;

/**
 * 基础配置从表Dao
 * @author Ernest
 *
 */
@Repository
public interface pmProjectBasicDetailDaoI {
	
	/**
	 * 查找所有基础配置从表信息
	 * @return
	 */
	List<PmProjectBasicDetail> findAll();
	
}
