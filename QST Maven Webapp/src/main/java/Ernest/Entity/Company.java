package Ernest.Entity;



import java.util.List;

public class Company {

	private String id;
	private String name;
	private String system;
	private String password;
	private String phone;
	private List<Function> functions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Function> getFunctions() {
		return functions;
	}
	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", system=" + system + ", password=" + password + ", phone=" + phone + ", functions=" + functions + "]";
	}
	
	
}
