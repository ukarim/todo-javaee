package kz.ukarim.projects.todojavaee.core.dao;

import kz.ukarim.projects.todojavaee.core.entity.Todo;

import java.util.List;

public interface TodoDao extends Dao<Todo, Long> {

    List<Todo> paginate(int page, int number);

    List<Todo> getAllTodos();

    List<Todo> getCompletedTodos();

    List<Todo> getUncompletedTodos();
}
