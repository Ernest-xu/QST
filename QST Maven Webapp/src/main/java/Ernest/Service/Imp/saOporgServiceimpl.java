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
import Ernest.until.RecursiveHierarchy;

/**
 * @author Ernest
 *
 */
@Service
public class saOporgServiceimpl implements saOporgServiceI{

	private static final Logger logger = Logger.getLogger(saOporgServiceimpl.class);
	@Autowired
	private saOporgDaoI saOporgDao;
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
//		saOporg.setSorgKindId(json.getString("sorgKindId"));
//		saOporg.setSnodeKind(json.getString("snodeKind"));
//		saOporg.setSmd5str2(json.getString("smd5str2"));
//		saOporg.setSphone(json.getString("sphone"));
		saOporg.setSparentId(json.getString("sparentId"));
		saOporg.setFimage(json.getString("fimage"));
		saOporgDao.updateById(saOporg);
		JSONObject job = new JSONObject();
		job.put("success",true);
		job.put("message", "成功");
		//[{"sid":"1106","sname":"1","sfname":"2","smd5str":"3","sorgKindId":"4","snodeKind":"5","smd5str2":"6","sphone":"7","sparentId":"8","fimgae":"9"}]
		return job.toString();
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.saOporgServiceI#findRoleList(java.lang.String)
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

	/* (non-Javadoc)
	 * @see Ernest.Service.saOporgServiceI#AllDepartment(java.lang.String)
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




	/* (non-Javadoc)
	 * @see Ernest.Service.saOporgServiceI#save(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject save(String sFName, String sMd5Str, String sParentID) {
		JSONObject json = new JSONObject();
		SaOporg saOporg = new SaOporg();
		String sNodeKind = "dep";
		String img1 = "/x5/UI2/BZB01/common/image/dept1.png", 
			   img2 = "/x5/UI2/BZB01/common/image/dept2.png", 
			   img3 = "/x5/UI2/BZB01/common/image/dept3.png", 
			   img4 = "/x5/UI2/BZB01/common/image/dept1.png", 
			   img5 = "/x5/UI2/BZB01/common/image/dept1.png", 
			   img6 = "/x5/UI2/BZB01/common/image/dept1.png";
		List<String> imgList=new ArrayList<String>();
		imgList.add(img6);
		imgList.add(img5);
		imgList.add(img4);
		imgList.add(img3);
		imgList.add(img2);
		imgList.add(img1);
		String fImage=imgList.get(new Random().nextInt(5)+1);
		Date date = new Date();
		Timestamp screateTime = new Timestamp(date.getTime());
		if("系统管理员".equals(sFName)){
			json.put("message", "保存失败，不允许创建名为系统管理员的部门");
			json.put("success", false);
		}else{
			String sID = UUID.randomUUID().toString();
			saOporg.setSid(sID);
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




	/* (non-Javadoc)
	 * @see Ernest.Service.saOporgServiceI#updateSaOporgById(java.lang.String, java.lang.String)
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

}
