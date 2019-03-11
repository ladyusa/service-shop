package ku.shop.repositories;

import java.util.List;

public interface IEntityDAO<E> {
    E insert(E entity);
    E getOne(int id);
    List<E> getAll();
}
