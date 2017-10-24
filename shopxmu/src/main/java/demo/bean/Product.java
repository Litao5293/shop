package demo.bean;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

//��Ʒ������Ϣ��
@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer proID;//��ƷID
	private String proname;//��Ʒ����
	private String proImg;//��ƷͼƬ
	private Integer procount;//��Ʒ������0ʱ��ȱ�����¼ܣ�
	private Float price;//ԭ��
	private Float discount;//�ۿ� ������ʱ��10
	private String description;//��Ʒ����
	private double subtotal;//��ƷС��
	private Integer sortid;//���ID
	
	@ManyToOne
	@JoinColumn(name="sortid",insertable=false,updatable=false)
	private Sort sort;
	
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Shopcar> shopcars = new HashSet<Shopcar>();
	
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Collect> collects = new HashSet<Collect>();
	public double getSubtotal() {
		return  procount*(getDiscount()*getPrice());
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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
	public Integer getProID() {
		return proID;
	}
	public void setProID(Integer proID) {
		this.proID = proID;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public Integer getProcount() {
		return procount;
	}
	public void setProcount(Integer procount) {
		this.procount = procount;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSortid() {
		return sortid;
	}
	public void setSortid(Integer sortid) {
		this.sortid = sortid;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Product [proID=" + proID + ", proname=" + proname + ", proImg=" + proImg + ", procount=" + procount
				+ ", price=" + price + ", discount=" + discount + ", description=" + description + ", sortid=" + sortid
				+ ", sort=" + sort + "]";
	}
	
	
	
}
