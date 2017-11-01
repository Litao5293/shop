package demo.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//订单信息表
@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderID;//订单id
	private String onumber;//订单编号 (使用订单时间+类别ID+商品ID+账号)
	private String tag;//订单状态
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date time;//下单时间
	private String payment;//支付方式
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date totime;//收货时间
	private Float price;//购买时的原价
	private Float discount;//购买时的折扣
	private Integer count;//购买的数量
	private Integer ProID;//商品id
	private Integer userid;//用户id
	private Integer pid;//收货地址id
	@ManyToOne
	@JoinColumn(name="ProID",insertable=false,updatable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users users;
	
	@OneToMany(mappedBy="orders",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Evaluate> evaluates = new HashSet<Evaluate>();
	
	
	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Date getTotime() {
		return totime;
	}
	public void setTotime(Date totime) {
		this.totime = totime;
	}
	
	public Integer getProID() {
		return ProID;
	}
	public void setProID(Integer proID) {
		ProID = proID;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", onumber=" + onumber + ", tag=" + tag + ", time=" + time + ", payment="
				+ payment + ", totime=" + totime + ", price=" + price + ", discount=" + discount + ", count=" + count
				+ ", ProID=" + ProID + ", userid=" + userid + ", pid=" + pid + ", product=" + product + ", users="
				+ users + ", evaluates=" + evaluates + "]";
	}
	
	
	
	
}
