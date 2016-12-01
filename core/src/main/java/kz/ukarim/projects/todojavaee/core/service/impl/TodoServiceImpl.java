package kz.ukarim.projects.todojavaee.core.service.impl;

import kz.ukarim.projects.todojavaee.core.dao.DaoQualifier;
import kz.ukarim.projects.todojavaee.core.dao.DaoType;
import kz.ukarim.projects.todojavaee.core.dao.TodoDao;
import kz.ukarim.projects.todojavaee.core.entity.Todo;
import kz.ukarim.projects.todojavaee.core.service.ServiceQualifier;
import kz.ukarim.projects.todojavaee.core.service.ServiceType;
import kz.ukarim.projects.todojavaee.core.service.TodoService;

import javax.inject.Inject;
import java.util.List;

@ServiceQualifier(type = ServiceType.TODO_SERVICE)
public class TodoServiceImpl implements TodoService {

    @Inject
    @DaoQualifier(type = DaoType.TODO_DAO)
    private TodoDao todoDao;

    public Long create(Todo todo) {
        return todoDao.create(todo);
    }

    public Long update(Todo todo) {
        return todoDao.update(todo);
    }

    public void delete(Long id) {
        todoDao.delete(id);
    }

    public Todo find(Long id) {
        return todoDao.find(id);
    }

    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    public List<Todo> getCompletedTodos() {
        return todoDao.getCompletedTodos();
    }

    public List<Todo> getUncompletedTodos() {
        return todoDao.getUncompletedTodos();
    }
}
