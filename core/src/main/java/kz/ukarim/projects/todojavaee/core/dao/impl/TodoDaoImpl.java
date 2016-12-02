package kz.ukarim.projects.todojavaee.core.dao.impl;

import kz.ukarim.projects.todojavaee.core.dao.DaoQualifier;
import kz.ukarim.projects.todojavaee.core.dao.DaoType;
import kz.ukarim.projects.todojavaee.core.dao.TodoDao;
import kz.ukarim.projects.todojavaee.core.entity.Todo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@DaoQualifier(type = DaoType.TODO_DAO)
public class TodoDaoImpl implements TodoDao {

    @PersistenceContext(unitName = "todojavaee")
    private EntityManager manager;

    public Long create(Todo todo) {
        manager.persist(todo);
        return todo.getId();
    }

    public Long update(Todo todo) {
        manager.merge(todo);
        return todo.getId();
    }

    public void delete(Long key) {
        Todo todo = find(key);
        todo.setDeleted(true);
    }

    public Todo find(Long key) {
        TypedQuery<Todo> query = manager.createQuery("SELECT e FROM Todo e where e.id = :id ORDER BY e.id DESC", Todo.class);
        query.setParameter("id", key);
        return query.getSingleResult();
    }

    public List<Todo> paginate(int page, int number) {
        TypedQuery<Todo> query = manager.createQuery("SELECT e FROM Todo e ORDER BY e,id DESC", Todo.class);
        query.setFirstResult(page);
        query.setMaxResults(number);
        return query.getResultList();
    }

    public List<Todo> getAllTodos() {
        TypedQuery<Todo> query = manager.createQuery("SELECT e FROM Todo e", Todo.class);
        return query.getResultList();
    }

    public List<Todo> getCompletedTodos() {
        TypedQuery<Todo> query = manager.createQuery("SELECT e FROM Todo e WHERE e.completed =:completed", Todo.class);
        query.setParameter("completed", true);
        return query.getResultList();
    }

    public List<Todo> getUncompletedTodos() {
        TypedQuery<Todo> query = manager.createQuery("SELECT e FROM Todo e WHERE e.completed =:completed", Todo.class);
        query.setParameter("completed", false);
        return query.getResultList();
    }
}
