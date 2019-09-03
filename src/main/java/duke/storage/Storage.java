package duke.storage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.tasklist.TaskList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Task> load() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filepath))) {
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
        return tasks;
    }

    public void save(TaskList tasks) {
        try {
            FileWriter filewriter = new FileWriter("output.txt");
            for (Task task : tasks.getTaskList()) filewriter.write(task.toString() + "\n");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
