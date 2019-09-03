package duke.command;

import duke.exception.MissingDeadlineDateException;
import duke.exception.MissingDescriptionException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeadlineCommand extends Command {
    public DeadlineCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MissingDescriptionException, MissingDeadlineDateException {
        String[] commandSplit = fullCommand.split(" ", 2);
        if (!fullCommand.trim().equals("deadline")) {
            String[] deadlineSplit = commandSplit[1].split(" /at ");
            try {
                if (deadlineSplit.length == 2) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    simpleDateFormat.setLenient(false);
                    Date date = simpleDateFormat.parse(deadlineSplit[1]);
                    String processedDate = new SimpleDateFormat("dd MMMM yyyy hh:mmaa").format(date);
                    tasks.addDeadline(deadlineSplit[0], processedDate);
                    storage.save(tasks);
                } else {
                    throw new MissingDeadlineDateException("The due date of a deadline cannot be empty.");
                }
            } catch (ParseException e) {
                System.out.println("The date is invalid");
            }
        } else {
            throw new MissingDescriptionException("The description of a deadline cannot be empty.");
        }
    }
}
