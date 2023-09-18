package repository;

import java.util.List;

public interface Repository<T> {

    List<T> get(T t) throws Exception;

    T create(T t) throws Exception;

    T save(T t) throws Exception;

    boolean delete(T t) throws Exception;

}
