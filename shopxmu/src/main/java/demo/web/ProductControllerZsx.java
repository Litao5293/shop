package demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.BeanService;

@Controller
@RequestMapping("/product")
public class ProductControllerZsx {
	     @Autowired
         private BeanService service;
	     @RequestMapping("/list")
	     @ResponseBody
         public Object list(){
        	 service.find("from Product", null);
        	 return "ok" ;
         }
	     
	     
	     
	     
	     
	     
}
