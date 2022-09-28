package com.vladik;

import com.vladik.config.BotConfig;
import com.vladik.dao.CommandContainer;
import com.vladik.dao.Service.SendMessageService.SendBotMessageServiceImpl;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.vladik.dao.BotCommand.Command.CommandName.NO;

@Component
public class Bot extends TelegramLongPollingBot{

    private final BotConfig botConfig;
    private final CommandContainer commandContainer;

    public static String COMMAND_PREFIX = "/";

    public Bot(BotConfig botConfig) {
        this.botConfig = botConfig;
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUSER();
    }

    @Override
    public String getBotToken() {
        return botConfig.getTOKEN();
    }
}
