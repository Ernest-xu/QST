/**
 * 
 */
package Ernest.Service.Imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.saOproleDaoI;
import Ernest.Entity.saOprole;
import Ernest.Service.saFunctionServiceI;
import Ernest.Service.saOppersonOproleServiceI;
import Ernest.Service.saOproleServiceI;
import Ernest.until.TimeUntil;

/**
 * 角色表实现类
 * @author Ernest
 *
 */
@Service
public class saOproleServiceimp implements saOproleServiceI {
	private static final Logger logger = Logger.getLogger(saOproleServiceimp.class);
	 @Autowired
	private saOproleDaoI saOproleDao;
	 @Autowired
	 private saFunctionServiceI saFunctionService;
	 @Autowired
	 private saOppersonOproleServiceI saOppersonOproleService;
	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#listSaOprole(java.lang.String)
	 */
	@Override
	public JSONObject listSaOprole(String md5) {
		JSONObject json  = new JSONObject();
		List<saOprole> list1 =  saOproleDao.findAllBySaOproleSmd5str(md5);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list1.size();i++){
			saOprole saoprole = new saOprole();
			saoprole = list1.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID",saoprole.getSid());
			map.put("sName",saoprole.getSname());
			map.put("sMd5Str",saoprole.getSmd5str());
			String sTime = TimeUntil.TimestampToString(saoprole.getScreateTime()).replace("/", "-");
			map.put("sCreateTime",sTime);
			list.add(map);
		}
		if(list.isEmpty()){
			json.put("data", "[]");
			json.put("success", false);
			json.put("message", "查无数据");
		}else{
			json.put("data", list);
			json.put("success", true);
			json.put("message", "查找成功");
			
		}
		return json;
	}

	@Override
	public List<saOprole> listSaOproles(String md5) {
		return saOproleDao.findAllBySaOproleSmd5str(md5);
	}
	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#selectSaOprole(java.lang.String)
	 */
	@Override
	public saOprole selectSaOprole(String id) {
		return saOproleDao.findBySaOproleId(id);
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#addSaOprole(Ernest.Entity.saOprole)
	 */
	@Override
	public void addSaOprole(saOprole saOprole) {
		int a = saOproleDao.save(saOprole);
	}


	
	@Override
	public List<Map<String, Object>> selectJobName(String id) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<saOprole> list2= saOproleDao.findJob(id);
		if(list2.size()==0){
			list2 = saOproleDao.findgroup(id);
		}
		for(int i=0;i<list2.size();i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID", list2.get(i).getSid());
			map.put("sName", list2.get(i).getSname());
			list.add(map);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#selectSaOproleList(java.lang.String)
	 */
	@Override
	public JSONObject selectSaOproleList(String md5) {
		JSONObject json  = new JSONObject();
		List<saOprole> list1 =  saOproleDao.findAllBySaOproleSmd5str(md5);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list1.size();i++){
			saOprole saoprole = new saOprole();
			saoprole = list1.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID",saoprole.getSid());
			map.put("sName",saoprole.getSname());
			list.add(map);
		}
		if(list.isEmpty()){
			json.put("select", "[]");
			json.put("success", false);
			json.put("message", "查无数据");
		}else{
			json.put("select", list);
			json.put("success", true);
			json.put("message", "查找成功");
			
		}
		return json;
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#CreateRoleAndFunction(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject CreateRoleAndFunction(String fRoleName, String companyId, String md5Str) {
		JSONObject json = new JSONObject();
		saOprole saoprole = new saOprole();
		String sID = UUID.randomUUID().toString();
		saoprole.setSid(sID);
		saoprole.setSmd5str(md5Str);
		Date date = new Date();
		Timestamp timeStamep = new Timestamp(date.getTime());
		saoprole.setScreateTime(timeStamep);
		saoprole.setSname(fRoleName);
		JSONObject job = saFunctionService.saveAllFunction(sID, companyId);
		if(job.getBoolean("success")){
			saOproleDao.save(saoprole);
			json.put("success", true);
			json.put("message", "创建成功");
		}else{
			json.put("success", false);
			json.put("message", "创建失败");
			
		}
		
		return json;
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#updateById(java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject updateById(String sID, String sName) {
		saOprole saoprole = new saOprole();
		JSONObject json = new JSONObject();
		saoprole.setSid(sID);
		saoprole.setSname(sName);
		int a = saOproleDao.update(saoprole);
		logger.info(a);
		json.put("success", true);
		json.put("message", "修改成功");
		return json;
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.saOproleServiceI#DeleteRole(java.lang.String)
	 */
	@Override
	public JSONObject DeleteRole(String id) {
		JSONObject json = new JSONObject();
		int a = saOproleDao.deleteById(id);
		saFunctionService.deleteFunctionByRole(id);
		saOppersonOproleService.deletByUserId(id);
		json.put("success", true);
		json.put("message", "成功");
		return json;
	}


	
	
}
