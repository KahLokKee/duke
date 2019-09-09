package duke.tasklist;

import duke.exception.EmptyListException;
import duke.exception.InvalidTaskIndexException;
import duke.exception.TaskAlreadyDoneException;
import duke.exception.UnknownTaskException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

/**
 * Manages all operations relating to list of tasks
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Default constructor
     */
    public TaskList() {
    }

    /**
     * Constructor for existing task list
     * @param tasks ArrayList containing existing tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Prints the task at a specified index
     * @param index index of task to be printed
     */
    public void getTask(int index) {
        Task task = tasks.get(index - 1);
        System.out.println(task.toString());
    }

    /**
     * Getter for all tasks
     * @return ArrayList containing all tasks
     */
    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }

    /**
     * Prints all the existing tasks
     * @throws EmptyListException If task list is empty
     */
    public void listTask() throws EmptyListException {
        if (!tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            int index = 1;
            for (Task task : tasks) {
                System.out.print(index + ".");
                getTask(index);
                index++;
            }
        } else {
            throw new EmptyListException("The duke.task list is empty.");
        }
    }

    /**
     * Sets task as done
     * @param index index of task to be set as done
     * @throws UnknownTaskException If task does not exist
     * @throws InvalidTaskIndexException If index is invalid or out of bounds
     * @throws TaskAlreadyDoneException If task is already marked as done
     */
    public void setTaskDone(int index) throws UnknownTaskException, InvalidTaskIndexException, TaskAlreadyDoneException {
        if (index <= tasks.size() && index >= 1) {
            Task task = tasks.get(index - 1);
            if (task.getStatusIcon().equals("Y")) {
                throw new TaskAlreadyDoneException("This duke.task is already marked as done");
            }
            task.markAsDone();
            System.out.println("Nice! I've marked this duke.task as done:");
            getTask(index);
        } else if (index > tasks.size()) {
            throw new UnknownTaskException("This duke.task does not exist.");
        } else {
            throw new InvalidTaskIndexException("The index is invalid.");
        }
    }

    /**
     * Deletes a task
     * @param index index of task to be deleted
     * @throws UnknownTaskException If task does not exist
     * @throws InvalidTaskIndexException If index is invalid or out of bounds
     */
    public void deleteTask(int index) throws UnknownTaskException, InvalidTaskIndexException {
        if (index <= tasks.size() && index >= 1) {
            System.out.println("Noted. I've removed this duke.task:");
            getTask(index);
            tasks.remove(index - 1);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } else if (index > tasks.size()) {
            throw new UnknownTaskException("This duke.task does not exist.");
        } else {
            throw new InvalidTaskIndexException("The index is invalid.");
        }
    }

    /**
     * Finds matching task from keyword
     * @param keyword String containing search parameter
     */
    public void findTask(String keyword) {
        ArrayList<Integer> matchList = new ArrayList<>();
        int searchIndex = 1;
        for (Task task : tasks) {
            if (task.toString().contains(keyword)) {
                matchList.add(searchIndex);
            }
            searchIndex++;
        }
        if (matchList.size() > 0) {
            System.out.println("Here are the matching tasks in your list:");
            int printIndex = 1;
            for (int index : matchList) {
                System.out.print(printIndex++ + ". ");
                getTask(index);
            }
        } else {
            System.out.println("The search parameter returned no matching results");
        }
    }

    /**
     * Adds a todo item
     * @param description name of todo item
     */
    public void addTodo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println(todo.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Adds a deadline item
     * @param description name of deadline item
     * @param by String containing date and time of deadline
     */
    public void addDeadline(String description, String by) {
        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println(deadline.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Adds a event item
     * @param description name of event item
     * @param at String containing date and time of event
     */
    public void addEvent(String description, String at) {
        Event event = new Event(description, at);
        tasks.add(event);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println(event.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
