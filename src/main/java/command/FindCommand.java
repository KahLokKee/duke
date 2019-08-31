package command;

import exception.MissingDescriptionException;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

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
