package demo.tasks;

import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TaskController {
  private TaskRepository taskRepo;

  public TaskController(TaskRepository repo) {
    this.taskRepo = repo;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showAllTasks(ModelMap model) {
    Iterable<Task> tasks = this.taskRepo.findAll();
    model.addAttribute("tasks", tasks);
    return "task";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String newTask(ModelMap model, @ModelAttribute("newTask") Task task) {
    this.taskRepo.save(task);
    return showAllTasks(model);
  }

  @RequestMapping("/delete")
  public String deleteTask(ModelMap model, @RequestParam("taskId") Long id) {
    this.taskRepo.deleteById(id);
    return showAllTasks(model);
  }
}
