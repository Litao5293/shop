package demolt.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Place;
import demo.bean.Users;
import demo.service.BeanService;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/urerlt")
public class UserController {
	@Autowired
	private BeanService service;
	
	@RequestMapping(value="/list")
	public String list(HttpSession session){//判断账号登录了没
		System.out.println("LT:验证");
		Integer userID = (Integer)session.getAttribute("userID");
		
		if(userID !=null && !userID.equals("")){//成功
			
			return "redirect:/user_lt/23.jsp";
		}else{//失败
			
			return  "redirect:/my.account.html";
		}
	}
	//加载账号信息，传入前台
	@RequestMapping(value="/tolist")
	public String tolist(HttpSession session,HttpServletResponse response,HttpServletRequest request){
		Integer userID = (Integer)session.getAttribute("userID");
		Users users = (Users)service.load(Users.class, userID);
		request.setAttribute("users", users);
		return "/user_lt/information";
	}
	
	@RequestMapping(value="/update")
	public String update(Users users,HttpSession session){//修改账号
		Integer userID =(Integer)session.getAttribute("userID");
		Users users2 = (Users)service.load(Users.class, userID);
		users.setPwd(users2.getPwd());
		users.setUserImg(users.getUserImg());
		users.setUserrank(users2.getUserrank());
		users.setUserID(userID);
		System.out.println("AAA"+users);
		service.update(users);
		return "/user_lt/information";
	}
	@RequestMapping(value="/pladd")
	@ResponseBody
	public String add(Place place,HttpSession session){
		System.out.println(place);
		Integer userID =(Integer)session.getAttribute("userID");
		String hql="from Place p where p.userid="+userID+"";
		List<Place> places = service.find(hql,null);
		for(Place place2 : places){//修改数据库原有的状态
			place2.setPot("N");
			service.update(place2);
		}
		place.setUserid(userID);
		place.setPot("Y");
		service.add(place);
		return "OK";
	}
	
	@RequestMapping(value="/plist")//显示所有地址
	public String plist(HttpSession session,HttpServletRequest request){
		Integer userID =(Integer)session.getAttribute("userID");
		
		String hql="from Place p where p.userid="+userID+"";
		request.setAttribute("place", service.find(hql, null));
		System.out.println("PPP"+service.find(hql, null));
		return "/user_lt/address";
	}
	
	@RequestMapping(value="/deletep")//删除地址
	public String deletep(Integer pid){
		Place place=(Place)service.load(Place.class, pid);
		service.delete(place);
		return "redirect:/urerlt/plist.sw";
	}
	@RequestMapping(value="/potupdate")//修改默认地址
	@ResponseBody
	public String potupdate(Integer pid,HttpSession session){
		Integer userID =(Integer)session.getAttribute("userID");
		String hql="from Place p where p.userid="+userID+"";
		List<Place> places = service.find(hql,null);
		for(Place place2 : places){//修改数据库原有的状态
			if(place2.getPid().equals(pid)){
				place2.setPot("Y");
				service.update(place2);
			}else{
			place2.setPot("N");
			service.update(place2);
			}
		}
		return "OK";
	}
	
	
	
}
