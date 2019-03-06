package ku.shop.db;

import java.util.List;

public interface IEntityDAO<E> {
    void insert(E entity);
    E getOne(int id);
    List<E> getAll();
}
