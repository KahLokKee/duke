package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 *
 */
public abstract class Command {
    protected boolean isExit;
    protected String fullCommand;
    abstract public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Gets the exit signal for the program
     * @return true if the exit command is given
     */
    public boolean isExit() {
        return isExit;
    }
}
