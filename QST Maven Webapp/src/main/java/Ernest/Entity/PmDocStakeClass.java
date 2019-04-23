package Ernest.Entity;



/**
 * 项目图片配置实体类
 * @author Ernest
 *
 */
public class PmDocStakeClass implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fid;
	private String fpostId;
	private String fpostName;
	private String fprojectCode;
	private String fprjoectName;
	private String fparntClassId;
	private Integer delectStatus;
	private String fmd5;
	private String fcreateUserId;
	private String fcreateDateTime;
	private String fupdateDateTime;
	private String fupdateUserId;
	private String fstate;
	private String fmsterId;

	// Constructors

	/** default constructor */
	public PmDocStakeClass() {
	}

	/** minimal constructor */
	public PmDocStakeClass(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public PmDocStakeClass(String fid, String fpostId, String fpostName, String fprojectCode, String fprjoectName,
			String fparntClassId, Integer delectStatus, String fmd5, String fcreateUserId, String fcreateDateTime,
			String fupdateDateTime, String fupdateUserId, String fstate, String fmsterId) {
		this.fid = fid;
		this.fpostId = fpostId;
		this.fpostName = fpostName;
		this.fprojectCode = fprojectCode;
		this.fprjoectName = fprjoectName;
		this.fparntClassId = fparntClassId;
		this.delectStatus = delectStatus;
		this.fmd5 = fmd5;
		this.fcreateUserId = fcreateUserId;
		this.fcreateDateTime = fcreateDateTime;
		this.fupdateDateTime = fupdateDateTime;
		this.fupdateUserId = fupdateUserId;
		this.fstate = fstate;
		this.fmsterId = fmsterId;
	}

	

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}



	public String getFpostId() {
		return this.fpostId;
	}

	public void setFpostId(String fpostId) {
		this.fpostId = fpostId;
	}

	

	public String getFpostName() {
		return this.fpostName;
	}

	public void setFpostName(String fpostName) {
		this.fpostName = fpostName;
	}

	

	public String getFprojectCode() {
		return this.fprojectCode;
	}

	public void setFprojectCode(String fprojectCode) {
		this.fprojectCode = fprojectCode;
	}



	public String getFprjoectName() {
		return this.fprjoectName;
	}

	public void setFprjoectName(String fprjoectName) {
		this.fprjoectName = fprjoectName;
	}

	

	public String getFparntClassId() {
		return this.fparntClassId;
	}

	public void setFparntClassId(String fparntClassId) {
		this.fparntClassId = fparntClassId;
	}



	public Integer getDelectStatus() {
		return this.delectStatus;
	}

	public void setDelectStatus(Integer delectStatus) {
		this.delectStatus = delectStatus;
	}


	public String getFmd5() {
		return this.fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}


	public String getFcreateUserId() {
		return this.fcreateUserId;
	}

	public void setFcreateUserId(String fcreateUserId) {
		this.fcreateUserId = fcreateUserId;
	}


	public String getFcreateDateTime() {
		return this.fcreateDateTime;
	}

	public void setFcreateDateTime(String fcreateDateTime) {
		this.fcreateDateTime = fcreateDateTime;
	}


	public String getFupdateDateTime() {
		return this.fupdateDateTime;
	}

	public void setFupdateDateTime(String fupdateDateTime) {
		this.fupdateDateTime = fupdateDateTime;
	}


	public String getFupdateUserId() {
		return this.fupdateUserId;
	}

	public void setFupdateUserId(String fupdateUserId) {
		this.fupdateUserId = fupdateUserId;
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

	@Override
	public String toString() {
		return "PmDocStakeClass [fid=" + fid + ", fpostId=" + fpostId + ", fpostName=" + fpostName + ", fprojectCode="
				+ fprojectCode + ", fprjoectName=" + fprjoectName + ", fparntClassId=" + fparntClassId
				+ ", delectStatus=" + delectStatus + ", fmd5=" + fmd5 + ", fcreateUserId=" + fcreateUserId
				+ ", fcreateDateTime=" + fcreateDateTime + ", fupdateDateTime=" + fupdateDateTime + ", fupdateUserId="
				+ fupdateUserId + ", fstate=" + fstate + ", fmsterId=" + fmsterId + "]";
	}

	
	
}