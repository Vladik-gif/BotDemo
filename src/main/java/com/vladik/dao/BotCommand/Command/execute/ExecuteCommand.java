package com.vladik.dao.BotCommand.Command.execute;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ExecuteCommand {
     void execute(Update update);
}
