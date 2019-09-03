package duke.command;

import duke.exception.EmptyListException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {
    public ListCommand() {
        this.isExit = false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyListException {
        tasks.listTask();
    }
}
