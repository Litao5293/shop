package demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//收藏表
@Entity
@Table(name="collect")
public class Collect {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer collectID;//id
	private Integer proID;//商品ID
	private Integer userID;//用户ID
	
	@ManyToOne
	@JoinColumn(name="proID",insertable=false,updatable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="userID",insertable=false,updatable=false)
	private Users users;

	public Integer getCollectID() {
		return collectID;
	}

	public void setCollectID(Integer collectID) {
		this.collectID = collectID;
	}

	public Integer getProID() {
		return proID;
	}

	public void setProID(Integer proID) {
		this.proID = proID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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
		return "Collect [collectID=" + collectID + ", proID=" + proID + ", userID=" + userID + ", product=" + product
				+ ", users=" + users + "]";
	}
	
}
