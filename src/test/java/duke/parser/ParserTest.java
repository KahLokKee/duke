package duke.parser;

import duke.command.*;
import duke.exception.UnknownCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
    @Test
    void parseBye() throws UnknownCommandException {
        assertTrue(Parser.parse("bye") instanceof ByeCommand);
    }

    @Test
    void parseList() throws UnknownCommandException {
        assertTrue(Parser.parse("list") instanceof ListCommand);
    }

    @Test
    void parseDelete() throws UnknownCommandException {
        assertTrue(Parser.parse("delete") instanceof DeleteCommand);
    }

    @Test
    void parseFind() throws UnknownCommandException {
        assertTrue(Parser.parse("find") instanceof FindCommand);
    }

    @Test
    void parseDone() throws UnknownCommandException {
        assertTrue(Parser.parse("done") instanceof DoneCommand);
    }

    @Test
    void parseDeadline() throws UnknownCommandException {
        assertTrue(Parser.parse("deadline") instanceof DeadlineCommand);
    }

    @Test
    void parseEvent() throws UnknownCommandException {
        assertTrue(Parser.parse("event") instanceof EventCommand);

    }

    @Test
    void parseTodo() throws UnknownCommandException {
        assertTrue(Parser.parse("todo") instanceof TodoCommand);
    }
}