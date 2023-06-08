package org.example.Controller;

import org.example.Button.YearButton;
import org.example.TelegramBot.MyTelegramBot;
import org.example.dto.Profile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.Arrays;

public class YearController {

    public static final int beginYear = 1990;
    AuthController controller;

    public YearController(AuthController controller) {
        this.controller = controller;
    }


    public void beginYearMessage(CallbackQuery query) {
        String text = "";
        Profile profile = AuthController.userMap.get(query.getFrom().getId());
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(query.getMessage().getChatId());
        editMessageText.setMessageId(query.getMessage().getMessageId());
        editMessageText.setReplyMarkup(YearButton.getYearButton(beginYear));
        if (profile.getLanguage().equals("UZ")) text = "Yilni tanlang";
        if (profile.getLanguage().equals("RU")) text = "Выберите год";
        if (profile.getLanguage().equals("EN")) text = "Select a year";
        editMessageText.setText(text);
        controller.myBot.sendEditMes(editMessageText);
    }

    public void handleMessage(CallbackQuery query) {
        String[] items = query.getData().split("/");
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(query.getMessage().getChatId());
        editMessageText.setMessageId(query.getMessage().getMessageId());
        if (items[2].equals("prev") || items[2].equals("next")) {
            int year = Integer.parseInt(items[3]);
            editMessageText.setReplyMarkup(YearButton.getYearButton(year));
        } else {
            AuthController.userMap.get(query.getFrom().getId()).setYear(Integer.parseInt(items[2]));
            controller.monthController.beginMonthMessage(query, Integer.parseInt(items[2]));
            return;
        }
        String text = "";
        Profile profile = AuthController.userMap.get(query.getFrom().getId());
        if (profile.getLanguage().equals("UZ")) text = "Yilni tanlang";
        if (profile.getLanguage().equals("RU")) text = "Выберите год";
        if (profile.getLanguage().equals("EN")) text = "Select a year";
        editMessageText.setText(text);
        controller.myBot.sendEditMes(editMessageText);
    }
}
