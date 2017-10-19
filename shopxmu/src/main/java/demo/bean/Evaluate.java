package demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//��Ʒ���۱�
@Entity
@Table(name="evaluate")
public class Evaluate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer evaID;//id
	private Integer userID;//�û�ID
	private Integer orderId;//����id
	private String  evatext;//����
	private String evaImg;//ɹͼ
	private String evapro;//��Ʒ����
	private String evaexpress;//��������
	private String evaserve;//��������
	@ManyToOne
	@JoinColumn(name="userID",insertable=false,updatable=false)
	private Users users;
	
	@ManyToOne
	@JoinColumn(name="orderId",insertable=false,updatable=false)
	private Orders orders;
	
	public Integer getEvaID() {
		return evaID;
	}
	public void setEvaID(Integer evaID) {
		this.evaID = evaID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getEvatext() {
		return evatext;
	}
	public void setEvatext(String evatext) {
		this.evatext = evatext;
	}
	public String getEvaImg() {
		return evaImg;
	}
	public void setEvaImg(String evaImg) {
		this.evaImg = evaImg;
	}
	public String getEvapro() {
		return evapro;
	}
	public void setEvapro(String evapro) {
		this.evapro = evapro;
	}
	public String getEvaexpress() {
		return evaexpress;
	}
	public void setEvaexpress(String evaexpress) {
		this.evaexpress = evaexpress;
	}
	public String getEvaserve() {
		return evaserve;
	}
	public void setEvaserve(String evaserve) {
		this.evaserve = evaserve;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Evaluate [evaID=" + evaID + ", userID=" + userID + ", orderId=" + orderId + ", evatext=" + evatext
				+ ", evaImg=" + evaImg + ", evapro=" + evapro + ", evaexpress=" + evaexpress + ", evaserve=" + evaserve
				+ ", users=" + users + ", orders=" + orders + "]";
	}
	
	
}
