package duke.parser;

import duke.command.*;
import duke.exception.UnknownCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    String fullCommand = "";
    @Test
    void parseBye() throws UnknownCommandException {
        assertEquals(new ByeCommand(), Parser.parse("bye"));
    }

    @Test
    void parseList() throws UnknownCommandException {
        assertEquals(new ListCommand(), Parser.parse("list"));
    }

    @Test
    void parseDelete() throws UnknownCommandException {
        assertEquals(new DeleteCommand(fullCommand), Parser.parse("delete"));
    }

    @Test
    void parseFind() throws UnknownCommandException {
        assertEquals(new FindCommand(fullCommand), Parser.parse("find"));
    }

    @Test
    void parseDone() throws UnknownCommandException {
        assertEquals(new DoneCommand(fullCommand), Parser.parse("done"));
    }

    @Test
    void parseDeadline() throws UnknownCommandException {
        assertEquals(new DeadlineCommand(fullCommand), Parser.parse("deadline"));
    }

    @Test
    void parseEvent() throws UnknownCommandException {
        assertEquals(new EventCommand(fullCommand), Parser.parse("event"));
    }

    @Test
    void parseTodo() throws UnknownCommandException {
        assertEquals(new TodoCommand(fullCommand), Parser.parse("todo"));
    }
}