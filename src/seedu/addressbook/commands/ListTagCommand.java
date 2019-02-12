package seedu.addressbook.commands;

/**
 * Lists all persons in the address book tagged with a certain tag to the user.
 */
public class ListTagCommand extends Command {

    public static final String COMMAND_WORD = "listtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " : Lists all persons with persons tagged with a certain tag.\n"
            + "Parameters: TAG\n"
            + "Example: " + COMMAND_WORD + " friend";

    public static final String MESSAGE_LIST_TAG = "Persons with tag: %s\n";

    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_LIST_TAG);
    }

}
