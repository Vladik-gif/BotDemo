package com.vladik.dao.BotCommand.Command.info_command;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.Service.SendMessageService.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Help implements ExecuteCommand {
    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = "✨<b>Дотупные команды</b>✨\n\n";


    public Help(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
