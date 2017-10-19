package demo.bean;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//购物车
@Entity
@Table(name="shopcar")
public class Shopcar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shopcarID;
	private Integer proid;//商品ID
	private Integer userid;//用户ID
	private Float price;//原价
	private Float discount;//折扣
	private Integer count;//数量
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createtime;//添加时间
	
	@ManyToOne
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private Users users;
	
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
		return "Shopcar [proid=" + proid + ", userid=" + userid + ", price=" + price + ", discount=" + discount
				+ ", count=" + count + ", createtime=" + createtime + ", product=" + product + ", users=" + users + "]";
	}
	
}
