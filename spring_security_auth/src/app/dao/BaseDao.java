package app.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Serializable, ID extends Serializable> {
	T findById(final ID id);

	T persist(final T entity);

	T update(final T entity);

	T merge(T entity);

	void delete(final T entity);

	void deleteById(final ID id);

	void findAndDeleteById(final ID id);

	void findAndDeleteAllById(final List<ID> id);

	List<T> findAll();

}
