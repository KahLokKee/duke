import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private ArrayList<Task> tasks = new ArrayList<>();

    public Duke() {
        greet();
    }

    public void greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    public void exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void getTask(int index) {
        Task task = tasks.get(index - 1);
        System.out.println(task.toString());
    }

    public void listTask() {
        int index = 1;
        for (Task task : tasks) {
            System.out.print(index + ".");
            getTask(index);
            index++;
        }
    }

    public void setTaskDone(int index) {
        Task task = tasks.get(index - 1);
        task.markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        getTask(index);
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("added: " + task.getDescription());
    }

    public void addTodo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("Got it. I've added this task: ");
        System.out.println(todo.toString());
    }

    public void addDeadline(String description, String by) {
        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        System.out.println("Got it. I've added this task: ");
        System.out.println(deadline.toString());
    }

    public void addEvent(String description, String at) {
        Event event = new Event(description, at);
        tasks.add(event);
        System.out.println("Got it. I've added this task: ");
        System.out.println(event.toString());
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();
            String[] commandSplit = command.split(" ", 2);
            if (command.equals("bye")) {
                duke.exit();
                return;
            } else if (command.equals("list")) {
                duke.listTask();
            } else if (commandSplit[0].equals("done")) {
                int index = Integer.parseInt(commandSplit[1]);
                duke.setTaskDone(index);
            } else if (commandSplit[0].equals("todo")) {
                duke.addTodo(commandSplit[1]);
            } else if (commandSplit[0].equals("deadline")) {
                String[] deadlineSplit = commandSplit[1].split(" /by ");
                duke.addDeadline(deadlineSplit[0], deadlineSplit[1]);
            } else if (commandSplit[0].equals("event")) {
                String[] eventSplit = commandSplit[1].split(" /at ");
                duke.addEvent(eventSplit[0], eventSplit[1]);
            } else {
                duke.addTask(command);
            }
        }
    }
}