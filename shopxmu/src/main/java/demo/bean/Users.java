package demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//前台用户信息表
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userID;//id
	private String username;//账号
	private String pwd;//密码
	private String realname;//真实姓名
	private String tel;//电话
	private String emaile;//邮箱
	private String userImg;//头像
	private String userrank;//用户等级
	
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Orders> orders = new HashSet<Orders>();
	
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Evaluate> evaluates = new HashSet<Evaluate>();
	
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Shopcar> shopcars = new HashSet<Shopcar>();
	
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Collect> collects = new HashSet<Collect>();
	
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Place> places = new HashSet<Place>();
	
	public Set<Place> getPlaces() {
		return places;
	}
	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	public Set<Collect> getCollects() {
		return collects;
	}
	public void setCollects(Set<Collect> collects) {
		this.collects = collects;
	}
	public Set<Shopcar> getShopcars() {
		return shopcars;
	}
	public void setShopcars(Set<Shopcar> shopcars) {
		this.shopcars = shopcars;
	}
	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmaile() {
		return emaile;
	}
	public void setEmaile(String emaile) {
		this.emaile = emaile;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserrank() {
		return userrank;
	}
	public void setUserrank(String userrank) {
		this.userrank = userrank;
	}
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", pwd=" + pwd + ", realname=" + realname
				+ ", tel=" + tel + ", emaile=" + emaile + ", userImg=" + userImg + ", userrank=" + userrank + "]";
	}
	
	
}
