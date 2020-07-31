package dao;

import entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends SuperDAO {

    public List<T> findAll();

    public T find(ID key);

    public boolean save(T entity);

    public boolean update(T entity);

    public boolean delete(ID key);
}
