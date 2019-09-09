package duke.command;

import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Command to add a todo task
 */
public class TodoCommand extends Command {
    /**
     * Constructs a command to implement a todo task
     * @param fullCommand Input provided by the user
     */
    public TodoCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    /**
     * Processes the input and adds a todo task to the task list
     * @param tasks List of tasks tracked by duke
     * @param ui Interface instance that handles user inputs and outputs
     * @param storage To load and save task data
     * @throws MissingDescriptionException If description of todo is empty
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MissingDescriptionException {
        if (!fullCommand.trim().equals("todo")) {
            tasks.addTodo(fullCommand.substring(5));
            storage.save(tasks);
        } else {
            throw new MissingDescriptionException("The description of a todo cannot be empty.");
        }
    }
}
