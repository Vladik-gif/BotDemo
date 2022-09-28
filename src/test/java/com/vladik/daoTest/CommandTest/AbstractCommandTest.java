package com.vladik.daoTest.CommandTest;

import com.vladik.Bot;
import com.vladik.dao.BotCommand.Command.execute.ExecuteCommand;
import com.vladik.dao.Service.SendMessageService.SendBotMessageService;
import com.vladik.dao.Service.SendMessageService.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {

    protected Bot bot = Mockito.mock(Bot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(bot);

    protected abstract String getCommandName();
    protected abstract String getCommandMessage();
    abstract ExecuteCommand getExecuteCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getExecuteCommand().execute(update);
        Mockito.verify(bot).execute(sendMessage);
    }

}
