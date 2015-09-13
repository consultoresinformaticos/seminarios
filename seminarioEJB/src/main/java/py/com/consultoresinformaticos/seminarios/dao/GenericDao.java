package py.com.consultoresinformaticos.seminarios.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author enrique
 * @param <T>
 * @param <K>
 */
public interface GenericDao <T, K extends Serializable> {
    T create(T object);
    T getById(K id);
    T update(T object);
    boolean delete(T object);
    List<T> getAll();
}
