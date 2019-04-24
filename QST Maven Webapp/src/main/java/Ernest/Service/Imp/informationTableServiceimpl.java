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
import Ernest.Entity.BasicDetailGong;
import Ernest.Entity.BasicMainGong;
import Ernest.Entity.InformationTable;
import Ernest.Entity.Pkrenyuan;
import Ernest.Entity.PmProjectBasciPostset;
import Ernest.Entity.PmProjectBasicDetail;
import Ernest.Entity.PmProjectBasicMain;
import Ernest.Entity.PostsetbXm1;
import Ernest.Service.basicDetailGongServiceI;
import Ernest.Service.basicMainGongServiceI;
import Ernest.Service.informationTableServiceI;
import Ernest.Service.pkrenyuanServiceI;
import Ernest.Service.pmProjectBasciPostsetServiceI;
import Ernest.Service.pmProjectBasicDetailServiceI;
import Ernest.Service.pmProjectBasicMainServiceI;
import Ernest.Service.postinformationtabQuduanServiceI;
import Ernest.Service.postinformationtabServiceI;
import Ernest.Service.postsetbXm1ServiceI;
import Ernest.until.RecursiveHierarchy;
import Ernest.until.TimeUntil;

/**
 * @author Ernest
 *
 */
@Service
public class informationTableServiceimpl implements informationTableServiceI {
	private static final Logger logger = Logger.getLogger(informationTableServiceimpl.class);
	@Autowired
	private informationTableDaoI informationTableDao;
	@Autowired
	private pmProjectBasicMainServiceI pmProjectBasicMainService;
	@Autowired
	private pmProjectBasicDetailServiceI pmProjectBasicDetailService;
	@Autowired
	private pmProjectBasciPostsetServiceI pmProjectBasciPostsetService;
	@Autowired
	private basicMainGongServiceI basicMainGongService;
	@Autowired
	private basicDetailGongServiceI basicDetailGongService;
	@Autowired
	private postsetbXm1ServiceI postsetbXm1Service;
	@Autowired
	private pkrenyuanServiceI pkrenyuanService;
	@Autowired
	private postinformationtabQuduanServiceI postinformationtabQuduanService;
	@Autowired
	private postinformationtabServiceI postinformationtabService;
	@Override
	public JSONObject delectProjectgx(String fProjectID) {
		JSONObject json = new JSONObject();
		int number=0;
		number = informationTableDao.deleteById(fProjectID);
		basicMainGongService.deleteByfMasterId(fProjectID);
		basicDetailGongService.deleteByfMasterId(fProjectID);
		postinformationtabQuduanService.deleteByfMsterId(fProjectID);
		postinformationtabService.deleteByfProjectCode(fProjectID);
		postsetbXm1Service.deleteByfProjectId(fProjectID);
		pkrenyuanService.deleteByfProjectId(fProjectID);
		if(number>0){
			json.put("success", true);
			json.put("message", "删除成功");
		}else{
			json.put("success", false);
			json.put("message", "删除失败");
		}
		return json;
	}
	
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


	
	@Override
	public JSONObject CreateProjectgx(String UserID,String UserName, String md5Str, String fProjectQuanName, String fProjectMessage,
			String fStateTime, String fEndTime, String fProjectAddress, String fPrjoectName) throws ParseException {
		JSONObject json = new JSONObject();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String fWrtietime = df.format(new Date());//创建时间
		DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
		String fWrtietime1 = df1.format(new Date());//创建时间
		String s_fPrjoectName = fPrjoectName;//获取项目名称
		String s_fID = UUID.randomUUID().toString();
		String s_fProjectCode = UUID.randomUUID().toString();//获取项目编码
		
		InformationTable informationTable = new InformationTable();
		informationTable.setFid(s_fID);//项目ID
		informationTable.setFprojectCode(s_fProjectCode); //项目编码
		informationTable.setFprjoectName(s_fPrjoectName); //项目简称
		informationTable.setFwriteId(UserID); //人员ID
		informationTable.setFproSuperAdminId(UserID); //管理员ID
		informationTable.setFpeolistId(UserID); //授权人ID
		informationTable.setFwrtieName(UserName);//人员姓名
		informationTable.setFproSuperAdminNa(UserName);//管理员姓名
		informationTable.setFpeolistName(UserName);//授权人姓名
		informationTable.setFmd5( md5Str);//项目Md5
		informationTable.setFpeolistMd5(md5Str);//授权人md5
		informationTable.setGongxuChange("已插入工序");//工序鉴别
		informationTable.setFprojectQuanName( fProjectQuanName);//
		informationTable.setFprojectAddress( fProjectAddress);//
		informationTable.setFprojectMessage(fProjectMessage);//
		if(!"".equals(fWrtietime1)){
			informationTable.setFwrtietime(TimeUntil.DateStringtoDate(fWrtietime1));
		}
		if(!"".equals(fStateTime)){
			informationTable.setFstateTime(TimeUntil.DateStringtoDate(fStateTime));//
		}
		if(!"".equals(fEndTime)){
			informationTable.setFendTime( TimeUntil.DateStringtoDate(fEndTime));//
		}
		int savenumber = 0;
		savenumber = informationTableDao.save(informationTable);
		//插入项目基础主表信息
		if(savenumber>0){
//		logger.info("savenumber:"+savenumber+",fID:"+s_fID);
//		if(false){
			List<PmProjectBasicMain> PPBMlist = new ArrayList<PmProjectBasicMain>();
			List<BasicMainGong> BMGlist = new ArrayList<BasicMainGong>();
			List<BasicDetailGong> BDGlist = new ArrayList<BasicDetailGong>();
			List<PostsetbXm1> PX1list = new ArrayList<PostsetbXm1>();
			PPBMlist = pmProjectBasicMainService.findAll();
			for(PmProjectBasicMain pmProjectBasicMain:PPBMlist){
				Map<String, Object> insertMain= new HashMap<String, Object>();
				String new_uuid = UUID.randomUUID().toString();//获取UUID并转化为String对象s
//				logger.info("pm_project_basic_main_gong:" + new_uuid);
				String rt_fID = pmProjectBasicMain.getFid();//主键
				String rt_fBasicType = pmProjectBasicMain.getFbasicType();//类别
				String rt_fBasicCode = pmProjectBasicMain.getFbasicCode();//类别编码
				String rt_fBz = pmProjectBasicMain.getFbz();//备注二次鉴别
				BasicMainGong basicMainGong = new BasicMainGong();
				basicMainGong.setFid(new_uuid);
				basicMainGong.setFmasterId(s_fID);			
				basicMainGong.setFprojectName(s_fPrjoectName);
				basicMainGong.setFprojectCode(s_fProjectCode);
				basicMainGong.setFgxfId(rt_fID);
				basicMainGong.setFbz(rt_fBz);
				basicMainGong.setFbasicType(rt_fBasicType);
				basicMainGong.setFbasicCode(rt_fBasicCode);
//				logger.info(basicMainGong.toString());
				BMGlist.add(basicMainGong);
			}
			if(!BMGlist.isEmpty()){
				int BMGnum = basicMainGongService.batchSaves(BMGlist);
//				logger.info("BMGnum:"+BMGnum);
			}
			//插入项目的基础从表信息
			List<PmProjectBasicDetail> PPBDlist = new ArrayList<PmProjectBasicDetail>();
			 PPBDlist = pmProjectBasicDetailService.findAll();
			for(PmProjectBasicDetail pmProjectBasicDetail:PPBDlist){
				String new_uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象  
				String rt_fID = pmProjectBasicDetail.getFid();//主键
				String rt_fNo = pmProjectBasicDetail.getFno();//编号
				String rt_fBasicType = pmProjectBasicDetail.getFbasicType();//类别 
				String rt_fBasicName = pmProjectBasicDetail.getFbasicName();//类别名称
				String rt_fBasicCode = pmProjectBasicDetail.getFbasicCode();//类别编码
				String rt_fBz = pmProjectBasicDetail.getFbz();//备注
				String rt_fMasterID = pmProjectBasicDetail.getFmasterId();//类别外键
				String rt_fOnlyOne = pmProjectBasicDetail.getFonlyOne();//唯一工序
				BasicDetailGong basicDetailGong = new BasicDetailGong();
				basicDetailGong.setFid(new_uuid);;
				basicDetailGong.setFno(rt_fNo);
				basicDetailGong.setFbasicType(rt_fBasicType);
				basicDetailGong.setFbasicName(rt_fBasicName);
				basicDetailGong.setFbasicCode(rt_fBasicCode);
				basicDetailGong.setFbz(rt_fBz);
				basicDetailGong.setFmasterId(s_fID);
				basicDetailGong.setFgxid(rt_fMasterID);
				basicDetailGong.setFonlyOne(rt_fOnlyOne);
//				logger.info(basicDetailGong.toString());
				BDGlist.add(basicDetailGong);
			}
			if(!BDGlist.isEmpty()){
				int BDGnum = basicDetailGongService.batchSaves(BDGlist);
//				logger.info("BDGnum:"+BDGnum);
			}
			//插入项目相关的岗位
			List<PmProjectBasciPostset> PPBPlist = new ArrayList<PmProjectBasciPostset>();
			PPBPlist = pmProjectBasciPostsetService.findAll();
			for(PmProjectBasciPostset pmProjectBasciPostset: PPBPlist){
				String new_uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象  
				String rt_fNo = pmProjectBasciPostset.getFno();//编号
				String rt_fPostName = pmProjectBasciPostset.getFpostName();;//类别 
				String rt_fPostXlb = pmProjectBasciPostset.getFpostXlb();//类别 
				String rt_fPostType = pmProjectBasciPostset.getFpostType();//分包类别
				PostsetbXm1 postsetbXm1 = new  PostsetbXm1();
				postsetbXm1.setFid(new_uuid);
				postsetbXm1.setFno(rt_fNo);
				postsetbXm1.setFpostName(rt_fPostName);
				postsetbXm1.setFmasterId(s_fID);
				postsetbXm1.setFprojectName(s_fPrjoectName);
				postsetbXm1.setFprojectId(s_fID);
				postsetbXm1.setFprojectCode(s_fProjectCode);
				postsetbXm1.setFpostXlb(rt_fPostXlb);
				postsetbXm1.setFpostType(rt_fPostType);
				PX1list.add(postsetbXm1);
			}
			if(!PX1list.isEmpty()){
				postsetbXm1Service.batchSave(PX1list);
			}
			int fNo=0;
			fNo = pkrenyuanService.getNumByfWriteId(UserID);
			Pkrenyuan pkrenyuan = new Pkrenyuan();
			Map<String, Object> insertPx= new HashMap<String, Object>();
			String pk = UUID.randomUUID().toString();
			pkrenyuan.setFid(pk);
			pkrenyuan.setFno(fNo);
			pkrenyuan.setFmd5(md5Str);
			pkrenyuan.setFprojectName(s_fPrjoectName);
			pkrenyuan.setFprojectId(s_fID);
			pkrenyuan.setFprojectCode(s_fProjectCode);
			pkrenyuan.setFwriteName(UserName);
			pkrenyuan.setFwriteId(UserID);
			pkrenyuan.setFwriteMd5(md5Str);
			pkrenyuan.setFwriteTime(TimeUntil.StringToTimestamp(fWrtietime));
			pkrenyuanService.save(pkrenyuan);
			json.put("success",true);
			json.put("message", "成功");
		}else{
			json.put("success",false);
			json.put("message", "失败");
		}
		return json;
	}


	

}
