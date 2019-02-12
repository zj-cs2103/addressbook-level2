package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.util.TypicalPersons;

public class ListTagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //a tag that exists: matches at least one person
        assertListTagCommandBehavior(new Tag("test"), Arrays.asList(td.dan));

        //a tag that does not exist: matches no one
        assertListTagCommandBehavior(new Tag("abcd"), Arrays.asList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertListTagCommandBehavior(Tag tag, List<ReadOnlyPerson> expectedPersonList) {
        ListTagCommand command = createListTagCommand(tag);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private ListTagCommand createListTagCommand(Tag tag) {
        ListTagCommand command = new ListTagCommand(tag);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
