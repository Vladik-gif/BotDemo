package com.vladik.daoTest.CommandTest;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.BotCommand.Command.info_command.Info;
import org.junit.jupiter.api.DisplayName;

import static com.vladik.dao.BotCommand.Command.CommandName.INFO;
import static com.vladik.dao.BotCommand.Command.info_command.Info.INFO_MESSAGE;

@DisplayName("Unit-level testing for Info")
public class InfoTest extends AbstractCommandTest{
    @Override
    protected String getCommandName() {
        return INFO.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return INFO_MESSAGE;
    }

    @Override
    ExecuteCommand getExecuteCommand() {
        return new Info(sendBotMessageService);
    }
}
