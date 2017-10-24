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
	//查询所有商品信息 显示购物车列表
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
	
	//将商品添加到购物车
	@RequestMapping("/addproduct")
	public void addproduct(Product product){
		//得到商品ID
		Integer pid=product.getProID();
		
		if(pid==0){
			//商品不存在  就加入购物车
			service.add(product);
		}else{
			//存在  增加数量
			product.setProcount(product.getProcount()+product.getProcount());
		}
	
	}
	//删除购物车中的物品
    @RequestMapping("/delete")
	public Object delete(Integer shopcarid	){
    	System.out.println("shanchu"+shopcarid);
    	Shopcar oldshopcar=(Shopcar)service.load(Shopcar.class, shopcarid);
    	service.delete(oldshopcar);
    	return "redirect:/cart.html";
		//总计=总计-移除商品的价钱
		//total-=product.getSubtotal();
	}
	}

