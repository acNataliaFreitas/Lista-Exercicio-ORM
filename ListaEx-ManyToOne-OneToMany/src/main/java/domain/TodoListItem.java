package domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TodoListItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private static final long serialVersionUID = 1L;
	private String nomeDoItem;
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private TodoList todoList;
	
	@ElementCollection
	private ArrayList<String> lista = new ArrayList<String>();

	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}

	public TodoListItem(String nomeDoItem, Integer id, TodoList todoList, ArrayList<String> lista) {
		super();
		this.nomeDoItem = nomeDoItem;
		this.id = id;
	//	this.todoList = todoList;
		this.lista = lista;
	}

	public TodoListItem() {
		super();
	}
	
	public TodoListItem(Integer id,String nomeDoItem, TodoList list) {
		super();
		this.id = id;
		this.nomeDoItem = nomeDoItem;
	}
	
	public TodoListItem(String nomeDoItem) {
		super();
		this.nomeDoItem = nomeDoItem;
	}
	
	public TodoListItem(String nomeDoItem, Integer id, TodoList todoList) {
		super();
		this.nomeDoItem = nomeDoItem;
		this.id = id;
		//this.todoList = todoList;
	}
	
	public Integer getId() {
		return id;
	}

	public TodoList getTodoList() {
		return todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDoItem() {
		return nomeDoItem;
	}

	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoListItem other = (TodoListItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
