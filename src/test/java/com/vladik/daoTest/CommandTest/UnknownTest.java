package com.vladik.daoTest.CommandTest;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.BotCommand.Command.info_command.Unknown;
import org.junit.jupiter.api.DisplayName;

import static com.vladik.dao.BotCommand.Command.info_command.Unknown.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for Unknown")
public class UnknownTest extends AbstractCommandTest{

    @Override
    protected String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    protected String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    ExecuteCommand getExecuteCommand() {
        return new Unknown(sendBotMessageService);
    }
}
