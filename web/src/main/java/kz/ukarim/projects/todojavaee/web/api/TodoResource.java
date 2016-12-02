package kz.ukarim.projects.todojavaee.web.api;

import kz.ukarim.projects.todojavaee.core.entity.Todo;
import kz.ukarim.projects.todojavaee.core.service.ServiceQualifier;
import kz.ukarim.projects.todojavaee.core.service.ServiceType;
import kz.ukarim.projects.todojavaee.core.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/todo")
public class TodoResource {

    private static final String URL = "/todo/";

    @Context
    private UriInfo uriInfo;

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
        List<Todo> uncompletedTodos = todoService.getUncompletedTodos();
        return Response.ok(uncompletedTodos).build();
    }

    @Path("/")
    @POST
    public Response createTodo(Todo todo) {
        long id = todoService.create(todo);
        URI uri = uriInfo.getBaseUriBuilder().path(URL).path(String.valueOf(id)).build();
        return Response.created(uri).build();
    }

    @Path("/")
    @PUT
    public Response updateTodo(Todo todo) {
        todoService.update(todo);
        return Response.ok().build();
    }

}
