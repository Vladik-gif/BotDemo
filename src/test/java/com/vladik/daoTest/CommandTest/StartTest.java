package com.vladik.daoTest.CommandTest;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.BotCommand.Command.info_command.Start;
import org.junit.jupiter.api.DisplayName;

import static com.vladik.dao.BotCommand.Command.CommandName.START;
import static com.vladik.dao.BotCommand.Command.info_command.Start.START_MESSAGE;

@DisplayName("Unit-level testing for Start")
public class StartTest extends AbstractCommandTest{
    @Override
    protected String getCommandName() {
        return START.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    ExecuteCommand getExecuteCommand() {
        return new Start(sendBotMessageService);
    }
}
