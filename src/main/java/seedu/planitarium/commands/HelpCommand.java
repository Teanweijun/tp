package seedu.planitarium.commands;

import seedu.planitarium.ProjectLogger;
import seedu.planitarium.global.UI;
import seedu.planitarium.person.Family;

import java.util.logging.Level;

public class HelpCommand extends Command {
    private static final String className = CommandFactory.class.getSimpleName();
    private static final String fileName = className + ".log";
    private static final ProjectLogger logger = new ProjectLogger(className, fileName);

    protected static final String LOG_HELP_INFO = "Help command is going to be executed";
    protected static final String LOG_EXECUTE_INFO = "Help command is executed";

    public HelpCommand(String userInput, Family family) {
        super(userInput, family);
        logger.log(Level.INFO, LOG_HELP_INFO);
    }

    @Override
    public void execute() {
        UI.printHelpMsg();
        logger.log(Level.INFO, LOG_EXECUTE_INFO);
    }
}