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
	//查询所有商品信息 显示购物车列表
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpSession session){
		 Integer Id =(Integer)session.getAttribute("userID");
		 return service.find("select p from Shopcar p  where p.userid="+Id+"", null);
	
	} 
	
	//将商品添加到购物车
	@RequestMapping("/addcar")
	public String addcar(Integer proid,HttpSession session){
		//添加购物车 需要得到商品ID 和 用户ID
		//得到用户ID 
		Integer userid=(Integer)session.getAttribute("userID");
		List list=new ArrayList();
		list.add(proid);
		list.add(userid);
		
		List s=service.find("from Shopcar s where s.proid=? and s.userid=? ", list.toArray());
		System.out.println("333"+s);
		if(s.isEmpty()){
			//商品不存在  加入购物车
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
    //修改商品数量
    @RequestMapping("/updateshu")
    public  void updateshu(Integer count,Integer shopcarid){
    	System.out.println("修改"+count);
    	Shopcar shopcar=(Shopcar)service.load(Shopcar.class, shopcarid);
    	shopcar.setCount(count);
    	service.update(shopcar);		
    }
    
    
	}

