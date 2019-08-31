package command;

import exception.EmptyListException;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class ListCommand extends Command {
    public ListCommand() {
        this.isExit = false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyListException {
        tasks.listTask();
    }
}
