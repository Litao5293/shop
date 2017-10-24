package demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.Users;
import demo.service.BeanService;

@Controller
@RequestMapping("/userlogin")
public class UserControllerZsx {
	
	@Resource(name="beanservice")
    private BeanService  service;
	//ǰ̨��¼�ķ���
	@RequestMapping("/list")
	@ResponseBody
	public String  login(@RequestParam("username") String username,@RequestParam("pwd") String pwd,HttpSession session){	
		
		if(username!=null && !username.equals("")&& pwd!=null &&!pwd.equals("")){
			List ki=new  ArrayList();
			ki.add(username);
			ki.add(pwd);
			
			List ol=service.find("select u from Users u where username=? and pwd=?", ki.toArray());
			if(ol.size()>0){
				session.setAttribute("userID", ((Users)ol.get(0)).getUserID());
				session.setAttribute("username",((Users)ol.get(0)).getUsername());
				//return "redirect:/index.html";
				return "OK";
			}else {
				//�����ж�
//				session.setAttribute("error", "�˺��������");
//				return  "redirect:/my.account.html";	
				return "fail";
			}
		}else{
			
//			//�˺����벻��Ϊ��
//			session.setAttribute("error", "�˺����벻��Ϊ��");
//			return  "redirect:/my.account.html";	
			return "failnull";
			
		}
		 
    }
	
	
	
}
