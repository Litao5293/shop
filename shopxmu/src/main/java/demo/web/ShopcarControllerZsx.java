package demo.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Product;
import demo.bean.Shopcar;
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
	
	
	private Double total;
	public double getTotal(){
		return total;
	}
	
	//����Ʒ��ӵ����ﳵ
	@RequestMapping("/addproduct")
	public void addproduct(Product product){
		//�õ���ƷID
		Integer pid=product.getProID();
		
		if(pid==0){
			//��Ʒ������  �ͼ��빺�ﳵ
			service.add(product);
		}else{
			//����  ��������
			product.setProcount(product.getProcount()+product.getProcount());
		}
	
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
	}

