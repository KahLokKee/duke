package duke.command;

import duke.exception.MissingDescriptionException;
import duke.exception.MissingEventDateException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Command to add an event task
 */
public class EventCommand extends Command {
    /**
     * Constructs a command to implement an event task
     * @param fullCommand Input provided by the user
     */
    public EventCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    /**
     * Processes the input and adds an event task to the task list
     * @param tasks List of tasks tracked by duke
     * @param ui Interface instance that handles user inputs and outputs
     * @param storage To load and save task data
     * @throws MissingDescriptionException If description of deadline is missing
     * @throws MissingEventDateException If no event date is provided
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MissingEventDateException, MissingDescriptionException {
        String[] commandSplit = fullCommand.split(" ", 2);
        if (!fullCommand.trim().equals("event")) {
            String[] eventSplit = commandSplit[1].split(" /at ");
            try {
                if (eventSplit.length == 2) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    simpleDateFormat.setLenient(false);
                    Date date = simpleDateFormat.parse(eventSplit[1]);
                    String processedDate = new SimpleDateFormat("dd MMMM yyyy hh:mmaa").format(date);
                    tasks.addEvent(eventSplit[0], processedDate);
                    storage.save(tasks);
                } else {
                    throw new MissingEventDateException("The date of an event cannot be empty.");
                }
            } catch (ParseException e) {
                System.out.println("The date is invalid");
            }
        } else {
            throw new MissingDescriptionException("The description of a event cannot be empty.");
        }
    }
}
