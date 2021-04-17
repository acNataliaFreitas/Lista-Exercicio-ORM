package com.nataliaFreitas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import domain.TodoList;
import domain.TodoListItem;
import repository.TodoListItemRepository;
import repository.TodoListRepository;

@SpringBootApplication
public class ListaExManyToOneOneToManyApplication implements CommandLineRunner {

	@Autowired
	TodoListRepository TodoRepository;
	@Autowired
	TodoListItemRepository ItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ListaExManyToOneOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TodoList td = new TodoList(null, "teste");

		TodoListItem item1 = new TodoListItem(null, "item1", td);
		TodoListItem item2 = new TodoListItem(null, "item2", td);
		TodoListItem item3 = new TodoListItem(null, "item3", td);
		TodoListItem item4 = new TodoListItem(null, "item4", td);

		td.getListaDeItens().add(item1);
		td.getListaDeItens().add(item2);
		td.getListaDeItens().add(item3);
		td.getListaDeItens().add(item4);

		TodoRepository.save(td);
		ItemRepository.save(item1);
		ItemRepository.save(item2);
		ItemRepository.save(item3);
		ItemRepository.save(item4);

		Optional<TodoList> buscaTarefas = TodoRepository.findById(1);

		if (buscaTarefas.isPresent()) {
			TodoList aFazer = buscaTarefas.get();
			for (TodoListItem item : aFazer.getListaDeItens()) {
				System.out.println("->" + item.getNomeDoItem());
			}
		}
		
		TodoListItem teste = new TodoListItem("item1");
		teste.getLista().add("a");
		teste.getLista().add("b");
		teste.getLista().add("c");
		teste.getLista().add("d");
		
		ItemRepository.save(teste);
		
	}

	
}
