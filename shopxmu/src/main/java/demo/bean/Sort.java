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

//商品类别表
@Entity
@Table(name="sort")
public class Sort {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sortID;//ID
	private String sortname;//类别名称
	private String sortImg;//类别图片
	
	@OneToMany(mappedBy="sort",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Product> products = new HashSet<Product>(); 
	
	@OneToMany(mappedBy="sort",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Orders> orders = new HashSet<Orders>(); 
	
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Integer getSortID() {
		return sortID;
	}
	public void setSortID(Integer sortID) {
		this.sortID = sortID;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getSortImg() {
		return sortImg;
	}
	public void setSortImg(String sortImg) {
		this.sortImg = sortImg;
	}
	@Override
	public String toString() {
		return "Sort [sortID=" + sortID + ", sortname=" + sortname + ", sortImg=" + sortImg + "]";
	}
	
	
}
