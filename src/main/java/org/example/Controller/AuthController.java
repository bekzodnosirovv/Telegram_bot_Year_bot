package org.example.Controller;

import org.example.Button.LanguageButton;
import org.example.Repository.Repository;
import org.example.TelegramBot.MyTelegramBot;
import org.example.dto.Profile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;


public class AuthController {
    MyTelegramBot myBot;
    public YearController yearController;
    public MonthController monthController;
    public DayController dayController;

    public AuthController(MyTelegramBot myBot) {
        this.myBot = myBot;
        yearController = new YearController(this);
        monthController = new MonthController(this);
        dayController = new DayController(this);
    }

    public static Map<Long, Profile> userMap = new HashMap<>();

    public void start(Update update) {
        if (update.hasMessage()) messageBot(update);
        if (update.hasCallbackQuery()) callBackBot(update);
    }

    private void callBackBot(Update update) {
        try {
            CallbackQuery query = update.getCallbackQuery();
            if (query.getData().startsWith("/til")) setLanguage(query);
            if (query.getData().startsWith("/year")) yearController.handleMessage(query);
            if (query.getData().startsWith("/month")) monthController.handleMessage(query);
            if (query.getData().startsWith("/day")) dayController.handleMessage(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void messageBot(Update update) {
        try {
            Message message = update.getMessage();
            if (message.getText().equals("/start")) chooseLanguage(message);
            if (message.getText().equals("/history")) getHistory(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getHistory(Message message) {
        String text = new Repository().readResult(message.getChatId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(text);
        myBot.sendMes(sendMessage);
    }

    private void chooseLanguage(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Tilni tanlang");
        sendMessage.setReplyMarkup(new LanguageButton().getLanguageButton());
        myBot.sendMes(sendMessage);
    }

    private void setLanguage(CallbackQuery query) {
        Profile profile = new Profile();
        if (query.getData().endsWith("uz")) {
            profile.setChatId(query.getFrom().getId());
            profile.setLanguage("UZ");
        } else if (query.getData().endsWith("ru")) {
            profile.setChatId(query.getFrom().getId());
            profile.setLanguage("RU");
        } else if (query.getData().endsWith("en")) {
            profile.setChatId(query.getFrom().getId());
            profile.setLanguage("EN");
        }
        userMap.put(profile.getChatId(), profile);
        yearController.beginYearMessage(query);
    }
}
