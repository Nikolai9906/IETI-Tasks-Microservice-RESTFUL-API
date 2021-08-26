package edu.eci.ieti.microservices.service;

import edu.eci.ieti.microservices.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<String, Task> tasksMap = new HashMap<>();

    @Override
    public Task create(Task task) {
        tasksMap.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        if(tasksMap.containsKey(id)){
            return tasksMap.get(id);
        }
        return null;
    }

    @Override
    public List<Task> all() {
        List<Task> taskList = new ArrayList<>();
        for(String id: tasksMap.keySet()){
            taskList.add(tasksMap.get(id));
        }
        return taskList;
    }

    @Override
    public void deleteById(String id) {
        tasksMap.remove(id);
    }

    @Override
    public Task update(Task task, String id) {
        return tasksMap.put(id,task);
    }
}
