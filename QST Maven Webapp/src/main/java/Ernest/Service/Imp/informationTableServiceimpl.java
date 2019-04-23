/**
 * 
 */
package Ernest.Service.Imp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import Ernest.Dao.informationTableDaoI;
import Ernest.Entity.InformationTable;
import Ernest.Service.informationTableServiceI;
import Ernest.until.RecursiveHierarchy;

/**
 * @author Ernest
 *
 */
@Service
public class informationTableServiceimpl implements informationTableServiceI {
	private static final Logger logger = Logger.getLogger(informationTableServiceimpl.class);
	@Autowired
	private informationTableDaoI informationTableDao;
	
	@Override
	public JSONObject findMainList(String writeId) {
		JSONObject json = new JSONObject();
		List<InformationTable> listTable = informationTableDao.findList(writeId);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		String newID = UUID.randomUUID().toString();
		newID = newID.replace("-", "");
		Map<String, Object> parentMap = new HashMap<String, Object>();
		parentMap.put("sID", newID);
		parentMap.put("sName", "项目组织");
		parentMap.put("sParentID",null);
		parentMap.put("sMd5Str", "");
		list2.add(parentMap);
		for(InformationTable Information : listTable){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID", Information.getFid());
			map.put("sName", Information.getFprjoectName());
			map.put("fProjectQuanName", Information.getFprojectQuanName());
			map.put("sParentID", newID);
			map.put("sMd5Str", Information.getFmd5());
			list2.add(map);
		}
		Map<String, String> map1= new HashMap<String, String>();
		map1.put("id", "sID");
		map1.put("label", "sName");
		map1.put("fProjectQuanName", "fProjectQuanName");
		map1.put("sParentID", "sParentID");
		map1.put("sMd5Str", "sMd5Str");
		Map<String, String> Parentmap= new HashMap<String, String>();
		Parentmap.put("sParentID", "id");
		list = RecursiveHierarchy.getChildren(list2, map1, Parentmap, 1, 2, null);
		
		if(list2!=null ){
			json.put("list", list);
			json.put("success", true);
		}else{
			json.put("success", false);
		}
		
		return json;
	}

	
	@Override
	public List<InformationTable> findById(String fID) {
		List<InformationTable> list=  informationTableDao.findById(fID);
		return list;
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.informationTableServiceI#findProjectGrid(java.lang.String)
	 */
	@Override
	public JSONObject findProjectGrid(String writeId) {
		JSONObject json = new JSONObject();
		List<InformationTable> listTable = informationTableDao.findList(writeId);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		String newID = UUID.randomUUID().toString();
		newID = newID.replace("-", "");
		Map<String, Object> parentMap = new HashMap<String, Object>();
		parentMap.put("sID", newID);
		parentMap.put("sName", "项目管理");
		parentMap.put("sParentID",null);
		parentMap.put("sMd5Str", "");
		list2.add(parentMap);
		for(InformationTable Information : listTable){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID", Information.getFid());
			map.put("sName", Information.getFprjoectName());
			map.put("fProjectQuanName", Information.getFprojectQuanName());
			map.put("sParentID", newID);
			map.put("sMd5Str", Information.getFmd5());
			list2.add(map);
		}
		Map<String, String> map1= new HashMap<String, String>();
		map1.put("id", "sID");
		map1.put("label", "sName");
		map1.put("fProjectQuanName", "fProjectQuanName");
		map1.put("sParentID", "sParentID");
		map1.put("sMd5Str", "sMd5Str");
		Map<String, String> Parentmap= new HashMap<String, String>();
		Parentmap.put("sParentID", "id");
		list = RecursiveHierarchy.getChildren(list2, map1, Parentmap, 1, 2, null);
		
		if(list2!=null ){
			json.put("list", list);
			json.put("success", true);
		}else{
			json.put("success", false);
		}
		
		return json;
	}


	
	@Override
	public JSONObject findProjectNote(String fID) {
		JSONObject json = new JSONObject();
		List<InformationTable> list = informationTableDao.findById(fID);
		int number = 0;
		if(!list.isEmpty()){
			InformationTable informationTable = new InformationTable();
			informationTable = list.get(0);
			json.put("fID", informationTable.getFid());
			json.put("fPrjoectName", informationTable.getFprjoectName());
			json.put("fProjectQuanName", informationTable.getFprojectQuanName());
			json.put("fProjectAddress", informationTable.getFprojectAddress());
			json.put("fProjectMessage", informationTable.getFprojectMessage());
			json.put("fStateTime", informationTable.getFstateTime());
			json.put("fEndTime", informationTable.getFendTime());
			number++;
		}
		if(number>0){
			json.put("success", true);
			json.put("message", "成功");
		}else{
			json.put("success", false);
			json.put("message", "失败");
		}
		
		return json;
	}


	
	@Override
	public JSONObject updateProjectDetail(String fID, String fPrjoectName, String fProjectQuanName,
			String fProjectAddress, String fProjectMessage, String fStateTime, String fEndTime) {
		JSONObject json = new JSONObject();
		int number =0;
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		InformationTable informationTable = new InformationTable();
		informationTable.setFid(fID);
		informationTable.setFprjoectName(fPrjoectName);
		informationTable.setFprojectAddress(fProjectAddress);
		informationTable.setFprojectQuanName(fProjectQuanName);
		informationTable.setFprojectMessage(fProjectMessage);
		try {
			informationTable.setFstateTime(sdf.parse(fStateTime));
			informationTable.setFendTime(sdf.parse(fEndTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		number = informationTableDao.updateByMapId(informationTable);
		if(number>0){
			json.put("success", true);
			json.put("message", "成功");
		}else{
			json.put("success", false);
			json.put("message", "失败");
		}		
		return json;
	}


	
	@Override
	public int updateByMapId(InformationTable informationTable) {
		return informationTableDao.updateByMapId(informationTable);
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.informationTableServiceI#CreateProjectgx(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject CreateProjectgx(String UserID, String md5Str, String fProjectQuanName, String fProjectMessage,
			String fStateTime, String fEndTime, String fProjectAddress, String fPrjoectName) {
		JSONObject json = new JSONObject();
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String fWrtietime = df.format(new Date());//创建时间
		DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
		String fWrtietime1 = df1.format(new Date());//创建时间
		String s_fPrjoectName = fPrjoectName;//获取项目名称
		String s_fID = UUID.randomUUID().toString();
		String s_fProjectCode = UUID.randomUUID().toString();//获取项目编码
		
		
		
		
		return json;
	}

}
