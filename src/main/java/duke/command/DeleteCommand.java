package duke.command;

import duke.exception.DukeException;
import duke.exception.InvalidTaskIndexException;
import duke.exception.UnknownTaskException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Command to delete a task
 */
public class DeleteCommand extends Command {
    /**
     * Constructs a command to delete a task
     * @param fullCommand Input provided by the user
     */
    public DeleteCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    /**
     * Processes the input and deletes a task
     * @param tasks List of tasks tracked by duke
     * @param ui Interface instance that handles user inputs and outputs
     * @param storage To load and save task data
     * @throws InvalidTaskIndexException If argument in command is not valid
     * @throws UnknownTaskException If task does not exist
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws InvalidTaskIndexException, UnknownTaskException {
        String[] commandSplit = fullCommand.split(" ", 2);
        if (commandSplit.length != 2) {
            throw new InvalidTaskIndexException("The index is invalid.");
        } else {
            try {
                tasks.deleteTask(Integer.parseInt(commandSplit[1]));
                storage.save(tasks);
            } catch (NumberFormatException e) {
                System.out.println("The index argument must be a single integer.");
            }
        }
    }
}
