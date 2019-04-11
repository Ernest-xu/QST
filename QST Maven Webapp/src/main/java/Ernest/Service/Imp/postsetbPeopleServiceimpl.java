/**
 * 
 */
package Ernest.Service.Imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postsetbPeopleDaoI;
import Ernest.Entity.InformationTable;
import Ernest.Entity.Pkrenyuan;
import Ernest.Entity.PostsetbPeople;
import Ernest.Entity.PostsetbXm3gw;
import Ernest.Entity.SaOpperson;
import Ernest.Service.informationTableServiceI;
import Ernest.Service.pkrenyuanServiceI;
import Ernest.Service.postsetbPeopleServiceI;
import Ernest.Service.postsetbXm3gwServiceI;
import Ernest.Service.saOppersonServiceI;
import Ernest.Service.saOproleServiceI;
import Ernest.until.TimeUntil;

/**
 * @author Ernest
 *
 */
@Service
public class postsetbPeopleServiceimpl implements postsetbPeopleServiceI {
	private static final Logger logger = Logger.getLogger(postsetbPeopleServiceimpl.class);
	@Autowired
	private postsetbPeopleDaoI postsetbPeopleDao;
	@Autowired
	private saOppersonServiceI saOppersonService;
	@Autowired
	private saOproleServiceI saOproleService;
	@Autowired
	private postsetbXm3gwServiceI postsetbXm3gwService;
	@Autowired
	private pkrenyuanServiceI pkrenyuanService;
	@Autowired
	private informationTableServiceI informationTableService; 
	@Override
	public JSONObject findPeopleListByProjectId(String ProjectId) {
		JSONObject json  = new JSONObject();
		Map<String, String> orgMap= postsetbXm3gwService.findByProjectId(ProjectId); 
//		logger.info("orgmap:"+orgMap.toString());
		List<PostsetbPeople> PPlist = postsetbPeopleDao.findPeopleListByProjectId(ProjectId);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(PostsetbPeople postsetbPeople : PPlist){
			Map<String,Object> map = new HashMap<String, Object>();
			SaOpperson saOpperson = new SaOpperson();
			saOpperson = postsetbPeople.getSaOpperson();
			map.put("sID", saOpperson.getSid());//人员ID
			map.put("sName", saOpperson.getSname());//真实姓名
			map.put("sMd5Str", saOpperson.getSmd5str());//md5
			map.put("sLoginName", saOpperson.getSloginName());//登录名
			map.put("sPassword", saOpperson.getSpassword());//密码
			map.put("fID", postsetbPeople.getFid());//岗位
			map.put("fPostName", postsetbPeople.getFpostName());//项目名称
//			logger.info(saOpperson.getSname()+","+saOpperson.getSid());
			map.put("sFName", orgMap.get( saOpperson.getSid()));//部门
			map.put("fxmbName", postsetbPeople.getPostsetbXm().getFxmbName());//分包商
			List<Map<String, Object>> SOlist = saOproleService.selectJobName(postsetbPeople.getSaOpperson().getSid());
			map.put("roleIds", SOlist);
			list.add(map);
		}
		//分类排序
		Collections.sort(list, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
            	String n1="";
            	if(o1.get("sFName")!=null){
            		n1=(String)o1.get("sFName");
            	}
            	
            	String n2="";
            	if(o2.get("sFName")!=null){
            		n2=(String)o2.get("sFName");
            	}
//                我这里是从大到小的排序，如果从小到大，n1和n2换一下位置就可以了
                return n2.compareTo(n1);
            }
        });
//		for(Map<String ,Object> map:list){
//			logger.info(map.toString());
//		}
		if(!list.isEmpty()){
			json.put("Data", list);
			json.put("success", true);
		}else{
			json.put("success",false);
		};
		return json;
	}

	
	@Override
	public JSONObject SelectPerson(String fProjectID, String sMd5Str) {
		JSONObject json = new JSONObject();
		List<PostsetbPeople> PPlist = postsetbPeopleDao.findPersonByProjectAndmd5(fProjectID, sMd5Str);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		int number=0;
//		logger.info("数量:"+PPlist.size());
		for(PostsetbPeople postsetbPeople:PPlist){
			Map<String ,String> map = new HashMap<String, String>();
			map.put("fID", postsetbPeople.getSaOpperson().getSid());
			map.put("sName", postsetbPeople.getSaOpperson().getSname());
//			logger.info(map.toString());
			list.add(map);
			number++;
		}
		if(number>0){
			json.put("success", true);
			json.put("message", "成功");
			json.put("number", number);
			json.put("data", list);
		}else{
			json.put("success", false);
			json.put("message", "没有未分配岗位的人员");
		}
		return json;
	}


	@Override
	public JSONObject DeleteJobPeople(String fID) {
		
		return null;
	}


	
	@Override
	public int getAddPeople(String fID, String BumchfID, String fProjectID, String fProjectCode, String fProjectName,
			String md5, String sMd5Str) {
		int a = 0;
		List<PostsetbXm3gw> list = postsetbXm3gwService.findById(fID);
		Date date = new Date();
		Timestamp screateTime = new Timestamp(date.getTime());
		String Time = TimeUntil.TimestampToString(screateTime);
		List<PostsetbPeople> PPlist = new ArrayList<PostsetbPeople>();
		List<Pkrenyuan> Plist = new ArrayList<Pkrenyuan>();
		if(!list.isEmpty()){
			PostsetbXm3gw postsetbXm3gw = new PostsetbXm3gw();
			postsetbXm3gw.setFysxs1("2");
			postsetbXm3gw.setFid(fID);
			String BumchName ="";
			
			if(BumchfID==null||"".equals(BumchfID)||"null".equals(BumchfID)){
				
			}else{
				String[] StrID = BumchfID.split(",");
				for(int i=0;i<StrID.length;i++){
					String UUId = UUID.randomUUID().toString();
					List<SaOpperson> SOlist = saOppersonService.findListById(StrID[i]);
					PostsetbPeople  postsetbPeople = new PostsetbPeople();
					if(!SOlist.isEmpty()){
						String UserName = SOlist.get(0).getSname();
						if(i>0){
							BumchName += ","+UserName;
						}else{
							BumchName += UserName;
						}
//						logger.info("PostsetbPeople:"+list.get(0).toString());
//						logger.info("SaOpperson:"+SOlist.get(0).toString());
						postsetbPeople.setFid(UUId);
						postsetbPeople.setFpostWriteName(UserName);
						postsetbPeople.setFpostWriteId(StrID[i]);
						postsetbPeople.setFmasterId(list.get(0).getFpostxmid());
						postsetbPeople.setFcreateTime(Time);
						postsetbPeople.setFpostName(list.get(0).getFpostName());
						postsetbPeople.setFimage(SOlist.get(0).getFimage());
						postsetbPeople.setFphone(SOlist.get(0).getSmobilePhone());
						postsetbPeople.setFprojectName(fProjectName);
						postsetbPeople.setFprojectCode(fProjectCode);
						postsetbPeople.setFprojectId(fProjectID);
						postsetbPeople.setFpostxmid2(list.get(0).getFpostxmid2());
						postsetbPeople.setFroleName(SOlist.get(0).getSworkType());
						String str  ="";
						if("8".equals(list.get(0).getFysxs1())){
							str  = "是";
						}else{
							str  = "否";
						}
						postsetbPeople.setFrenyn(str);
						PPlist.add(postsetbPeople);
						Pkrenyuan pkrenyuan = new Pkrenyuan();
						String uuid = UUID.randomUUID().toString();
						pkrenyuan.setFid(uuid);
						pkrenyuan.setFwriteTime(screateTime);;
						pkrenyuan.setFmd5(md5);
						pkrenyuan.setFprojectName(fProjectName);
						pkrenyuan.setFprojectId(fProjectID);
						pkrenyuan.setFprojectCode(fProjectCode);
						pkrenyuan.setFwriteName(UserName);
						pkrenyuan.setFwriteId(StrID[i]);
						pkrenyuan.setFwriteMd5(sMd5Str);
						Plist.add(pkrenyuan);
					}
				}
				
			}
			String ifID=list.get(0).getFpostWriteId();
			String ifName = list.get(0).getFpostWriteName();
//			logger.info(ifID+","+ifName);
			if(ifID==null||"".equals(ifID)||"null".equals(ifID)){
				
			}else{
				BumchName+=","+ifName;
				BumchfID+=","+ifID;
			}
//			logger.info("BumchName:"+BumchName+",BumchfID:"+BumchfID+",id:"+postsetbXm3gw.getFid());
			postsetbXm3gw.setFpostWriteId(BumchfID);
			postsetbXm3gw.setFpostWriteName(BumchName);
			pkrenyuanService.batchSave(Plist);
			postsetbPeopleDao.batchSaves(PPlist);
			a=postsetbXm3gwService.UpdateById(postsetbXm3gw);
		}
		
		return a;
	}


	
	@Override
	public JSONObject AddJobPeople(String BumchfID1, String BumchfID2, String fID, String fProjectID, String Class) {
		JSONObject json = new JSONObject();
		int a = 0;
		int b = 0;
		boolean falge = true;
		if("岗位".equals(Class)){
			falge = false;
		}else if("班组".equals(Class)){
			falge = true;
		}
			List<InformationTable> list = informationTableService.findById(fProjectID);
			if(!list.isEmpty()){
				InformationTable informationTable = new InformationTable();
				informationTable = list.get(0);
				if(falge){
					Map<String,String> mapGroup = new HashMap<String, String>();
					List<PostsetbXm3gw> PX3list = postsetbXm3gwService.findByChildId(fID);
					for(PostsetbXm3gw postsetbXm3gw:PX3list){
						mapGroup.put(postsetbXm3gw.getFpostName(), postsetbXm3gw.getFid());
					}
					if(BumchfID1==null||"".equals(BumchfID1)||"null".equals(BumchfID1)){
						
					}else{
						String fID1 = mapGroup.get("施工班长");
						if(fID1==null||"".equals(fID1)||"null".equals(fID1)){
						}else{
							a=getAddPeople(fID1, BumchfID1,  fProjectID, informationTable.getFprojectCode(), informationTable.getFprjoectName(),informationTable.getFmd5(),informationTable.getFpeolistMd5());
						}
						
					}
					if(BumchfID2==null||"".equals(BumchfID2)||"null".equals(BumchfID2)){
						
					}else{
						String fID2 = mapGroup.get("班组人员");
						if(fID2==null||"".equals(fID2)||"null".equals(fID2)){
						}else{
							b=getAddPeople( fID2, BumchfID2,  fProjectID, informationTable.getFprojectCode(), informationTable.getFprjoectName(),informationTable.getFmd5(),informationTable.getFpeolistMd5());
						}
						
					}
				}else{
					if(BumchfID1==null||"".equals(BumchfID1)||"null".equals(BumchfID1)){
						
					}else{
						if(fID==null||"".equals(fID)||"null".equals(fID)){
						}else{
							a=getAddPeople( fID, BumchfID1,  fProjectID, informationTable.getFprojectCode(), informationTable.getFprjoectName(),informationTable.getFmd5(),informationTable.getFpeolistMd5());					
						}
						
					}
					if(BumchfID2==null||"".equals(BumchfID2)||"null".equals(BumchfID2)){
						
					}else{
						if(fID==null||"".equals(fID)||"null".equals(fID)){
						}else{
							b=getAddPeople( fID, BumchfID2,  fProjectID, informationTable.getFprojectCode(), informationTable.getFprjoectName(),informationTable.getFmd5(),informationTable.getFpeolistMd5());					
						}
						
					}
				}
				
				if(a>0){
					if(b>0){
						json.put("success", true);
						json.put("message", "分配成功");
					}else{
						json.put("success", true);
						json.put("message", "班长分配成功");
					}
					
				}else{
					if(b>0){
						json.put("success", true);
						json.put("message", "队员分配成功");
					}else{
						json.put("success", false);
						json.put("message", "分配人员失败");
					}
				}
			}else{
				json.put("success", false);
				json.put("message", "项目id不正确");
			}
			
		
		return json;
	}

}
