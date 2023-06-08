package org.example.TelegramBot;

import org.example.Controller.AuthController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

    public AuthController controller = new AuthController(this);

    @Override
    public String getBotUsername() {
        return "age_year_bot";
    }

    @Override
    public String getBotToken() {
        return "6119367762:AAFWVPO7Hht0vfZDiBSR-qgiBgGC4cJ88CA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        controller.start(update);
    }

    public void sendMes(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEditMes(EditMessageText sendEditMes) {
        try {
            execute(sendEditMes);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
