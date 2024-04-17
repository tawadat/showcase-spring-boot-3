package pro.akosarev.showcase;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
@Repository
public class InMemTaskRepository implements TaskRepository {
    private final List<Task> task = new LinkedList<>() {{
        this.add(new Task("Первая задача"));
        this.add(new Task("Вторая задача"));
    }};
    @Override
    public List<Task> findAll() {
        return this.task;
    }
}
