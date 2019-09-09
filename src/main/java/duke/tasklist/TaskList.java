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

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void getTask(int index) {
        Task task = tasks.get(index - 1);
        System.out.println(task.toString());
    }

    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }

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

    public void addTodo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println(todo.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void addDeadline(String description, String by) {
        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println(deadline.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void addEvent(String description, String at) {
        Event event = new Event(description, at);
        tasks.add(event);
        System.out.println("Got it. I've added this duke.task: ");
        System.out.println(event.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
