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
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.saOporgDaoI;
import Ernest.Entity.SaOporg;
import Ernest.Service.saOporgServiceI;
import Ernest.Service.saOppersonOproleServiceI;
import Ernest.Service.saOppersonServiceI;
import Ernest.until.Head;
import Ernest.until.RecursiveHierarchy;

/**
 * 组织表实现类
 * @author Ernest
 *
 */
@Service
public class saOporgServiceimpl implements saOporgServiceI{

	private static final Logger logger = Logger.getLogger(saOporgServiceimpl.class);
	@Autowired
	private saOporgDaoI saOporgDao;
	@Autowired
	private saOppersonOproleServiceI saOppersonOproleService;
	@Autowired
	private saOppersonServiceI saOppersonService;
	@Override
	public SaOporg findAdmin(String md5, String kind) {
		return saOporgDao.findAdmin(md5, kind);
	}
	
	

	
	@Override
	public String updateSaOporgById(JSONObject json) {
		SaOporg saOporg  = new SaOporg();
		saOporg.setSid(json.getString("sid"));
		saOporg.setSname(json.getString("sname"));
		saOporg.setSfname(json.getString("sfname"));
		saOporg.setSmd5str(json.getString("smd5str"));
		saOporg.setSparentId(json.getString("sparentId"));
		saOporg.setFimage(json.getString("fimage"));
		saOporgDao.updateById(saOporg);
		JSONObject job = new JSONObject();
		job.put("success",true);
		job.put("message", "成功");
		return job.toString();
	}

	/**
	 * 递归分层显示
	 */
	@Override
	public String findRoleList(String md5) {
		JSONObject json = new JSONObject();
		List<SaOporg> list1 = saOporgDao.findByMd5(md5);
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list1.size();i++){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("sId", list1.get(i).getSid());
			map.put("sMd5Str", list1.get(i).getSmd5str());
			map.put("sParendId", list1.get(i).getSparentId());
			map.put("sName", list1.get(i).getSfname());
			list2.add(map);
		}
		if(list1==null){
			json.put("list","[]");
			json.put("success", false);
		}else{
			Map<String,String> map1 = new HashMap<String, String>();
			map1.put("id", "sId");
			map1.put("label", "sName");
			map1.put("sParentID", "sParendId");
			map1.put("sMd5Str", "sMd5Str");
			Map<String, String> Parentmap= new HashMap<String, String>();
			Parentmap.put("sParentID", "id");
			list3 = RecursiveHierarchy.getChildren(list2, map1, Parentmap, 1, 2, null);
			json.put("list", list3);
			json.put("success", true);
		}
		return json.toString();
		
	}

	/**
	 * 获取所有部门并以map的形式返回
	 */
	@Override
	public Map<String, Object> AllDepartment(String md5) {
		List<SaOporg> list = saOporgDao.getAllDepartment(md5, "dep");
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i=0;i<list.size();i++){
			map.put(list.get(i).getSfname(),list.get(i).getSid() );
			map.put(list.get(i).getSid(),list.get(i).getSfname() );
		}
		return map;
	}



	/**
	 * 新增部门
	 */
	@Override
	public JSONObject save(String sFName, String sMd5Str, String sParentID) {
		JSONObject json = new JSONObject();
		SaOporg saOporg = new SaOporg();
		String sNodeKind = "dep";
		String fImage=Head.getRandomImage();
		Date date = new Date();
		Timestamp screateTime = new Timestamp(date.getTime());
		if("系统管理员".equals(sFName)){
			json.put("message", "保存失败，不允许创建名为系统管理员的部门");
			json.put("success", false);
		}else{
			String sID = UUID.randomUUID().toString();
			saOporg.setSid(sID);
			saOporg.setSfname(sFName);
			saOporg.setSmd5str(sMd5Str);
			saOporg.setSparentId(sParentID);
			saOporg.setFimage(fImage);
			saOporg.setSnodeKind(sNodeKind);
			saOporg.setScreateTime(screateTime);
			saOporgDao.save(saOporg);
			logger.info(sID);
			json.put("message", "保存成功");
			json.put("success", true);
		}
		
		return json;
	}




	/**
	 * 修改部门名称
	 */
	@Override
	public JSONObject updateSaOporgById(String sFName, String sID) {
		JSONObject json = new JSONObject();
		SaOporg saOporg = new SaOporg();
		if("系统管理员".equals(sFName)){
			json.put("success",false);
			json.put("message","修改失败，不允许修改为系统管理员");
		}else{
			saOporg.setSid(sID);
			saOporg.setSfname(sFName);
			saOporgDao.updateById(saOporg);
			json.put("success",true);
			json.put("message","修改成功");
		}
		
		
		return json;
	}



	/**
	 * 删除部门，如果部门下有人员，连同人员一起删除
	 */
	@Override
	public JSONObject deleteByParentId(String sParentID) {
		JSONObject json = new JSONObject();
		SaOporg saOporg = saOporgDao.findDetail(sParentID);
		if(saOporg!=null&&"系统管理员".equals(saOporg.getSfname())){
			json.put("success",false);
			json.put("message","删除失败,该部门不允许删除");
		}else{
			List<String> list = new ArrayList<String>();
			List<SaOporg> SOlist = saOporgDao.findSubclass(sParentID);
			for(SaOporg so:SOlist){
				list.add(so.getSid());
			}
			/*需要另外两张表的删除*/
			list.add(sParentID);
			saOppersonService.deleteByIds(list);
			saOppersonOproleService.deleteByUserIds(list);
			saOporgDao.deleteByIds(list);
			json.put("success",true);
			json.put("message","删除成功");
		}
		return json;
	}


	@Override
	public SaOporg findTopByMd5(String md5) {
		
		return saOporgDao.findTopByMd5(md5);
	}

	@Override
	public int save(SaOporg saOporg) {
		return saOporgDao.save(saOporg);
	}


	@Override
	public int update(SaOporg saOporg) {
		return saOporgDao.updateById(saOporg);
	}


	@Override
	public List<SaOporg> findBysParentID2(String sParentID2) {
		
		return saOporgDao.findBysParentID2(sParentID2);
	}



	@Override
	public List<SaOporg> findByListId(List<String> list) {
		
		return saOporgDao.findListByIds(list);
	}



	@Override
	public int DeleteParentID2(List<String> list) {
		
		return saOporgDao.DeleteParentID2(list);
	}


	@Override
	public int DeleteByListId(List<String> list) {
		
		return saOporgDao.deleteByIds(list);
	}




	@Override
	public List<SaOporg> getAllDepartment(String md5, String kind) {
		return saOporgDao.getAllDepartment(md5, kind);
	}


	@Override
	public int batchSaves(List<SaOporg> list) {
		
		return saOporgDao.batchSaves(list);
	}

}
