package app.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.dao.BaseDao;

@Repository
public abstract class BaseDaoImpl<T extends Serializable, ID extends Serializable> implements BaseDao<T, ID> {
	
	private final Class<T> entityClass;

	@Autowired
	protected SessionFactory sessionFactory;

	protected BaseDaoImpl(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	protected Session getCurrentSession() {
		return (Session) this.sessionFactory.getCurrentSession();
	}

	@Override
	public T persist(final T entity) {
		sessionFactory.getCurrentSession().persist(entityClass.getSimpleName(), entity);
		return entity;
	}

	@Override
	public T update(final T entity) {
		sessionFactory.getCurrentSession().update(entityClass.getSimpleName(), entity);
		return entity;
	}

	@Override
	public T merge(final T entity) {
		sessionFactory.getCurrentSession().merge(entityClass.getSimpleName(), entity);
		return entity;
	}

	@Override
	public void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entityClass.getSimpleName(), entity);
	}

	@Override
	public void deleteById(final ID id) {

		Query q = sessionFactory.getCurrentSession()
				.createNativeQuery("DELETE FROM" + entityClass.getSimpleName() + " t WHERE t.id=:prmId");
		q.setParameter("Id", id);
		q.executeUpdate();
	}

	@Override
	public void findAndDeleteById(final ID id) {
		delete(findById(id));
	}

	@Override
	public void findAndDeleteAllById(final List<ID> ids) {
		for (ID id : ids) {
			findAndDeleteById(id);
			// delete(findById(id));
		}
	}

	@Override
	public T findById(final ID id) {
		return sessionFactory.getCurrentSession().find(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM " + entityClass.getSimpleName(), entityClass)
				.getResultList();
	}
}
