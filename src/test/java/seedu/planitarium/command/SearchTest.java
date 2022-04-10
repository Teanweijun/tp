package seedu.planitarium.command;

import org.junit.jupiter.api.Test;
import seedu.planitarium.commands.AddPersonCommand;
import seedu.planitarium.commands.AddRecordCommand;
import seedu.planitarium.commands.SearchCommand;
import seedu.planitarium.exceptions.PlanITariumException;
import seedu.planitarium.family.Family;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class SearchTest {
    protected static final String INVALID_DES_MSG =
            "Unknown error is detected from 'Empty string after `/d`', please check again.";

    Family family;
    SearchCommand search;

    private void initialize() throws PlanITariumException {
        family = new Family();
        AddPersonCommand add = new AddPersonCommand(CommandsForTesting.ADDPERSON, family);
        add.execute();
        AddRecordCommand addIn = new AddRecordCommand(CommandsForTesting.ADDEXPEND, family);
        AddRecordCommand addOut = new AddRecordCommand(CommandsForTesting.ADDINCOME, family);
        addIn.execute();
        addOut.execute();
    }

    @Test
    void find_invalidDes_fail() {
        try {
            initialize();
            search = new SearchCommand(CommandsForTesting.FIND1, family);
        } catch (PlanITariumException e) {
            assertEquals(e.toString(), INVALID_DES_MSG);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void  find_success() {
        try {
            initialize();
            search = new SearchCommand(CommandsForTesting.FIND, family);
        } catch (Exception e) {
            fail();
        }
    }

}
