package duke.command;

import duke.exception.DukeException;
import duke.exception.InvalidTaskIndexException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    public DeleteCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
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
