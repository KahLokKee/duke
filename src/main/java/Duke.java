import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Duke {
    private ArrayList<Task> tasks = new ArrayList<>();

    public Duke() {
        greet();
    }

    public void greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        try (BufferedReader bufferedreader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                char task = line.charAt(1);
                char isDone = line.charAt(4);
                if (task == 'T') {
                    Todo todo = new Todo(line.substring(7));
                    if (isDone == 'Y') {
                        todo.setDone(true);
                    }
                    tasks.add(todo);
                } else if (task == 'D') {
                    String details = line.substring(7);
                    String[] deadlineSplit = details.split(" \\(by: ");
                    deadlineSplit[1] = deadlineSplit[1].substring(0, deadlineSplit[1].length() - 1);
                    Deadline deadline = new Deadline(deadlineSplit[0], deadlineSplit[1]);
                    if (isDone == 'Y') {
                        deadline.setDone(true);
                    }
                    tasks.add(deadline);
                } else if (task == 'E') {
                    String details = line.substring(7);
                    String[] eventSplit = details.split(" \\(at: ");
                    eventSplit[1] = eventSplit[1].substring(0, eventSplit[1].length() - 1);
                    Event event = new Event(eventSplit[0], eventSplit[1]);
                    if (isDone == 'Y') {
                        event.setDone(true);
                    }
                    tasks.add(event);
                }
            }
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        saveToDisk();
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void getTask(int index) {
        Task task = tasks.get(index - 1);
        System.out.println(task.toString());
    }

    public void listTask() throws EmptyListException {
        if (!tasks.isEmpty()) {
            int index = 1;
            for (Task task : tasks) {
                System.out.print(index + ".");
                getTask(index);
                index++;
            }
        } else {
            throw new EmptyListException("The task list is empty.");
        }
    }

    public void setTaskDone(int index) throws UnknownTaskException, InvalidTaskIndexException, TaskAlreadyDoneException {
        if (index <= tasks.size() && index >= 1) {
            Task task = tasks.get(index - 1);
            if (task.getStatusIcon().equals("Y")) {
                throw new TaskAlreadyDoneException("This task is already marked as done");
            }
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            getTask(index);
        } else if (index > tasks.size()) {
            throw new UnknownTaskException("This task does not exist.");
        } else {
            throw new InvalidTaskIndexException("The index is invalid.");
        }
    }

    public void deleteTask(int index) throws UnknownTaskException, InvalidTaskIndexException {
        if (index <= tasks.size() && index >= 1) {
            System.out.println("Noted. I've removed this task:");
            getTask(index);
            tasks.remove(index - 1);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } else if (index > tasks.size()) {
            throw new UnknownTaskException("This task does not exist.");
        } else {
            throw new InvalidTaskIndexException("The index is invalid.");
        }
    }

    public void addTodo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("Got it. I've added this task: ");
        System.out.println(todo.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void addDeadline(String description, String by) {
        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        System.out.println("Got it. I've added this task: ");
        System.out.println(deadline.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void addEvent(String description, String at) {
        Event event = new Event(description, at);
        tasks.add(event);
        System.out.println("Got it. I've added this task: ");
        System.out.println(event.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void saveToDisk() {
        try {
            FileWriter filewriter = new FileWriter("output.txt");
            for (Task task : tasks) filewriter.write(task.toString() + "\n");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();
            String[] commandSplit = command.split(" ", 2);
            try {
                if (command.equals("bye")) {
                    duke.exit();
                    return;
                } else if (command.equals("list")) {
                    duke.listTask();
                } else if (commandSplit[0].equals("done")) {
                    if (commandSplit.length != 2) {
                        throw new InvalidTaskIndexException("The index is invalid.");
                    } else {
                        int index = Integer.parseInt(commandSplit[1]);
                        duke.setTaskDone(index);
                    }
                } else if (commandSplit[0].equals("delete")) {
                    if (commandSplit.length != 2) {
                        throw new InvalidTaskIndexException("The index is invalid.");
                    } else {
                        int index = Integer.parseInt(commandSplit[1]);
                        duke.deleteTask(index);
                    }
                } else if (commandSplit[0].equals("todo")) {
                    if (!command.trim().equals("todo")) {
                        duke.addTodo(command.substring(5));
                    } else {
                        throw new MissingDescriptionException("The description of a todo cannot be empty.");
                    }
                } else if (commandSplit[0].equals("deadline")) {
                    if (!command.trim().equals("deadline")) {
                        String[] deadlineSplit = commandSplit[1].split(" /by ");
                        if (deadlineSplit.length == 2) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                            simpleDateFormat.setLenient(false);
                            Date date = simpleDateFormat.parse(deadlineSplit[1]);
                            String processedDate = new SimpleDateFormat("dd MMMM yyyy hh:mmaa").format(date);
                            duke.addDeadline(deadlineSplit[0], processedDate);
                        } else {
                            throw new MissingDeadlineDateException("The due date of a deadline cannot be empty.");
                        }
                    } else {
                        throw new MissingDescriptionException("The description of a deadline cannot be empty.");
                    }
                } else if (commandSplit[0].equals("event")) {
                    if (!command.trim().equals("event")) {
                        String[] eventSplit = commandSplit[1].split(" /at ");
                        if (eventSplit.length == 2) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                            simpleDateFormat.setLenient(false);
                            Date date = simpleDateFormat.parse(eventSplit[1]);
                            String processedDate = new SimpleDateFormat("dd MMMM yyyy hh:mmaa").format(date);
                            duke.addEvent(eventSplit[0], processedDate);
                        } else {
                            throw new MissingEventDateException("The date of an event cannot be empty.");
                        }
                    } else {
                        throw new MissingDescriptionException("The description of a event cannot be empty.");
                    }
                } else {
                    throw new UnknownCommandException("I'm sorry, but I don't know what that means :-(");
                }
            } catch (UnknownCommandException | MissingDeadlineDateException | MissingDescriptionException |
                    MissingEventDateException | UnknownTaskException | InvalidTaskIndexException | EmptyListException |
                    TaskAlreadyDoneException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.println("The index argument must be a single integer.");
            } catch (ParseException e) {
                System.out.println("The date is invalid");
            }
        }
    }
}