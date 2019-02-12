package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

import java.util.*;

/**
 * Lists all persons in the address book tagged with a certain tag to the user.
 */
public class ListTagCommand extends Command {

    public static final String COMMAND_WORD = "listtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " : Lists all persons with persons tagged with a certain tag.\n"
            + "Parameters: TAG\n"
            + "Example: " + COMMAND_WORD + " friend";

    public final Tag tag;

    public ListTagCommand(Tag tag) {
        this.tag = tag;
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyTag(tag);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book who are tagged with a certain tag.
     *
     * @param tag for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyTag(Tag tag) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (person.getTags().contains(tag)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
