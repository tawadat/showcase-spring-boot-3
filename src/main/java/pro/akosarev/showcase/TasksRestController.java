package pro.akosarev.showcase;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/tasks")
public class TasksRestController {
    private final TaskRepository taskRepository;

    public TasksRestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> handleGetAllTasks() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.taskRepository.findAll());

    }
    @PostMapping
    public ResponseEntity<Task> handleCreateNewTask(
            @RequestBody NewTaskPayload payload) {
        var task = new Task(payload.details());
        this.taskRepository.save(task);
    }

}
