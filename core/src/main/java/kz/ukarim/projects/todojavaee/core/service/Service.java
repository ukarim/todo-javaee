package kz.ukarim.projects.todojavaee.core.service;

public interface Service<E, K> {

    K create(E entity);

    K update(E entity);

    void delete(K key);

    E find(K key);

}
