package ar.edu.um.umbooks.persistencia.dao;

import java.io.Serializable;
import java.util.List;

public interface CRUDInterface<T, ID extends Serializable> {
	void create(final T entity);
    void remove(final T entity);
    void update(final T entity);
    T findById(final ID id);
    List<T> findAll();
}
