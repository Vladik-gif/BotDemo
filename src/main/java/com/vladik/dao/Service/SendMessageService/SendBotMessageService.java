package com.vladik.dao.Service.SendMessageService;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
    void sendButton(SendMessage sendMessage);



}
