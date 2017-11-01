package demo.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Product;
import demo.bean.Shopcar;
import demo.bean.Users;
import demo.service.BeanService;

@Controller
@RequestMapping("/shopcar")
public class ShopcarControllerZsx {
	@Autowired
     private BeanService service;
	//��ѯ������Ʒ��Ϣ ��ʾ���ﳵ�б�
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpSession session){
		 Integer Id =(Integer)session.getAttribute("userID");
		 return service.find("select p from Shopcar p  where p.userid="+Id+"", null);
	
	} 
	
	//����Ʒ��ӵ����ﳵ
	@RequestMapping("/addcar")
	public String addcar(Integer proid,HttpSession session){
		//��ӹ��ﳵ ��Ҫ�õ���ƷID �� �û�ID
		//�õ��û�ID 
		Integer userid=(Integer)session.getAttribute("userID");
		List list=new ArrayList();
		list.add(proid);
		list.add(userid);
		
		List s=service.find("from Shopcar s where s.proid=? and s.userid=? ", list.toArray());
		System.out.println("333"+s);
		if(s.isEmpty()){
			//��Ʒ������  ���빺�ﳵ
			Users users=(Users)service.load(Users.class, userid);
			Product product=(Product)service.load(Product.class, proid);
			Shopcar shopcar=new Shopcar();
			shopcar.setPrice(product.getPrice());
			shopcar.setCount(1);
			shopcar.setDiscount(product.getDiscount());
			shopcar.setProid(proid);
			shopcar.setUserid(userid);
			shopcar.setCreatetime(new Date());
			service.add(shopcar);
		}
	return "ok";
	}
	//ɾ�����ﳵ�е���Ʒ
    @RequestMapping("/delete")
	public Object delete(Integer shopcarid	){
    	System.out.println("shanchu"+shopcarid);
    	Shopcar oldshopcar=(Shopcar)service.load(Shopcar.class, shopcarid);
    	service.delete(oldshopcar);
    	return "redirect:/cart.html";
		//�ܼ�=�ܼ�-�Ƴ���Ʒ�ļ�Ǯ
		//total-=product.getSubtotal();
	}
    //�޸���Ʒ����
    @RequestMapping("/updateshu")
    public  void updateshu(Integer count,Integer shopcarid){
    	System.out.println("�޸�"+count);
    	Shopcar shopcar=(Shopcar)service.load(Shopcar.class, shopcarid);
    	shopcar.setCount(count);
    	service.update(shopcar);		
    }
    
    
	}

