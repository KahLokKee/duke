package command;

import exception.MissingDescriptionException;
import exception.MissingEventDateException;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventCommand extends Command {
    public EventCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws MissingEventDateException, MissingDescriptionException {
        String[] commandSplit = fullCommand.split(" ", 2);
        if (!fullCommand.trim().equals("event")) {
            String[] eventSplit = commandSplit[1].split(" /at ");
            try {
                if (eventSplit.length == 2) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    simpleDateFormat.setLenient(false);
                    Date date = simpleDateFormat.parse(eventSplit[1]);
                    String processedDate = new SimpleDateFormat("dd MMMM yyyy hh:mmaa").format(date);
                    tasks.addEvent(eventSplit[0], processedDate);
                    storage.save(tasks);
                } else {
                    throw new MissingEventDateException("The date of an event cannot be empty.");
                }
            } catch (ParseException e) {
                System.out.println("The date is invalid");
            }
        } else {
            throw new MissingDescriptionException("The description of a event cannot be empty.");
        }
    }
}
