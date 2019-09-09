package duke.command;

import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class TodoCommand extends Command {
    public TodoCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

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
