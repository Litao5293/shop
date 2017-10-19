package demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
}
