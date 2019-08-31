package command;

import exception.DukeException;
import exception.InvalidTaskIndexException;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class DoneCommand extends Command {
    public DoneCommand(String fullCommand) {
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
                int index = Integer.parseInt(commandSplit[1]);
                tasks.setTaskDone(index);
                storage.save(tasks);
            } catch (NumberFormatException e) {
                System.out.println("The index argument must be a single integer.");
            }
        }
    }
}
