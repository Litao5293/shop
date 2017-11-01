package demo.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Users;
import demo.dao.MD5;
import demo.service.BeanService;

@Controller
@RequestMapping("/userlogin")
public class UserControllerZsx {
	
	@Resource(name="beanservice")
    private BeanService  service;
	MD5 md5=new MD5();
	//前台登录的方法
	@RequestMapping("/list")
	@ResponseBody
	public String  login(@RequestParam("username") String username,@RequestParam("pwd") String pwd,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException{	
		
		if(username!=null && !username.equals("")&& pwd!=null &&!pwd.equals("")){
			List ki=new  ArrayList();
			try {
				ki.add(username);
				ki.add(md5.EncoderMyMd5(pwd));
			} catch (Exception e) {
				// TODO: handle exception
			}
			List ol=service.find("select u from Users u where username=? and pwd=?", ki.toArray());
			if(ol.size()>0){
				session.setAttribute("userID", ((Users)ol.get(0)).getUserID());
				session.setAttribute("username",((Users)ol.get(0)).getUsername());
				//把用户名和密码写入cooike中
				Cookie cookie=new Cookie("username", URLEncoder.encode(username,"UTF-8"));
				cookie.setMaxAge(1000);
				response.addCookie(cookie);
				Cookie cookie1=new Cookie("pwd", URLEncoder.encode(pwd,"UTF-8"));
				cookie1.setMaxAge(1000);
				response.addCookie(cookie1);
				
				return "OK";
			}else {	
				return "fail";
			}
		}else{		
			return "failnull";	
		} 
    }
	
	
	
	@RequestMapping("/zhuce")

	public String  zhuce(@RequestParam("uname")String uname,@RequestParam("pwd1")String pwd1){
		System.out.println("名字"+uname);
		
		if(uname!=null&&pwd1!=null&&!uname.equals("")&&!pwd1.equals("")){
			Users users=new Users();
			try {
				users.setUsername(uname);
				
				String pwd = md5.EncoderMyMd5(pwd1);
				
				users.setPwd(pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.err.println("00"+users);
			service.add(users);
			return "redirect:/my.account.html";
		}else{
			return "redirect:/my.account.html";
		}
		
	}
	
	
}
