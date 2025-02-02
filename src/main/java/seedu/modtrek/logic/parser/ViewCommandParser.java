package seedu.modtrek.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.modtrek.logic.commands.ViewCommand;
import seedu.modtrek.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewCommand object
 */
public class ViewCommandParser implements Parser<ViewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String[] trimmedArgs = args.trim().split(" ");
        if (trimmedArgs.length == 1) {
            String flag = trimmedArgs[0];
            switch (flag) {
            case "progress":
                return new ViewCommand(true);
            case "modules":
                return new ViewCommand(false);
            default:
                // Fallthrough
            }
        }
        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
    }

}
