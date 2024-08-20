package Controller;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        task.setUser(user);
        taskService.saveTask(task);
        return ResponseEntity.ok("Task created successfully");
    }

    @GetMapping
    public List<Task> getTasks(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return taskService.getTasksByUser(user);
    }
}

