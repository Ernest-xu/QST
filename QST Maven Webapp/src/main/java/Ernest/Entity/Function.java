package Ernest.Entity;



public class Function {
private Integer id;
private String url;
private String icon;
private String name;
//private Integer order;用id表示排序
private String type;

//public String getId() {
//	return id;
//}
//public void setId(String id) {
//	this.id = id;
//}


public String getUrl() {
	return url;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public void setUrl(String url) {
	this.url = url;
}
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
//public Integer getOrder() {
//	return order;
//}
//public void setOrder(Integer order) {
//	this.order = order;
//}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "Function [id=" + id + ", url=" + url + ", icon=" + icon + ", name=" + name + ", type=" + type + "]";
}




}
