/**
 * 
 */
package Ernest.Service.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postsetbXm3gwDaoI;
import Ernest.Entity.PostsetbXm;
import Ernest.Entity.PostsetbXm3gw;
import Ernest.Service.postsetbXm3gwServiceI;
import Ernest.Service.postsetbXmServiceI;

/**
 * 项目部/分包商岗位配置表实现类
 * @author Ernest
 *
 */
@Service
public class postsetbX3gwServiceimpl implements postsetbXm3gwServiceI {
	private static final Logger logger = Logger.getLogger(postsetbX3gwServiceimpl.class);
	@Autowired
	private postsetbXm3gwDaoI postsetbXm3gwDao;
	@Autowired
	private postsetbXmServiceI postsetbXmService;
	
	@Override
	public JSONObject findByProjectIdAndUser(String ProjectId, String UserId) {
		JSONObject json = new JSONObject();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<PostsetbXm3gw> list1 = postsetbXm3gwDao.findByProjectIdAndUser(ProjectId, UserId);
		for(int i=0;i<list1.size();i++){
			PostsetbXm3gw postsetXm3gw = new PostsetbXm3gw();
			Map<String, Object> map = new HashMap<String, Object>();
			postsetXm3gw = list1.get(i);
			map.put("fID", postsetXm3gw.getFid());
			map.put("fPostName",postsetXm3gw.getFpostName());
			if(postsetXm3gw.getFpostxmid2()==null){
				map.put("Class", "班组");
			}else{
				map.put("Class", "岗位");
			}
			list.add(map);
		}
		
		if(list.isEmpty()){
			json.put("success", false);
			json.put("message", "失败");
			json.put("data", "[]");
		}else{
			json.put("success", true);
			json.put("message", "成功");
			json.put("data", list);
			
		}
		
		return json;
	}
	
	@Override
	public Map<String, String> findByProjectId(String ProjectId) {
//		logger.info(ProjectId);
		List<PostsetbXm3gw> PX3list = postsetbXm3gwDao.findByProjectId(ProjectId);
		Map<String, String > map = new HashMap<String, String>();
//		logger.info(PX3list.size());
		for(PostsetbXm3gw px:PX3list){
			String sName = null;
			sName =px.getPostsetbXm3gw().getFpostName();
			String fPostWriteID = null;
			fPostWriteID=px.getFpostWriteId();
//			logger.info("进入"+fPostWriteID);
			
			if(fPostWriteID==null||"".equals(fPostWriteID)||"null".equals(fPostWriteID)){
//				logger.info("进入");
			}else{
				
				int index = fPostWriteID.indexOf(",");
				String[] attrID = fPostWriteID.split(",");
				for(int i=0;i<attrID.length;i++){
					map.put(attrID[i], sName);
				}
			}
		}
//		logger.info(map.toString());
		return map;
	}



	@Override
	public JSONObject insertProjectPost(String Class, String fID, String UserID, String fPostName) {
		JSONObject json = new JSONObject();
		boolean falge = true;
		String message= ""; 
		if("岗位".equals(Class)){
			falge = true;
			message = "新增岗位";
		}else if("班组".equals(Class)){
			falge = false;
			message = "新增班组";
		}
		logger.info("fID:"+fID+",UserID:"+UserID+",Class:"+Class+",fPostName:"+fPostName);
		List<PostsetbXm> PXlist = postsetbXmService.findByProjectIdAndUser(fID, UserID);
		logger.info("数量:"+PXlist.size());
		List<PostsetbXm3gw> PX3list = new ArrayList<PostsetbXm3gw>();
		String fID4 =null;
		String fMasterID = null;		
		if(PXlist.size()>0){
			fID4 =PXlist.get(0).getFid();
			fMasterID = PXlist.get(0).getFmasterId();
			
		}
		String fysxs1 = "2";
		String fNo = "7";
		String fPostxmid1 = UUID.randomUUID().toString();//主键
		String fPostXlb = "fbs";
		String fPostType = "项目部";
		String fPostxmid2 = fPostxmid1;
		int a = 0;
		int b = 0;
		int c = 0;
		String fID1 = UUID.randomUUID().toString();
		String fID2 = UUID.randomUUID().toString();
		String fID3 = UUID.randomUUID().toString();
		int num = 0;
		if(fID4!=null&&!"".equals(fID4)&&!"null".equals(fID4)){
			PostsetbXm3gw postsetbXm3gw = new PostsetbXm3gw();
			postsetbXm3gw.setFid(fID1);
			postsetbXm3gw.setFpostName(fPostName);
			postsetbXm3gw.setFysxs1(fysxs1);
			postsetbXm3gw.setFno(fNo);
			postsetbXm3gw.setFpostxmid(fID4);
			postsetbXm3gw.setFpostxmid1(fPostxmid1);
			postsetbXm3gw.setFpostXlb(fPostXlb);
			postsetbXm3gw.setFpostType(fPostType);
			postsetbXm3gw.setFmasterId(fMasterID);
			postsetbXm3gw.setFpostCode(UUID.randomUUID().toString());
			if(falge){
				postsetbXm3gw.setFpostxmid2(fPostxmid2);
				PX3list.add(postsetbXm3gw);
			}else{
				PostsetbXm3gw postsetbXm3gw2 = new PostsetbXm3gw();
				PostsetbXm3gw postsetbXm3gw3 = new PostsetbXm3gw();
				Map<String, Object> inm2 = new HashMap<String, Object>();
				Map<String, Object> inm3 = new HashMap<String, Object>();
				fysxs1="1";
				fNo="8";
				fPostType="班组";
				
				postsetbXm3gw2.setFid(fID2);
				postsetbXm3gw2.setFpostName("施工班长");
				postsetbXm3gw2.setFysxs1(fysxs1);
				postsetbXm3gw2.setFno(fNo);
				postsetbXm3gw2.setFpostxmid(fID4);
				postsetbXm3gw2.setFpostxmid2(fPostxmid2);
				postsetbXm3gw2.setFpostXlb(fPostXlb);
				postsetbXm3gw2.setFpostType(fPostType);
				postsetbXm3gw2.setFmasterId(fMasterID);
				postsetbXm3gw2.setFpostCode(UUID.randomUUID().toString());
				
				postsetbXm3gw3.setFid(fID3);
				postsetbXm3gw3.setFpostName("班组人员");
				postsetbXm3gw3.setFysxs1(fysxs1);
				postsetbXm3gw3.setFno(fNo);
				postsetbXm3gw3.setFpostxmid(fID4);
				postsetbXm3gw3.setFpostxmid2(fPostxmid2);
				postsetbXm3gw3.setFpostXlb(fPostXlb);
				postsetbXm3gw3.setFpostType(fPostType);
				postsetbXm3gw3.setFmasterId(fMasterID);
				postsetbXm3gw3.setFpostCode(UUID.randomUUID().toString());
				PX3list.add(postsetbXm3gw2);
				PX3list.add(postsetbXm3gw3);
			}
			num = postsetbXm3gwDao.batchSaves(PX3list);
		}else{
			message ="项目部不存在不允许添加添加";
		}
		
		
		if(num>0){
			json.put("success", true);
			json.put("message", message+"成功");
		}else{
			json.put("success", false);
			json.put("message", message+"失败");
		}
		return json;
	}


	@Override
	public JSONObject updateProjectPost(String fID, String fPostName) {
		JSONObject json = new JSONObject();
		PostsetbXm3gw postsetbXm3gw = new PostsetbXm3gw();
		postsetbXm3gw.setFid(fID);
		postsetbXm3gw.setFpostName(fPostName);
		int a = postsetbXm3gwDao.UpdateById(postsetbXm3gw);
		if(a>0){
			json.put("success", true);
			json.put("message", "修改成功");
		}else{
			json.put("success", false);
			json.put("message", "修改失败");
		}
		return json;
	}

	
	@Override
	public JSONObject DeleteJobList(String fID) {
		JSONObject json = new JSONObject();
		List<PostsetbXm3gw> px3list = postsetbXm3gwDao.findChildById(fID);
		List<String> list = new ArrayList<String>();
		boolean falge = true; 
		if(!px3list.isEmpty()){
			String fPostWriteID = px3list.get(0).getFpostWriteId();
			if(fPostWriteID==null||"".equals(fPostWriteID)||"null".equals(fPostWriteID)){
				list.add(fID);
			}else{
				falge=false;
			}
			if(falge){
				for(PostsetbXm3gw postsetbXm3gw:px3list){
					String px3fID =postsetbXm3gw.getPostsetbXm3gw().getFid();
					String pxfPostWriteID =postsetbXm3gw.getPostsetbXm3gw().getFpostWriteId();
					list.add(px3fID);
					if(pxfPostWriteID==null||"".equals(pxfPostWriteID)||"null".equals(pxfPostWriteID)){
						
					}else{
						falge=false;
					}
				}
			}
		}
		if(falge){
			int a = postsetbXm3gwDao.batchDelete(list);
			if(a>0){
				json.put("message", "删除成功");
				json.put("success", true);
			}else{
				json.put("message", "该岗位不存在");
				json.put("success", false);
			}
		}else{
			json.put("message", "该岗位下已分配人员");
			json.put("success", false);
		}
		return json;
	}

	
	@Override
	public List<PostsetbXm3gw> findById(String fID) {
		return postsetbXm3gwDao.findById(fID);
	}

	
	@Override
	public int UpdateById(PostsetbXm3gw postsetbXm3gw) {
		
		return postsetbXm3gwDao.UpdateById(postsetbXm3gw);
	}

	
	@Override
	public List<PostsetbXm3gw> findChildById(String fID) {
		return postsetbXm3gwDao.findChildById(fID);
	}

	@Override
	public List<PostsetbXm3gw> findByChildId(String fID) {
		return postsetbXm3gwDao.findByChildId(fID);
	}

	
	@Override
	public List<PostsetbXm3gw> findfPostxmid2AndfPostName(String fPostxmid2, String fPostName) {
		
		return postsetbXm3gwDao.findfPostxmid2AndfPostName(fPostxmid2, fPostName);
	}

	/* (non-Javadoc)
	 * @see Ernest.Service.postsetbXm3gwServiceI#save(Ernest.Entity.PostsetbXm3gw)
	 */
	@Override
	public int save(PostsetbXm3gw postsetbXm3gw) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
