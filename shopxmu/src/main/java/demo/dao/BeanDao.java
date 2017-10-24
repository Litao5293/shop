package demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import demo.bean.Users;
@Component("beandao")
public class BeanDao extends HibernateDaoSupport{
	@Autowired
	public void setFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public  void add(Object object){
		super.getHibernateTemplate().save(object);
	}
	
	public  void update(Object object){
		super.getHibernateTemplate().update(object);
	}
	
	public  void delete(Object object){
		super.getHibernateTemplate().delete(object);
	}
	
	public  Object load(Class clazz,Integer id){
		return super.getHibernateTemplate().get(clazz, id);
	}
	
	
	public  List find(String hql,Object[] params){
		return super.getHibernateTemplate().find(hql, params);
	}
	
//	    //用户登陆的方法
//	    public Users login(Users user) {
//	        String hql="from Users where username=? and pwd=? ";
//	        List<Users> list=(List<Users>)this.getHibernateTemplate().find(hql,user.getUsername(),user.getPwd());
//	        if(list!=null&&list.size()>0){
//	            return list.get(0);
//	        }
//	        return null;
//	    }
//	    //注册
//	    public Users adduser(Users user){
//	    	Users users=(Users)super.getHibernateTemplate().save(user);
//	    	return users;
//	    }
}
