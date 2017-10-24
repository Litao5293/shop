package demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.bean.Users;
import demo.dao.BeanDao;

@Service("beanservice")
public class BeanService {
	@Resource(name="beandao")
	private BeanDao beanDao;
	
	@Transactional
	public  void add(Object object){
		beanDao.add(object);
	}
	@Transactional
	public void update(Object object){
		beanDao.update(object);
	}
	@Transactional
	public void delete(Object object){
		beanDao.delete(object);
	}
	
	public Object load(Class clazz,Integer id){
		return beanDao.load(clazz, id);
	}
	
	public List find(String hql,Object[] params){
		return beanDao.find(hql, params);
	}
	
//	//µÇÂ¼
//	public Users login(Users user){
//		return beanDao.login(user);
//	}
//	//×¢²á
//	public Users adduser(Users user){
//		return beanDao.adduser(user);
//	}
}
