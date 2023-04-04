package com.acme.todolist;

import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SpringBootConfiguration
class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testTodoItemEnRetard(){
		TodoItem item = new TodoItem("2435a53b5", Instant.now().minusSeconds(300000),"Faire les courses");
		assertEquals("[LATE!] Faire les courses",item.finalContent());
		TodoItem item2 = new TodoItem("2435a53b6	", Instant.now().minusSeconds(3000),"Faire les courses");
		assertEquals("Faire les courses",item2.finalContent());
	}


}
