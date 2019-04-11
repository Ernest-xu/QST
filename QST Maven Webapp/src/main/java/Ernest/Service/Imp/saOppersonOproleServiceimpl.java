/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.saOppersonOproleDaoI;
import Ernest.Entity.SaOppersonOprole;
import Ernest.Service.saOppersonOproleServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class saOppersonOproleServiceimpl implements saOppersonOproleServiceI {
	private static final Logger logger = Logger.getLogger(saOppersonOproleServiceimpl.class);
	@Autowired
	private saOppersonOproleDaoI saOODao;
	
	@Override
	public String addSaOpersonOprole(JSONObject json) {
		SaOppersonOprole saOppersonOprole = new SaOppersonOprole();
		saOppersonOprole.setRoleId(json.getString("role"));
		saOppersonOprole.setSid(json.getString("sid"));
		saOppersonOprole.setSmd5str(json.getString("smd5str"));
		saOppersonOprole.setUserId(json.getString("userId"));
		saOODao.save(saOppersonOprole);
		JSONObject job = new JSONObject();
		job.put("success", true);
		job.put("message", "成功");
		return job.toString();
	}

	
	@Override
	public String updateSaOpersonOprole(JSONObject json) {
		SaOppersonOprole saOppersonOprole = new SaOppersonOprole();
		saOppersonOprole.setRoleId(json.getString("role"));
		saOppersonOprole.setSid(json.getString("sid"));
		saOppersonOprole.setSmd5str(json.getString("smd5str"));
		saOppersonOprole.setUserId(json.getString("userId"));
		saOODao.updateById(saOppersonOprole);
		JSONObject job = new JSONObject();
		job.put("success", true);
		job.put("message", "成功");
		return job.toString();
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonOproleServiceI#DeleteSaOpersonOprole(java.lang.String)
	 */
	@Override
	public String DeleteSaOpersonOprole(String id) {
		saOODao.deletById(id);
		JSONObject job = new JSONObject();
		job.put("success", true);
		job.put("message", "成功");
		return job.toString();
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonOproleServiceI#findSaOpersonOprole(java.lang.String)
	 */
	@Override
	public String findSaOpersonOprole(String id) {
		SaOppersonOprole saOppersonOprole = saOODao.findById(id);
		JSONObject job = new JSONObject();
		if(saOppersonOprole==null){
			return "{}";
		}else{
			
			job.put("sid",saOppersonOprole.getSid());
			job.put("role",saOppersonOprole.getRoleId());
			job.put("smd5str",saOppersonOprole.getSmd5str());
			job.put("userId",saOppersonOprole.getUserId());
			return job.toJSONString();
		}
		
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonOproleServiceI#deletByUserId(java.lang.String)
	 */
	@Override
	public JSONObject deletByUserId(String id) {
		JSONObject json = new JSONObject();
		int a =  saOODao.deletByUserId(id);
		logger.info(a);
		json.put("success", true);
		json.put("message", "成功");
		return json;
	}


	@Override
	public int deleteByUserIds(List<String> list) {
		
		return saOODao.deleteByUserIds(list);
	}


	@Override
	public int batchSaves(List<SaOppersonOprole> list) {
		return saOODao.batchSaves(list);
	}


	@Override
	public int deleteById(List<String> list) {
		
		return saOODao.deletByIds(list);
	}

	
	
}
