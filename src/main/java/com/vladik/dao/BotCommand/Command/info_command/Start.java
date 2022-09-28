package com.vladik.dao.BotCommand.Command.info_command;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.Service.SendMessageService.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Start implements ExecuteCommand {

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привет. Я Telegram Bot.";

    public Start(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);

    }
}