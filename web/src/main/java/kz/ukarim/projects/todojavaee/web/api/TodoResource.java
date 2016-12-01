package kz.ukarim.projects.todojavaee.web.api;

import kz.ukarim.projects.todojavaee.core.entity.Todo;
import kz.ukarim.projects.todojavaee.core.service.ServiceQualifier;
import kz.ukarim.projects.todojavaee.core.service.ServiceType;
import kz.ukarim.projects.todojavaee.core.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/todo")
public class TodoResource {

    @Context
    private SecurityContext context;

    @Inject
    @ServiceQualifier(type = ServiceType.TODO_SERVICE)
    private TodoService todoService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTodos() {
        List<Todo> allTodos = todoService.getAllTodos();
        return Response.ok(allTodos).build();
    }

    @Path("/completed")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompletedTodos() {
        List<Todo> completedTodos = todoService.getCompletedTodos();
        return Response.ok(completedTodos).build();
    }

    @Path("/uncompleted")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUncompletedTodos() {
        todoService.getUncompletedTodos();
        return Response.ok().build();
    }

}
