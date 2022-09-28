package com.vladik.dao.BotCommand.Command.info_command;

import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.Service.SendMessageService.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Unknown implements ExecuteCommand {
    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    private final SendBotMessageService sendBotMessageService;

    public Unknown(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
