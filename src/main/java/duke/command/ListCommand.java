package duke.command;

import duke.exception.EmptyListException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Command to list all tasks
 */
public class ListCommand extends Command {
    /**
     * Constructs a command to list all tasks
     */
    public ListCommand() {
        this.isExit = false;
    }

    /**
     * List all tasks
     * @param tasks List of tasks tracked by duke
     * @param ui Interface instance that handles user inputs and outputs
     * @param storage To load and save task data
     * @throws EmptyListException If task list is empty
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyListException {
        tasks.listTask();
    }
}
