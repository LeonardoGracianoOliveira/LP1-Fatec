package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    List<T> findAll() throws Exception;
    Optional<T> findById(int id) throws Exception;
    boolean create(T obj) throws Exception;
    boolean update(T obj) throws Exception;
    boolean delete(int id) throws Exception;
}
