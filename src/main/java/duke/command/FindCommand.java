package duke.command;

import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Command to search the task list
 */
public class FindCommand extends Command {
    /**
     * Constructs a command to search the task list
     * @param fullCommand Input provided by the user
     */
    public FindCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    /**
     * Searches the task list using the given parameter
     * @param tasks List of tasks tracked by duke
     * @param ui Interface instance that handles user inputs and outputs
     * @param storage To load and save task data
     * @throws MissingDescriptionException If search parameter is missing
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MissingDescriptionException {
        String[] commandSplit = fullCommand.split(" ", 2);
        if (fullCommand.trim().equals("find")) {
            throw new MissingDescriptionException("The search parameter cannot be empty.");
        } else {
            tasks.findTask(commandSplit[1]);
        }
    }
}
