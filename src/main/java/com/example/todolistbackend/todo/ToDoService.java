package com.example.todolistbackend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public List<ToDo> list(String order) {
        if (order == null) {
            return repository.findAll();
        }
        switch (order) {
            case "asc":
                return repository.findAll(Sort.by(Sort.Direction.ASC,"dueDate"));
            case "desc":
                return repository.findAll(Sort.by(Sort.Direction.DESC,"dueDate"));
            default:
                return repository.findAll();
        }
    }

    public ToDo get(Integer id) {
        return repository.findById(id)
                .orElse(null);
          //      .get();
    }

    public ToDo create(String title, String dueDate){
        ToDo newToDo = new ToDo();
        newToDo.setTitle(title);
        newToDo.setDueDate(dueDate);
        newToDo.setStatus(ToDoStatus.NEW);
        return repository.save(newToDo);
    }

    public ToDo update(ToDo request){
        ToDo updateToDo = repository.findById(request.getId())
                        .orElseThrow();
        updateToDo.setTitle(request.getTitle());
        updateToDo.setDueDate(request.getDueDate());
        updateToDo.setStatus(request.getStatus());
        return repository.save(updateToDo);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public int count(ToDoStatus status) {
        return repository.countByStatus(status);
    }

    public List<ToDo> upcoming() {
        return repository.findTop3ByStatusIsNotOrderByDueDateAsc(
                ToDoStatus.COMPLETED
        );
    }

    public List<ToDo> search(ToDoStatus status) {
        return repository.findAllByStatus(status);
    }
}