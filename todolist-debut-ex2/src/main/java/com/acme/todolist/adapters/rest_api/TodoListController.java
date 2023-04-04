package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	// A compléter
	private AddTodoItem setTodoItemsQuery;
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem setTodoItemsQuery ) {

		this.getTodoItemsQuery = getTodoItemsQuery;
		this.setTodoItemsQuery = setTodoItemsQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	@PostMapping("/todos")
	public void ajouterItem(@RequestBody TodoItem item) {
		this.setTodoItemsQuery.addTodoItem(item);

	}
	
	
}
