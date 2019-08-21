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
        String statusIcon = task.getStatusIcon();
        String description = task.getDescription();
        System.out.println("[" + statusIcon + "] " + description);
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

    public static void main(String[] args) {
        Duke duke = new Duke();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();
            String[] splitCommand = command.split(" ");
            if (command.equals("bye")) {
                duke.exit();
                return;
            } else if (command.equals("list")) {
                duke.listTask();
            } else if (splitCommand[0].equals("done")) {
                int index = Integer.parseInt(splitCommand[1]);
                duke.setTaskDone(index);
            } else {
                duke.addTask(command);
            }
        }
    }
}