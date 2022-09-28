package com.vladik.dao;

import com.google.common.collect.ImmutableMap;
import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.BotCommand.Command.info_command.*;
import com.vladik.dao.Service.SendMessageService.SendBotMessageService;

import static com.vladik.dao.BotCommand.Command.CommandName.*;


public class CommandContainer {

    private final ImmutableMap<String, ExecuteCommand> commandMap;
    private final ExecuteCommand unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, ExecuteCommand>builder()
                .put(START.getCommandName(), new Start(sendBotMessageService))
                .put(HELP.getCommandName(), new Help(sendBotMessageService))
                .put(NO.getCommandName(), new No(sendBotMessageService))
                .put(INFO.getCommandName(), new Info(sendBotMessageService))
                .build();

        unknownCommand = new Unknown(sendBotMessageService);
    }

    public ExecuteCommand retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}