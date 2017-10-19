package demo.bean;
//后台账号表



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminID;//id
	private String adminName;//管理账号
	private String pwd;//密码
	private String Permissions;//状态Y,N
	private Integer authority;//权限 超级1，普通2
	
	public Integer getAdminID() {
		return adminID;
	}
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPermissions() {
		return Permissions;
	}
	public void setPermissions(String permissions) {
		Permissions = permissions;
	}
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", pwd=" + pwd + ", Permissions="
				+ Permissions + ", authority=" + authority + "]";
	}
	
	
	
}
