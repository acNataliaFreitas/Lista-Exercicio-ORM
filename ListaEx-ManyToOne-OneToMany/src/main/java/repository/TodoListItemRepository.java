package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.TodoListItem;
@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Integer> {

}
