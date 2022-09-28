package com.vladik.dao.BotCommand.Command;

public enum CommandName {
    START("/start"), HELP("/help"), NO("/no"), INFO("/info");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
