package duke.command;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * Command to end running of duke
 */
public class ByeCommand extends Command {
    /**
     * Constructor which sets exit condition to true
     */
    public ByeCommand() {
        this.isExit = true;
    }

    /**
     * Invokes duke's goodbye message
     * @param tasks List of tasks tracked by duke
     * @param ui Interface instance that handles user inputs and outputs
     * @param storage To load and save task data
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
