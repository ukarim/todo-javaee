package kz.ukarim.projects.todojavaee.core.dao;

public interface Dao<E, K> {

    K create(E entity);

    K update(E entity);

    void delete(K key);

    E find(K key);

}
