package com.vladik.daoTest.CommandTest;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;

import com.vladik.dao.BotCommand.Command.info_command.No;
import org.junit.jupiter.api.DisplayName;

import static com.vladik.dao.BotCommand.Command.CommandName.NO;
import static com.vladik.dao.BotCommand.Command.info_command.No.NO_MESSAGE;

@DisplayName("Unit-level testing for Ho")
public class NoTest extends AbstractCommandTest{
    @Override
    protected String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    ExecuteCommand getExecuteCommand() {
        return new No(sendBotMessageService);
    }
}
