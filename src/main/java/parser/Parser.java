package parser;

import command.ByeCommand;
import command.Command;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.DoneCommand;
import command.EventCommand;
import command.FindCommand;
import command.ListCommand;
import command.TodoCommand;
import exception.UnknownCommandException;

public class Parser {

    public Parser() {
    }

    public static Command parse(String fullCommand) throws UnknownCommandException {
        String[] commandSplit = fullCommand.split(" ", 2);
        if (fullCommand.equals("bye")) {
            return new ByeCommand();
        } else if (commandSplit[0].equals("list")) {
            return new ListCommand();
        } else if (commandSplit[0].equals("delete")) {
            return new DeleteCommand(fullCommand);
        } else if (commandSplit[0].equals("find")) {
            return new FindCommand(fullCommand);
        } else if (commandSplit[0].equals("done")) {
            return new DoneCommand(fullCommand);
        } else if (commandSplit[0].equals("deadline")) {
            return new DeadlineCommand(fullCommand);
        } else if (commandSplit[0].equals("event")) {
            return new EventCommand(fullCommand);
        } else if (commandSplit[0].equals("todo")) {
            return new TodoCommand(fullCommand);
        } else {
            throw new UnknownCommandException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
