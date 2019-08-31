package command;

import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class ByeCommand extends Command {
    public ByeCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
