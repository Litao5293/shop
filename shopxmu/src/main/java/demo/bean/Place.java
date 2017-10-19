package demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//收货地址表
@Entity
@Table(name="place")
public class Place {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;//id
	private Integer userid;//用户id
	private String name;//收货人名字
	private String tel;//收货人电话
	private String address;//收货人地址
	private String pot;//状态 Y/N Y默认收货地址
	
	@ManyToOne
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users users;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPot() {
		return pot;
	}

	public void setPot(String pot) {
		this.pot = pot;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Place [pid=" + pid + ", userid=" + userid + ", name=" + name + ", tel=" + tel + ", address=" + address
				+ ", pot=" + pot + ", users=" + users + "]";
	}
	
}
