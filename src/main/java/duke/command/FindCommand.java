package duke.command;

import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command {
    public FindCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

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
