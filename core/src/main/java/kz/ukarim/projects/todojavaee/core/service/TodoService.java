package kz.ukarim.projects.todojavaee.core.service;

import kz.ukarim.projects.todojavaee.core.entity.Todo;

import java.util.List;

public interface TodoService extends Service<Todo, Long> {

    List<Todo> getAllTodos();

    List<Todo> getCompletedTodos();

    List<Todo> getUncompletedTodos();
}
