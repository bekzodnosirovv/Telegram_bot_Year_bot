package org.example.Controller;

import org.example.Button.MonthButton;
import org.example.Button.YearButton;
import org.example.TelegramBot.MyTelegramBot;
import org.example.dto.Profile;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class MonthController {

    AuthController controller;

    public MonthController(AuthController controller) {
        this.controller = controller;
    }

    public void beginMonthMessage(CallbackQuery query, int year) {
        String text = "";
        Profile profile = AuthController.userMap.get(query.getFrom().getId());
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(query.getMessage().getChatId());
        editMessageText.setMessageId(query.getMessage().getMessageId());
        if (profile.getLanguage().equals("UZ")) {
            editMessageText.setReplyMarkup(MonthButton.getMonthButtonUz());
            text = year + " yil\nOyni tanlang";
        }
        if (profile.getLanguage().equals("RU")) {
            editMessageText.setReplyMarkup(MonthButton.getMonthButtonRu());
            text = year + " год\nВыберите месяц";
        }
        if (profile.getLanguage().equals("EN")) {
            editMessageText.setReplyMarkup(MonthButton.getMonthButtonEn());
            text = year + " year\nSelect a month";
        }
        editMessageText.setText(text);
        controller.myBot.sendEditMes(editMessageText);
    }

    public void handleMessage(CallbackQuery query) {
        String[] items = query.getData().split("/");
        if (items[2].equals("prev")) {
            AuthController.userMap.get(query.getFrom().getId()).setYear(null);
            controller.yearController.beginYearMessage(query);
        } else {
            AuthController.userMap.get(query.getFrom().getId()).setMonth(Integer.parseInt(items[3]));
            controller.dayController.beginDayMessage(query, items[2]);
        }

    }
}
