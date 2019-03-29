/**
 * 
 */
package Ernest.Service.Imp;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.saOppersonDaoI;
import Ernest.Entity.SaOporg;
import Ernest.Entity.SaOpperson;
import Ernest.Entity.SaOppersonOprole;
import Ernest.Entity.saOprole;
import Ernest.Service.saOporgServiceI;
import Ernest.Service.saOppersonOproleServiceI;
import Ernest.Service.saOppersonServiceI;
import Ernest.Service.saOproleServiceI;
import Ernest.until.Head;
import Ernest.until.ImageBase64Utils;
import Ernest.until.PasswordUtil;
import Ernest.until.Pinyin;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @author Ernest
 *
 */
@Service
public class saOppersonServiceimpl implements saOppersonServiceI {

	@Autowired
	private saOppersonDaoI saOppersonDao;
	@Autowired
	private saOporgServiceI saOporgService;
	@Autowired
	private saOproleServiceI saOproleService;
	@Autowired
	private saOppersonOproleServiceI saOppersonOproleService;
	private static final Logger logger = Logger.getLogger(saOppersonServiceimpl.class);
	@Override
	public JSONObject LoginBy(String name, String password) {
		JSONObject job = new JSONObject();
		JSONObject job1 = new JSONObject();
		SaOpperson sa = saOppersonDao.Login(name, password);
		boolean falge = true;
		String message = "";
		if(sa==null){
			falge=false;
			message="账号不存在";
		}
		if(falge&&"orgPer".equals(sa.getSaOporg().getSnodeKind())){
			job1.put("sName", sa.getSname());
			job1.put("sLoginName", sa.getSloginName());
			job1.put("sMd5Str", sa.getSmd5str());
			String sID = sa.getSid();
			SaOporg so = saOporgService.findAdmin(sa.getSmd5str(), "orgPer");
			String sID2 = so.getSid();
			if(!sID.equals(sID2)){
				sID=sID2;
			}
			job1.put("sID", sID);
			job1.put("sMainOrgID", sa.getSmainOrgId());
			job1.put("sDeptID", sa.getDeptId());
			job1.put("sChineseFirstPY", sa.getSchineseFirstPy());
			job1.put("sOrgKindID", sa.getSorgKindId());
			job1.put("fImage", sa.getFimage());
			job1.put("sJoinDate", sa.getSjoinDate());
			job1.put("sParentID", sa.getSaOporg().getSparentId());
			job1.put("sNodeKind", sa.getSaOporg().getSnodeKind());
			String readonly = sa.getOrgId();
			if(readonly==null||"".equals(readonly)||"null".equals(readonly)){
				readonly = "";
			}
			job1.put("readonly", readonly);
		}else{
			if(falge==false){
			}else{
				falge=false;
				message="您没有登录权限";
			}
			
		}
		if(falge){
			job.put("message", "登录成功");
			job.put("success", true);
		}else{
			job.put("message", message);
			job.put("success", falge);
		}
		job.put("data", job1);
		
		return job;
	}

	
	@Override
	public void save(SaOpperson saOpperson) {
		
		saOppersonDao.save(saOpperson);
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonServiceI#findPerson(java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject findPerson(String id, String md5Str) {
		JSONObject json = new JSONObject();
		if(id==null){
			json.put("Data", "[]");
			json.put("success", false);
			return json;
		}
		if(md5Str==null){
			json.put("Data", "[]");
			json.put("success", false);
			return json;
		}
		Map<String ,Object> orgMap = saOporgService.AllDepartment(md5Str);
		String sMainOrgName=(String) orgMap.get(id);
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		List<SaOpperson> list1 = saOppersonDao.findPersonList(id);
		List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list1.size();i++){
			List<Map<String, Object>> list3 =new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			SaOpperson saOpperson = new SaOpperson();
			saOpperson = list1.get(i);
			map.put("sID", saOpperson.getSaOporg().getSid());//人员ID
			map.put("sName", saOpperson.getSname());//真实姓名
			map.put("sIDCard",saOpperson.getSidcard());//人员身份证
			map.put("sLoginName", saOpperson.getSloginName());//登录名
			map.put("sPassword", saOpperson.getSpassword());//密码
			map.put("sWorkType", saOpperson.getSworkType());//工种
			map.put("sHealthStatus",saOpperson.getShealthStatus());//体检状况
			map.put("sSex", saOpperson.getSsex());//性别
			map.put("sTrainDate", saOpperson.getStrainDate());//培训日期
			map.put("sExamScore", saOpperson.getSexamScore());//考试分数
			map.put("sMobilePhone", saOpperson.getSmobilePhone());//手机号码
			map.put("sDeptID", saOpperson.getSdeptId());//部门ID
			map.put("sChineseFirstPY", saOpperson.getSchineseFirstPy());//姓名首字母
			map.put("sOrgKindID", saOpperson.getSorgKindId());//组织 性质，为了过滤人员用
			map.put("fImage", saOpperson.getFimage());//头像
			map.put("sMainOrgID",  id);//组
			map.put("sMainOrgName",  sMainOrgName);//组织ID
			map.put("orgNameID",  id);//父亲ID
			map.put("sNodeKind", saOpperson.getSaOporg().getSnodeKind());
			map.put("AdminPer", saOpperson.getSaOporg().getSnodeKind().equals("per")?"否":"是");
			list3=saOproleService.selectJobName(saOpperson.getSid());
			map.put("roleIds", list3);
			list.add(map);
		}
		if(list.isEmpty()){
			json.put("Data","[]");
			json.put("success", false);
		}else{
			json.put("Data",list);
			json.put("success", true);
			
		}
		return json;
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonServiceI#likeFind(java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject likeFind(String id,String md5Str, String name) {
		JSONObject json = new JSONObject();
		
		if(md5Str==null){
			json.put("Data", "[]");
			json.put("success", false);
			return json;
		}
		Map<String ,Object> orgMap = saOporgService.AllDepartment(md5Str);
		String sMainOrgName=(String) orgMap.get(id);
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		List<SaOpperson> list1 = saOppersonDao.likeFindPersonList(md5Str,id,name);
		List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list1.size();i++){
			List<Map<String, Object>> list3 =new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			SaOpperson saOpperson = new SaOpperson();
			saOpperson = list1.get(i);
			map.put("sID", saOpperson.getSaOporg().getSid());//人员ID
			map.put("sName", saOpperson.getSname());//真实姓名
			map.put("sIDCard",saOpperson.getSidcard());//人员身份证
			map.put("sLoginName", saOpperson.getSloginName());//登录名
			map.put("sPassword", saOpperson.getSpassword());//密码
			map.put("sWorkType", saOpperson.getSworkType());//工种
			map.put("sHealthStatus",saOpperson.getShealthStatus());//体检状况
			map.put("sSex", saOpperson.getSsex());//性别
			map.put("sTrainDate", saOpperson.getStrainDate());//培训日期
			map.put("sExamScore", saOpperson.getSexamScore());//考试分数
			map.put("sMobilePhone", saOpperson.getSmobilePhone());//手机号码
			map.put("sDeptID", saOpperson.getSdeptId());//部门ID
			map.put("sChineseFirstPY", saOpperson.getSchineseFirstPy());//姓名首字母
			map.put("sOrgKindID", saOpperson.getSorgKindId());//组织 性质，为了过滤人员用
			map.put("fImage", saOpperson.getFimage());//头像
			map.put("sMainOrgID",  id);//组
			map.put("sMainOrgName",  sMainOrgName);//组织ID
			map.put("orgNameID",  id);//父亲ID
			map.put("sNodeKind", saOpperson.getSaOporg().getSnodeKind());
			map.put("AdminPer", saOpperson.getSaOporg().getSnodeKind().equals("per")?"否":"是");
			list3=saOproleService.selectJobName(saOpperson.getSid());
			map.put("roleIds", list3);
			list.add(map);
		}
		if(list.isEmpty()){
			json.put("Data","[]");
			json.put("success", false);
		}else{
			json.put("Data",list);
			json.put("success", true);
			
		}
		return json;
	}


	@Override
	public int deleteByIds(List<String> list) {
		
		return saOppersonDao.deleteByIds(list);
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonServiceI#CreatePerson(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject CreatePerson(String realName, String account, String sex, String password, String md5Str,
			String roleIds, String orgId) {
		
		JSONObject json = new JSONObject();
		SaOporg so = saOporgService.findAdmin(md5Str, "orgPer");//获取系统管理员的目录
		if(orgId.equals(so.getSid())){
			json.put("success", false);
			json.put("message", "创建失败,系统管理员部门下不允许创建人员");
		}else{
			String sID = UUID.randomUUID().toString();
			String fImage = Head.getRandomImage();
			String sChineseFirstPY  = Pinyin.getPinYinHeadChar(realName);//姓名首字母
			SaOporg so1 = saOporgService.findTopByMd5(md5Str);//获取顶级目录
			logger.info("sID:"+sID);
			String md5Str3 = PasswordUtil.encrypt("分包管理员", "123456", PasswordUtil.getStaticSalt());
			String md5Str2 = PasswordUtil.encrypt("分包管理员", "123456", PasswordUtil.getStaticSalt());
			SaOpperson saOpperson = new SaOpperson();
			SaOporg saOporg = new SaOporg();
			saOporg.setSid(sID);
			saOporg.setSname(account);
			saOporg.setSfname(realName);
			saOporg.setSparentId(orgId);
			saOporg.setSmd5str(md5Str);
			saOporg.setSorgKindId("zb");
			saOporg.setSnodeKind("per");
			saOporg.setSmd5str2(md5Str2);
			saOporg.setSphone(account);
			saOporg.setFimage(fImage);
			saOpperson.setSid(sID);
			saOpperson.setSname(realName);
			saOpperson.setSmobilePhone(account);
			saOpperson.setSloginName(account);
			saOpperson.setSsex(sex);
			saOpperson.setSpassword(password);
			saOpperson.setSmd5str(md5Str);
			saOpperson.setSchineseFirstPy(sChineseFirstPY);
			saOpperson.setSdeptId(orgId);
			saOpperson.setSorgKindId("zb");
			saOpperson.setSmainOrgId(so.getSid());
			saOpperson.setFimage(fImage);
			List<SaOppersonOprole> list = new ArrayList<SaOppersonOprole>();
			if (roleIds != null && roleIds != "") {
				if(roleIds.indexOf(",")>-1){
					String[] roleIdArr = roleIds.split(",");
					for (String roleId : roleIdArr) {
						SaOppersonOprole saOppersonOprole = new SaOppersonOprole();
						String userRoleID = UUID.randomUUID().toString();
						logger.info("SaOppersonOprole:"+userRoleID);
						saOppersonOprole.setSid(userRoleID);
						saOppersonOprole.setUserId(sID);
						saOppersonOprole.setRoleId(roleId);
						saOppersonOprole.setSmd5str(md5Str3);
						list.add(saOppersonOprole);
					}
				}else{
					SaOppersonOprole saOppersonOprole = new SaOppersonOprole();
					String userRoleID = UUID.randomUUID().toString();
					logger.info("SaOppersonOprole:"+userRoleID);
					saOppersonOprole.setSid(userRoleID);
					saOppersonOprole.setUserId(sID);
					saOppersonOprole.setRoleId(roleIds);
					saOppersonOprole.setSmd5str(md5Str3);
					list.add(saOppersonOprole);
				}
			}
			int a = saOporgService.save(saOporg);
			int b = saOppersonOproleService.batchSaves(list);
			int c = saOppersonDao.save(saOpperson);
			logger.info("a:"+a+";b:"+b+";c:"+c);
			json.put("success", true);
			json.put("message", "创建成功");
		}
		
		return json;
	}


	/* (non-Javadoc)
	 * @see Ernest.Service.saOppersonServiceI#UpdatePerson(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONObject UpdatePerson(String fID, String realName, String account, String sex, String password,
			String md5Str, String roleIds, String orgId) {
		JSONObject json = new JSONObject();
		List<SaOpperson> list = saOppersonDao.findListById(fID);
		logger.info(fID);
		SaOporg so = saOporgService.findAdmin(md5Str, "orgPer");
		SaOpperson saOpperson = new SaOpperson();
		String message="";
		boolean newfalge = false;
		boolean oldfalge = true;
		boolean orgfalge = true;
		if(orgId!=null&&!"".equals(orgId)&&!"null".equals(orgId)){
			if(orgId.equals(so.getSparentId())){
				newfalge=true;
			}
		}else{
			newfalge=false;
			message="没有选择部门";
			oldfalge = false;
		}
		if(fID!=null&&!"".equals(fID)&&!"null".equals(fID)){
			if(fID.equals(so.getSid())){
				orgfalge=false;
				message="系统管理员不允许修改部门";
			}else{
				
			}
		}
		if(list.isEmpty()){
			json.put("success", false);
			json.put("message", "该人员不允许修改");
		}else{
			if(oldfalge){
				String sChineseFirstPY = Pinyin.getPinYinHeadChar(realName);
				SaOporg saOporg = new SaOporg();
				saOporg.setSid(fID);
				saOporg.setSfname(realName);
				saOporg.setSmd5str(md5Str);
				saOporg.setSorgKindId("zb");
					if(orgfalge){
						if(newfalge){//如果普通用户修改到管理员用户给创建一个只读管理员用户
							boolean mapfalge = saOporgService.findBysParentID2(fID).isEmpty();
							logger.info("mapfalge:"+mapfalge);
							if(mapfalge){
								String uuid = UUID.randomUUID().toString();
								logger.info("admin:"+uuid);
								SaOporg saOporg2 = new SaOporg();
								saOporg2.setSid(uuid);
								saOporg2.setSname(account);
								saOporg2.setSfname(realName);
								saOporg2.setSparentId(so.getSparentId());
								saOporg2.setSmd5str(md5Str);
								saOporg2.setSorgKindId("zb");
								saOporg2.setSnodeKind("per");
								saOporg2.setSparentId2(fID);
								saOporg2.setSphone(account);
								saOporgService.save(saOporg2);
							}else{
								message="该用户已是系统管理员";
							}
							saOporg.setSnodeKind("orgPer");
							saOpperson.setOrgId("zd");
						}else{
							if(!newfalge){//进入系统管理员就不能改部门了
								saOporg.setSparentId(orgId);
							}
//							saOporg.setSnodeKind("per");
						}
						
					}
				saOporg.setSphone(account);
				saOporgService.update(saOporg);
				
				saOpperson.setSid(fID);
				saOpperson.setSname(realName);
				saOpperson.setSmobilePhone(account);
				saOpperson.setSloginName(account);
				saOpperson.setSsex(sex);
				saOpperson.setSpassword(password);
				saOpperson.setSmd5str(md5Str);
				saOpperson.setSchineseFirstPy(sChineseFirstPY);
				saOpperson.setSdeptId(orgId);
				saOpperson.setSorgKindId("zb");
				int a = saOppersonDao.update(saOpperson);
				saOppersonOproleService.deletByUserId(fID);
				String md5Str3 = PasswordUtil.encrypt("分包管理员", "123456", PasswordUtil.getStaticSalt());
				List<SaOppersonOprole> list2 = new ArrayList<SaOppersonOprole>();
				if (roleIds != null && roleIds != "") {
					if(roleIds.indexOf(",")>-1){
						String[] roleIdArr = roleIds.split(",");
						for (String roleId : roleIdArr) {
							SaOppersonOprole saOppersonOprole = new SaOppersonOprole();
							String userRoleID = UUID.randomUUID().toString();
							logger.info("SaOppersonOprole:"+userRoleID);
							saOppersonOprole.setSid(userRoleID);
							saOppersonOprole.setUserId(fID);
							saOppersonOprole.setRoleId(roleId);
							saOppersonOprole.setSmd5str(md5Str3);
							list2.add(saOppersonOprole);
						}
					}else{
						SaOppersonOprole saOppersonOprole = new SaOppersonOprole();
						String userRoleID = UUID.randomUUID().toString();
						logger.info("SaOppersonOprole:"+userRoleID);
						saOppersonOprole.setSid(userRoleID);
						saOppersonOprole.setUserId(fID);
						saOppersonOprole.setRoleId(roleIds);
						saOppersonOprole.setSmd5str(md5Str3);
						list2.add(saOppersonOprole);
					}
				}
				saOppersonOproleService.batchSaves(list2);
				logger.info(a);
				if(a >0){
					json.put("success", true);
					json.put("message", "成功");
				}else{
					json.put("success", false);
					json.put("message", "失败"+message);
				}
			}else{
				json.put("success", false);
				json.put("message", message);
			}
		}
		
		return json;
	}


	
	@Override
	public JSONObject DeletePerson(String fIDs) {
		JSONObject json = new JSONObject();
		List<String> idlist = new ArrayList<String>();
		String fID = fIDs;
		String[] fIds; 
		if(fID==null||"".equals(fID)){
			fID="";
		}else{
			fIds=fID.split(",");
			for(int i=0;i<fIds.length;i++){
				idlist.add(fIds[i]);
			}
		}
		List<SaOporg> list = saOporgService.findByListId(idlist);
		for(SaOporg saOporg:list){
			SaOporg saOporg1 = new SaOporg();
			saOporg1.setSid(saOporg.getSparentId2());
			saOporg1.setSnodeKind("per");
//			logger.info(saOporg.getSparentId2());
			int a = saOporgService.update(saOporg1);
//			logger.info("update1:"+a);
			SaOpperson saOpperson = new SaOpperson();
			saOpperson.setSid(saOporg.getSparentId2());
			saOpperson.setOrgId("");
			int b = saOppersonDao.update(saOpperson);
//			logger.info("update2:"+b);
		}
//		logger.info(fID);
		int a = saOporgService.DeleteByListId(idlist);
		int b = saOppersonDao.deleteByIds(idlist);
		int c = saOppersonOproleService.deleteById(idlist);
		int d = saOporgService.DeleteParentID2(idlist);
//		logger.info("org:"+a+";person:"+b+";oo:"+c+";org:"+d);
		json.put("success", true);
		json.put("message", "成功");
		return json;
	}



	@Override
	public JSONObject ExportExcel(String id, String md5Str) {
		JSONObject json = new JSONObject();
		String fileName = ImageBase64Utils.getPath("excel")+"人员表.xls";
		List<SaOpperson> list = saOppersonDao.findPersonList(id);
		WritableWorkbook wwb = null;
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String src1 = Instruction(md5Str);
		try {
			File file=new File(fileName);
			if (!file.exists()) {
				
					file.createNewFile();
				
			}
			wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
            Label labelorgID= new Label(0, 0, "部门");//表示第
            Label labelroleName= new Label(1, 0, "职位");
            Label labelName= new Label(2, 0, "人员姓名");
            Label labelSex= new Label(3, 0, "性别");
            Label labelPhone  = new Label(4,0,"登录电话号");
            Label labelPassWord  = new Label(5,0,"密码");
            Label labelOrgKind  = new Label(6,0,"组织性质(zb或fb)");
            ws.addCell(labelorgID);
            ws.addCell(labelroleName);
            ws.addCell(labelName);
            ws.addCell(labelSex);
            ws.addCell(labelPhone);
            ws.addCell(labelPassWord);
            ws.addCell(labelOrgKind);
            int j=1;
            for(SaOpperson saOpperson:list){
    			List<Map<String, Object>> list3 = new ArrayList<Map<String,Object>>();
    			list3=saOproleService.selectJobName(saOpperson.getSid());
    			String roleIds = "";
    			for(int i=0;i<list3.size();i++){
    				if(i==0){
    					roleIds+=list3.get(i).get("sName");
    				}else{
    					roleIds+=","+list3.get(i).get("sName");
    				}
    			}
    			List<String> list2 = new ArrayList<String>();
    			list2.add(id);
    			List<SaOporg> list4 = saOporgService.findByListId(list2);
    			Label labelorgID_i= new Label(0, j, list4.get(0).getSfname());//组织职位
                Label labelroleName_i= new Label(1, j, roleIds);//角色
                Label labelName_i= new Label(2, j, saOpperson.getSname());//人员姓名
                Label labelSex_i= new Label(3, j, saOpperson.getSsex());//性别
                Label labelPhone_i  = new Label(4,j,saOpperson.getSloginName());//登录电话号
                Label labelPassWord_i  = new Label(5,j,saOpperson.getSpassword());//密码
                Label labelOrgKind_i  = new Label(6,j,saOpperson.getSorgKindId());//组织性质(zb或fb)
                ws.addCell(labelorgID_i);
                ws.addCell(labelroleName_i);
                ws.addCell(labelName_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelPhone_i);
                ws.addCell(labelPassWord_i);
                ws.addCell(labelOrgKind_i);
    			j++;
    		}
            wwb.write();
            wwb.close();
            json.put("src", ImageBase64Utils.getUrl("excel")+"人员表.xls");
			json.put("src1", src1);
			json.put("success", true);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		return json;
	}


	
	@Override
	public JSONObject ToLeadExcel(String excel, String md5Str) {
		return null;
	}


	 
	@Override
	public String Instruction(String md5) {
		String fileName = ImageBase64Utils.getPath("excel")+"说明表.xls";
		String src = ImageBase64Utils.getUrl("excel")+"说明表.xls";
		WritableWorkbook wwb = null;
		try {
			File file=new File(fileName);
			if (!file.exists()) {
					file.createNewFile();
			}
			wwb = Workbook.createWorkbook(file);
            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
            Label labelorgID= new Label(0, 0, "部门");//表示第
            Label labelroleName= new Label(1, 0, "职位");
            Label labelName= new Label(2, 0, "说明");
			ws.addCell(labelorgID);
			ws.addCell(labelroleName);
			ws.addCell(labelName);
			Label labelexplain1= new Label(2, 1, "部门：需要按照左侧部门列表对应的名称进行填写才可以导入到对应的部门中，否则会导入失败或在部门下找不到数据。建议直接复制名称，防止有空格不识别的问题");//表示第
	        Label labelexplain2= new Label(2, 2, "职位：需要按照左侧对应职位列表对应的名称进行填写才可以导入到对应的职位中，否则会导入失败或导致人员角色功能上存在问题.建议接复制名称，防止有空格不识别的问题");
	        Label labelexplain3= new Label(2, 3, "职位的格式：可以是单一职位，例：员工；也可以是多职位，例：员工,经理,技术员");
	        Label labelexplain4= new Label(2, 4, "建议：导入时建议先导出此表保证部门和职位展示的是最新的信息");
	        Label labelexplain5= new Label(2, 5, "请务必按照以上说明填写");
	        ws.addCell(labelexplain1);
	        ws.addCell(labelexplain2);
	        ws.addCell(labelexplain3);
	        ws.addCell(labelexplain4);
	        ws.addCell(labelexplain5);
	        List<saOprole> saOproleList = saOproleService.listSaOproles(md5);
	        int number=1;
			for(saOprole saoprole:saOproleList){
				String name = saoprole.getSname();//职名
				Label labelexplain6= new Label(1, number, name);
		        ws.addCell(labelexplain6);
				number++;
			}
			List<SaOporg> list = saOporgService.getAllDepartment(md5, "per");
			number=1;
			for(SaOporg saOporg:list){
				String name = saOporg.getSfname();//部门名称
				Label labelexplain7= new Label(0, number, name);
		        ws.addCell(labelexplain7);
				number++;
			}
			wwb.write();
			wwb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return src;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
