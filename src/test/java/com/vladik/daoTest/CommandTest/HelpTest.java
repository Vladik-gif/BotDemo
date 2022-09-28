package com.vladik.daoTest.CommandTest;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.BotCommand.Command.info_command.Help;
import org.junit.jupiter.api.DisplayName;

import static com.vladik.dao.BotCommand.Command.CommandName.HELP;
import static com.vladik.dao.BotCommand.Command.info_command.Help.HELP_MESSAGE;

@DisplayName("Unit-level testing for Help")
public class HelpTest extends AbstractCommandTest {

    @Override
    protected String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    ExecuteCommand getExecuteCommand() {
        return new Help(sendBotMessageService);
    }
}
