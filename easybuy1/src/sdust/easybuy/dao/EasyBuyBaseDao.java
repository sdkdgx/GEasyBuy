package sdust.easybuy.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EasyBuyBaseDao<T> {
	
	protected Session session;
	protected static SessionFactory sessionFactory;
	protected Class<T> entity;
	
	public EasyBuyBaseDao(){
		entity = (Class<T>)((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];
		
		System.out.println(entity);
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
	}
	
	
	
	public Session getSession() {
		return session;
	}
	
	public void closeSession(){
		if(session != null){
			session.close();
		}
		if(sessionFactory != null){
			sessionFactory.close();
		}
	}
	
	public List<T> getAll() {
		System.out.println(entity);
		@SuppressWarnings("unchecked")
		List<T> entities = this.getSession().createCriteria(entity).list();
		//this.closeSession();
		return entities;
	}

	public T getById(Integer id) {
		T t = (T)this.getSession().load(entity, id);
		return t;
	}

	public void saveOrUpdate(Object obj) {
		Transaction tx = session.getTransaction();
		tx.begin();
		session.saveOrUpdate(obj);
		tx.commit();
		System.out.println(obj);
	}
	
	public void delete(Object obj){
		this.getSession().delete(obj);
	}
}
