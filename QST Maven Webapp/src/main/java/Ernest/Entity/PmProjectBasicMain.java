package Ernest.Entity;




/**
 * 基础配置主表实体类
 * @author Ernest
 *
 */
public class PmProjectBasicMain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String fid;
	private String fno;
	private String fbasicType;
	private String fbasicCode;
	private String fbasicState;
	private String fbz;
	private String fprojectId;
	private String ftypeId;

	// Constructors

	/** default constructor */
	public PmProjectBasicMain() {
	}

	/** minimal constructor */
	public PmProjectBasicMain(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public PmProjectBasicMain(String fid, String fno, String fbasicType, String fbasicCode, String fbasicState,
			String fbz, String fprojectId, String ftypeId) {
		this.fid = fid;
		this.fno = fno;
		this.fbasicType = fbasicType;
		this.fbasicCode = fbasicCode;
		this.fbasicState = fbasicState;
		this.fbz = fbz;
		this.fprojectId = fprojectId;
		this.ftypeId = ftypeId;
	}

	// Property accessors


	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFno() {
		return this.fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}


	public String getFbasicType() {
		return this.fbasicType;
	}

	public void setFbasicType(String fbasicType) {
		this.fbasicType = fbasicType;
	}


	public String getFbasicCode() {
		return this.fbasicCode;
	}

	public void setFbasicCode(String fbasicCode) {
		this.fbasicCode = fbasicCode;
	}


	public String getFbasicState() {
		return this.fbasicState;
	}

	public void setFbasicState(String fbasicState) {
		this.fbasicState = fbasicState;
	}


	public String getFbz() {
		return this.fbz;
	}

	public void setFbz(String fbz) {
		this.fbz = fbz;
	}


	public String getFprojectId() {
		return this.fprojectId;
	}

	public void setFprojectId(String fprojectId) {
		this.fprojectId = fprojectId;
	}


	public String getFtypeId() {
		return this.ftypeId;
	}

	public void setFtypeId(String ftypeId) {
		this.ftypeId = ftypeId;
	}

	@Override
	public String toString() {
		return "PmProjectBasicMain [fid=" + fid + ", fno=" + fno + ", fbasicType=" + fbasicType + ", fbasicCode="
				+ fbasicCode + ", fbasicState=" + fbasicState + ", fbz=" + fbz + ", fprojectId=" + fprojectId
				+ ", ftypeId=" + ftypeId + "]";
	}

	
	
}