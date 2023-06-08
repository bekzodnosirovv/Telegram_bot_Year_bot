package org.example.Button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class LanguageButton {


    public InlineKeyboardMarkup getLanguageButton() {
        InlineKeyboardButton button = new InlineKeyboardButton("\uD83C\uDDFA\uD83C\uDDFFUZ");
        button.setCallbackData("/til/uz");
        InlineKeyboardButton button1 = new InlineKeyboardButton("\uD83C\uDDF7\uD83C\uDDFARU");
        button1.setCallbackData("/til/ru");
        InlineKeyboardButton button2 = new InlineKeyboardButton("\uD83C\uDDFA\uD83C\uDDF8EN");
        button2.setCallbackData("/til/en");

        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(button);
        row.add(button1);
        row.add(button2);
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }



}
