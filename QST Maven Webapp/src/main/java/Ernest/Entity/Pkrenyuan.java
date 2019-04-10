package Ernest.Entity;

import java.sql.Timestamp;


/**
 * PmProjectProjectPkrenyuan1 entity. @author MyEclipse Persistence Tools
 */

public class Pkrenyuan implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fid;//
	private String fmd5;//
	private String fprojectName;//
	private String fprojectCode;//
	private String fprojectId;//
	private String fwriteName;//
	private String fwriteCode;//
	private String fwriteId;//
	private Timestamp fwriteTime;//
	private Integer fno;
	private String fyqlb;
	private String fwriteType;
	private String fwriteJiB;
	private String fwriteGang;
	private String fwriteMd5;
	private String fmasterid;

	// Constructors

	/** default constructor */
	public Pkrenyuan() {
	}

	/** minimal constructor */
	public Pkrenyuan(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public Pkrenyuan(String fid, Integer fno, String fmd5, String fyqlb, String fprojectName,
			String fprojectCode, String fprojectId, String fwriteType, String fwriteJiB, String fwriteName,
			String fwriteGang, String fwriteCode, String fwriteId, String fwriteMd5, Timestamp fwriteTime,
			String fmasterid) {
		this.fid = fid;
		this.fno = fno;
		this.fmd5 = fmd5;
		this.fyqlb = fyqlb;
		this.fprojectName = fprojectName;
		this.fprojectCode = fprojectCode;
		this.fprojectId = fprojectId;
		this.fwriteType = fwriteType;
		this.fwriteJiB = fwriteJiB;
		this.fwriteName = fwriteName;
		this.fwriteGang = fwriteGang;
		this.fwriteCode = fwriteCode;
		this.fwriteId = fwriteId;
		this.fwriteMd5 = fwriteMd5;
		this.fwriteTime = fwriteTime;
		this.fmasterid = fmasterid;
	}

	// Property accessors


	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	public Integer getFno() {
		return this.fno;
	}

	public void setFno(Integer fno) {
		this.fno = fno;
	}


	public String getFmd5() {
		return this.fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}


	public String getFyqlb() {
		return this.fyqlb;
	}

	public void setFyqlb(String fyqlb) {
		this.fyqlb = fyqlb;
	}


	public String getFprojectName() {
		return this.fprojectName;
	}

	public void setFprojectName(String fprojectName) {
		this.fprojectName = fprojectName;
	}


	public String getFprojectCode() {
		return this.fprojectCode;
	}

	public void setFprojectCode(String fprojectCode) {
		this.fprojectCode = fprojectCode;
	}


	public String getFprojectId() {
		return this.fprojectId;
	}

	public void setFprojectId(String fprojectId) {
		this.fprojectId = fprojectId;
	}


	public String getFwriteType() {
		return this.fwriteType;
	}

	public void setFwriteType(String fwriteType) {
		this.fwriteType = fwriteType;
	}


	public String getFwriteJiB() {
		return this.fwriteJiB;
	}

	public void setFwriteJiB(String fwriteJiB) {
		this.fwriteJiB = fwriteJiB;
	}


	public String getFwriteName() {
		return this.fwriteName;
	}

	public void setFwriteName(String fwriteName) {
		this.fwriteName = fwriteName;
	}


	public String getFwriteGang() {
		return this.fwriteGang;
	}

	public void setFwriteGang(String fwriteGang) {
		this.fwriteGang = fwriteGang;
	}


	public String getFwriteCode() {
		return this.fwriteCode;
	}

	public void setFwriteCode(String fwriteCode) {
		this.fwriteCode = fwriteCode;
	}


	public String getFwriteId() {
		return this.fwriteId;
	}

	public void setFwriteId(String fwriteId) {
		this.fwriteId = fwriteId;
	}


	public String getFwriteMd5() {
		return this.fwriteMd5;
	}

	public void setFwriteMd5(String fwriteMd5) {
		this.fwriteMd5 = fwriteMd5;
	}


	public Timestamp getFwriteTime() {
		return this.fwriteTime;
	}

	public void setFwriteTime(Timestamp fwriteTime) {
		this.fwriteTime = fwriteTime;
	}


	public String getFmasterid() {
		return this.fmasterid;
	}

	public void setFmasterid(String fmasterid) {
		this.fmasterid = fmasterid;
	}

	@Override
	public String toString() {
		return "Pkrenyuan [fid=" + fid + ", fmd5=" + fmd5 + ", fprojectName=" + fprojectName + ", fprojectCode="
				+ fprojectCode + ", fprojectId=" + fprojectId + ", fwriteName=" + fwriteName + ", fwriteCode="
				+ fwriteCode + ", fwriteId=" + fwriteId + ", fwriteTime=" + fwriteTime + ", fno=" + fno + ", fyqlb="
				+ fyqlb + ", fwriteType=" + fwriteType + ", fwriteJiB=" + fwriteJiB + ", fwriteGang=" + fwriteGang
				+ ", fwriteMd5=" + fwriteMd5 + ", fmasterid=" + fmasterid + "]";
	}
	

}