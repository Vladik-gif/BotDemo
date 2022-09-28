package com.vladik.daoTest.CommandContainerTest;

import com.vladik.dao.BotCommand.Command.CommandName;
import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.BotCommand.Command.info_command.Unknown;
import com.vladik.dao.CommandContainer;
import com.vladik.dao.Service.SendMessageService.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private SendBotMessageService sendBotMessageService;
    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands(){
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    ExecuteCommand command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(Unknown.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/fgjhdfgdfg";

        //when
        ExecuteCommand command = commandContainer.retrieveCommand(unknownCommand);

        //then
        Assertions.assertEquals(Unknown.class, command.getClass());
    }
}