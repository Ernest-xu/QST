package Ernest.Entity;

import java.util.Date;

/**
 * PmProjectProjectInformationtable entity. @author MyEclipse Persistence Tools
 */

public class InformationTable implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fid;
	private String fcreateOrgId;
	private String fcreateOrgname;
	private String fcreateOrgCode;
	private String fcreateDepId;
	private String fcreateDepName;
	private String fcreateDepCode;
	private String fcreatePosId;
	private String fcreatePosName;
	private String fcreatePosCode;
	private String fcreatePsmname;
	private String fcreatePsmId;
	private Float fcubeSum;
	private Float ftonnageSum;
	private Float fspanSum;
	private String gongxuChange;
	private String fcreatePsmCode;
	private String fcreateDateTime;
	private String fupdatePsmName;
	private String fupdateDateTime;
	private String fmd5;
	private String fprojectCode;
	private String fwrtieName;
	private String fwriteId;
	private String fno;
	private String fprjoectName;
	private String fprojectQuanName;
	private String fprojectType;
	private String fprojectAddress;
	private String flongitude;
	private String flatitude;
	private String fprojectVoltage;
	private String fprojectMessage;
	private String fprojectTelephone;
	private String fprojectState;
	private String fproSuperAdminNa;
	private String fproSuperAdminId;
	private String fwriteCode;
	private Date fwrtietime;
	private Date fstateTime;
	private Date fendTime;
	private String fstate;
	private String fmsterId;
	private String fsvgzs;
	private String fsvgqd;
	private String fxmbry;
	private String fbs;
	private String fqdgeshu;
	private String fzhuangshu;
	private String fsgbz;
	private String fpeolistName;
	private String fpeolistId;
	private String fpeolistMd5;


	public InformationTable() {
	}

	public InformationTable(String fid) {
		this.fid = fid;
	}

	public InformationTable(String fid, String fcreateOrgId, String fcreateOrgname,
			String fcreateOrgCode, String fcreateDepId, String fcreateDepName, String fcreateDepCode,
			String fcreatePosId, String fcreatePosName, String fcreatePosCode, String fcreatePsmname,
			String fcreatePsmId, Float fcubeSum, Float ftonnageSum, Float fspanSum, String gongxuChange,
			String fcreatePsmCode, String fcreateDateTime, String fupdatePsmName, String fupdateDateTime, String fmd5,
			String fprojectCode, String fwrtieName, String fwriteId, String fno, String fprjoectName,
			String fprojectQuanName, String fprojectType, String fprojectAddress, String flongitude, String flatitude,
			String fprojectVoltage, String fprojectMessage, String fprojectTelephone, String fprojectState,
			String fproSuperAdminNa, String fproSuperAdminId, String fwriteCode, Date fwrtietime, Date fstateTime,
			Date fendTime, String fstate, String fmsterId, String fsvgzs, String fsvgqd, String fxmbry, String fbs,
			String fqdgeshu, String fzhuangshu, String fsgbz, String fpeolistName, String fpeolistId,
			String fpeolistMd5) {
		this.fid = fid;
		this.fcreateOrgId = fcreateOrgId;
		this.fcreateOrgname = fcreateOrgname;
		this.fcreateOrgCode = fcreateOrgCode;
		this.fcreateDepId = fcreateDepId;
		this.fcreateDepName = fcreateDepName;
		this.fcreateDepCode = fcreateDepCode;
		this.fcreatePosId = fcreatePosId;
		this.fcreatePosName = fcreatePosName;
		this.fcreatePosCode = fcreatePosCode;
		this.fcreatePsmname = fcreatePsmname;
		this.fcreatePsmId = fcreatePsmId;
		this.fcubeSum = fcubeSum;
		this.ftonnageSum = ftonnageSum;
		this.fspanSum = fspanSum;
		this.gongxuChange = gongxuChange;
		this.fcreatePsmCode = fcreatePsmCode;
		this.fcreateDateTime = fcreateDateTime;
		this.fupdatePsmName = fupdatePsmName;
		this.fupdateDateTime = fupdateDateTime;
		this.fmd5 = fmd5;
		this.fprojectCode = fprojectCode;
		this.fwrtieName = fwrtieName;
		this.fwriteId = fwriteId;
		this.fno = fno;
		this.fprjoectName = fprjoectName;
		this.fprojectQuanName = fprojectQuanName;
		this.fprojectType = fprojectType;
		this.fprojectAddress = fprojectAddress;
		this.flongitude = flongitude;
		this.flatitude = flatitude;
		this.fprojectVoltage = fprojectVoltage;
		this.fprojectMessage = fprojectMessage;
		this.fprojectTelephone = fprojectTelephone;
		this.fprojectState = fprojectState;
		this.fproSuperAdminNa = fproSuperAdminNa;
		this.fproSuperAdminId = fproSuperAdminId;
		this.fwriteCode = fwriteCode;
		this.fwrtietime = fwrtietime;
		this.fstateTime = fstateTime;
		this.fendTime = fendTime;
		this.fstate = fstate;
		this.fmsterId = fmsterId;
		this.fsvgzs = fsvgzs;
		this.fsvgqd = fsvgqd;
		this.fxmbry = fxmbry;
		this.fbs = fbs;
		this.fqdgeshu = fqdgeshu;
		this.fzhuangshu = fzhuangshu;
		this.fsgbz = fsgbz;
		this.fpeolistName = fpeolistName;
		this.fpeolistId = fpeolistId;
		this.fpeolistMd5 = fpeolistMd5;
	}



	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFcreateOrgId() {
		return this.fcreateOrgId;
	}

	public void setFcreateOrgId(String fcreateOrgId) {
		this.fcreateOrgId = fcreateOrgId;
	}


	public String getFcreateOrgname() {
		return this.fcreateOrgname;
	}

	public void setFcreateOrgname(String fcreateOrgname) {
		this.fcreateOrgname = fcreateOrgname;
	}


	public String getFcreateOrgCode() {
		return this.fcreateOrgCode;
	}

	public void setFcreateOrgCode(String fcreateOrgCode) {
		this.fcreateOrgCode = fcreateOrgCode;
	}


	public String getFcreateDepId() {
		return this.fcreateDepId;
	}

	public void setFcreateDepId(String fcreateDepId) {
		this.fcreateDepId = fcreateDepId;
	}


	public String getFcreateDepName() {
		return this.fcreateDepName;
	}

	public void setFcreateDepName(String fcreateDepName) {
		this.fcreateDepName = fcreateDepName;
	}


	public String getFcreateDepCode() {
		return this.fcreateDepCode;
	}

	public void setFcreateDepCode(String fcreateDepCode) {
		this.fcreateDepCode = fcreateDepCode;
	}


	public String getFcreatePosId() {
		return this.fcreatePosId;
	}

	public void setFcreatePosId(String fcreatePosId) {
		this.fcreatePosId = fcreatePosId;
	}


	public String getFcreatePosName() {
		return this.fcreatePosName;
	}

	public void setFcreatePosName(String fcreatePosName) {
		this.fcreatePosName = fcreatePosName;
	}


	public String getFcreatePosCode() {
		return this.fcreatePosCode;
	}

	public void setFcreatePosCode(String fcreatePosCode) {
		this.fcreatePosCode = fcreatePosCode;
	}


	public String getFcreatePsmname() {
		return this.fcreatePsmname;
	}

	public void setFcreatePsmname(String fcreatePsmname) {
		this.fcreatePsmname = fcreatePsmname;
	}


	public String getFcreatePsmId() {
		return this.fcreatePsmId;
	}

	public void setFcreatePsmId(String fcreatePsmId) {
		this.fcreatePsmId = fcreatePsmId;
	}


	public Float getFcubeSum() {
		return this.fcubeSum;
	}

	public void setFcubeSum(Float fcubeSum) {
		this.fcubeSum = fcubeSum;
	}


	public Float getFtonnageSum() {
		return this.ftonnageSum;
	}

	public void setFtonnageSum(Float ftonnageSum) {
		this.ftonnageSum = ftonnageSum;
	}


	public Float getFspanSum() {
		return this.fspanSum;
	}

	public void setFspanSum(Float fspanSum) {
		this.fspanSum = fspanSum;
	}


	public String getGongxuChange() {
		return this.gongxuChange;
	}

	public void setGongxuChange(String gongxuChange) {
		this.gongxuChange = gongxuChange;
	}


	public String getFcreatePsmCode() {
		return this.fcreatePsmCode;
	}

	public void setFcreatePsmCode(String fcreatePsmCode) {
		this.fcreatePsmCode = fcreatePsmCode;
	}


	public String getFcreateDateTime() {
		return this.fcreateDateTime;
	}

	public void setFcreateDateTime(String fcreateDateTime) {
		this.fcreateDateTime = fcreateDateTime;
	}


	public String getFupdatePsmName() {
		return this.fupdatePsmName;
	}

	public void setFupdatePsmName(String fupdatePsmName) {
		this.fupdatePsmName = fupdatePsmName;
	}


	public String getFupdateDateTime() {
		return this.fupdateDateTime;
	}

	public void setFupdateDateTime(String fupdateDateTime) {
		this.fupdateDateTime = fupdateDateTime;
	}


	public String getFmd5() {
		return this.fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}


	public String getFprojectCode() {
		return this.fprojectCode;
	}

	public void setFprojectCode(String fprojectCode) {
		this.fprojectCode = fprojectCode;
	}


	public String getFwrtieName() {
		return this.fwrtieName;
	}

	public void setFwrtieName(String fwrtieName) {
		this.fwrtieName = fwrtieName;
	}


	public String getFwriteId() {
		return this.fwriteId;
	}

	public void setFwriteId(String fwriteId) {
		this.fwriteId = fwriteId;
	}


	public String getFno() {
		return this.fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}


	public String getFprjoectName() {
		return this.fprjoectName;
	}

	public void setFprjoectName(String fprjoectName) {
		this.fprjoectName = fprjoectName;
	}


	public String getFprojectQuanName() {
		return this.fprojectQuanName;
	}

	public void setFprojectQuanName(String fprojectQuanName) {
		this.fprojectQuanName = fprojectQuanName;
	}


	public String getFprojectType() {
		return this.fprojectType;
	}

	public void setFprojectType(String fprojectType) {
		this.fprojectType = fprojectType;
	}


	public String getFprojectAddress() {
		return this.fprojectAddress;
	}

	public void setFprojectAddress(String fprojectAddress) {
		this.fprojectAddress = fprojectAddress;
	}


	public String getFlongitude() {
		return this.flongitude;
	}

	public void setFlongitude(String flongitude) {
		this.flongitude = flongitude;
	}


	public String getFlatitude() {
		return this.flatitude;
	}

	public void setFlatitude(String flatitude) {
		this.flatitude = flatitude;
	}


	public String getFprojectVoltage() {
		return this.fprojectVoltage;
	}

	public void setFprojectVoltage(String fprojectVoltage) {
		this.fprojectVoltage = fprojectVoltage;
	}


	public String getFprojectMessage() {
		return this.fprojectMessage;
	}

	public void setFprojectMessage(String fprojectMessage) {
		this.fprojectMessage = fprojectMessage;
	}


	public String getFprojectTelephone() {
		return this.fprojectTelephone;
	}

	public void setFprojectTelephone(String fprojectTelephone) {
		this.fprojectTelephone = fprojectTelephone;
	}


	public String getFprojectState() {
		return this.fprojectState;
	}

	public void setFprojectState(String fprojectState) {
		this.fprojectState = fprojectState;
	}


	public String getFproSuperAdminNa() {
		return this.fproSuperAdminNa;
	}

	public void setFproSuperAdminNa(String fproSuperAdminNa) {
		this.fproSuperAdminNa = fproSuperAdminNa;
	}


	public String getFproSuperAdminId() {
		return this.fproSuperAdminId;
	}

	public void setFproSuperAdminId(String fproSuperAdminId) {
		this.fproSuperAdminId = fproSuperAdminId;
	}


	public String getFwriteCode() {
		return this.fwriteCode;
	}

	public void setFwriteCode(String fwriteCode) {
		this.fwriteCode = fwriteCode;
	}


	public Date getFwrtietime() {
		return this.fwrtietime;
	}

	public void setFwrtietime(Date fwrtietime) {
		this.fwrtietime = fwrtietime;
	}


	public Date getFstateTime() {
		return this.fstateTime;
	}

	public void setFstateTime(Date fstateTime) {
		this.fstateTime = fstateTime;
	}


	public Date getFendTime() {
		return this.fendTime;
	}

	public void setFendTime(Date fendTime) {
		this.fendTime = fendTime;
	}


	public String getFstate() {
		return this.fstate;
	}

	public void setFstate(String fstate) {
		this.fstate = fstate;
	}


	public String getFmsterId() {
		return this.fmsterId;
	}

	public void setFmsterId(String fmsterId) {
		this.fmsterId = fmsterId;
	}


	public String getFsvgzs() {
		return this.fsvgzs;
	}

	public void setFsvgzs(String fsvgzs) {
		this.fsvgzs = fsvgzs;
	}


	public String getFsvgqd() {
		return this.fsvgqd;
	}

	public void setFsvgqd(String fsvgqd) {
		this.fsvgqd = fsvgqd;
	}


	public String getFxmbry() {
		return this.fxmbry;
	}

	public void setFxmbry(String fxmbry) {
		this.fxmbry = fxmbry;
	}


	public String getFbs() {
		return this.fbs;
	}

	public void setFbs(String fbs) {
		this.fbs = fbs;
	}


	public String getFqdgeshu() {
		return this.fqdgeshu;
	}

	public void setFqdgeshu(String fqdgeshu) {
		this.fqdgeshu = fqdgeshu;
	}


	public String getFzhuangshu() {
		return this.fzhuangshu;
	}

	public void setFzhuangshu(String fzhuangshu) {
		this.fzhuangshu = fzhuangshu;
	}


	public String getFsgbz() {
		return this.fsgbz;
	}

	public void setFsgbz(String fsgbz) {
		this.fsgbz = fsgbz;
	}


	public String getFpeolistName() {
		return this.fpeolistName;
	}

	public void setFpeolistName(String fpeolistName) {
		this.fpeolistName = fpeolistName;
	}


	public String getFpeolistId() {
		return this.fpeolistId;
	}

	public void setFpeolistId(String fpeolistId) {
		this.fpeolistId = fpeolistId;
	}


	public String getFpeolistMd5() {
		return this.fpeolistMd5;
	}

	public void setFpeolistMd5(String fpeolistMd5) {
		this.fpeolistMd5 = fpeolistMd5;
	}

	
	@Override
	public String toString() {
		return "Informationtable [fid=" + fid + ", fcreateOrgId=" + fcreateOrgId + ", fcreateOrgname=" + fcreateOrgname
				+ ", fcreateOrgCode=" + fcreateOrgCode + ", fcreateDepId=" + fcreateDepId + ", fcreateDepName="
				+ fcreateDepName + ", fcreateDepCode=" + fcreateDepCode + ", fcreatePosId=" + fcreatePosId
				+ ", fcreatePosName=" + fcreatePosName + ", fcreatePosCode=" + fcreatePosCode + ", fcreatePsmname="
				+ fcreatePsmname + ", fcreatePsmId=" + fcreatePsmId + ", fcubeSum=" + fcubeSum + ", ftonnageSum="
				+ ftonnageSum + ", fspanSum=" + fspanSum + ", gongxuChange=" + gongxuChange + ", fcreatePsmCode="
				+ fcreatePsmCode + ", fcreateDateTime=" + fcreateDateTime + ", fupdatePsmName=" + fupdatePsmName
				+ ", fupdateDateTime=" + fupdateDateTime + ", fmd5=" + fmd5 + ", fprojectCode=" + fprojectCode
				+ ", fwrtieName=" + fwrtieName + ", fwriteId=" + fwriteId + ", fno=" + fno + ", fprjoectName="
				+ fprjoectName + ", fprojectQuanName=" + fprojectQuanName + ", fprojectType=" + fprojectType
				+ ", fprojectAddress=" + fprojectAddress + ", flongitude=" + flongitude + ", flatitude=" + flatitude
				+ ", fprojectVoltage=" + fprojectVoltage + ", fprojectMessage=" + fprojectMessage
				+ ", fprojectTelephone=" + fprojectTelephone + ", fprojectState=" + fprojectState
				+ ", fproSuperAdminNa=" + fproSuperAdminNa + ", fproSuperAdminId=" + fproSuperAdminId + ", fwriteCode="
				+ fwriteCode + ", fwrtietime=" + fwrtietime + ", fstateTime=" + fstateTime + ", fendTime=" + fendTime
				+ ", fstate=" + fstate + ", fmsterId=" + fmsterId + ", fsvgzs=" + fsvgzs + ", fsvgqd=" + fsvgqd
				+ ", fxmbry=" + fxmbry + ", fbs=" + fbs + ", fqdgeshu=" + fqdgeshu + ", fzhuangshu=" + fzhuangshu
				+ ", fsgbz=" + fsgbz + ", fpeolistName=" + fpeolistName + ", fpeolistId=" + fpeolistId
				+ ", fpeolistMd5=" + fpeolistMd5 + "]";
	}

	
	
	
}