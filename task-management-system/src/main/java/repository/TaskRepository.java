package repository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}

