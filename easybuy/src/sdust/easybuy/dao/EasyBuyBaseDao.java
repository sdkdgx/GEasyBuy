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

	protected static Session session;
	protected static SessionFactory sessionFactory;
	protected Class<T> entity;

	public EasyBuyBaseDao() {
		//获取T的类型。
		entity = (Class<T>) ((ParameterizedType) (getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];

		System.out.println(entity);
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
	}

	//获取Session。
	public Session getSession() {
		return session;
	}

	//关闭Session。
	public void closeSession() {
		if (session != null) {
			session.close();
		}
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	//获取所有对象。
	public List<T> getAll() {
		System.out.println(entity);
		@SuppressWarnings("unchecked")
		List<T> entities = this.getSession().createCriteria(entity).list();
		return entities;
	}

	//根据主键查询一个对象。
	public T getById(Integer id) {
		T t = (T) this.getSession().load(entity, id);
		return t;
	}

	//保存或更新一个对象。
	public void saveOrUpdate(Object obj) {
		Transaction tx = session.getTransaction();
		tx.begin();
		session.saveOrUpdate(obj);
		tx.commit();
		System.out.println(obj);
	}

	//删除一个对象。
	public void delete(Object obj) {
		Transaction tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		tx.commit();
		sessionFactory.openSession();
	}
}
