package Ernest.Entity;



/**
 * 基础岗位实体类
 * @author Ernest
 *
 */
public class PmProjectBasciPostset implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fid;
	private String fno;
	private String fpostName;
	private String fpostCode;
	private String fpostState;
	private String fpostType;
	private String fpostXlb;

	// Constructors

	/** default constructor */
	public PmProjectBasciPostset() {
	}

	/** minimal constructor */
	public PmProjectBasciPostset(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public PmProjectBasciPostset(String fid, String fno, String fpostName, String fpostCode, String fpostState,
			String fpostType, String fpostXlb) {
		this.fid = fid;
		this.fno = fno;
		this.fpostName = fpostName;
		this.fpostCode = fpostCode;
		this.fpostState = fpostState;
		this.fpostType = fpostType;
		this.fpostXlb = fpostXlb;
	}

	

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


	public String getFpostName() {
		return this.fpostName;
	}

	public void setFpostName(String fpostName) {
		this.fpostName = fpostName;
	}


	public String getFpostCode() {
		return this.fpostCode;
	}

	public void setFpostCode(String fpostCode) {
		this.fpostCode = fpostCode;
	}


	public String getFpostState() {
		return this.fpostState;
	}

	public void setFpostState(String fpostState) {
		this.fpostState = fpostState;
	}


	public String getFpostType() {
		return this.fpostType;
	}

	public void setFpostType(String fpostType) {
		this.fpostType = fpostType;
	}


	public String getFpostXlb() {
		return this.fpostXlb;
	}

	public void setFpostXlb(String fpostXlb) {
		this.fpostXlb = fpostXlb;
	}

	@Override
	public String toString() {
		return "PmProjectBasciPostset [fid=" + fid + ", fno=" + fno + ", fpostName=" + fpostName + ", fpostCode="
				+ fpostCode + ", fpostState=" + fpostState + ", fpostType=" + fpostType + ", fpostXlb=" + fpostXlb
				+ "]";
	}

	
	
	
}