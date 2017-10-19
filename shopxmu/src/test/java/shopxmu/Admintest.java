package shopxmu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.bean.Admin;
import demo.service.BeanService;

public class Admintest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		BeanService service =(BeanService)ctx.getBean("beanservice");
		
		Admin admin = new Admin();
		admin.setAdminName("уехЩ");
		admin.setPwd("123456");
		admin.setPermissions("Y");
		admin.setAuthority(1);
		
		service.add(admin);
	}
}
