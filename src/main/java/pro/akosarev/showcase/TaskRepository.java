package pro.akosarev.showcase;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
}
