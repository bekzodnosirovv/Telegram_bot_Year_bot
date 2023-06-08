package org.example.Button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class DayButton {
    public static final int beginDay = 1;

    public static InlineKeyboardMarkup getDayButton(int year, int month) {
        int day = beginDay;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            List<InlineKeyboardButton> row = new LinkedList<>();
            for (int j = 0; j < 7; j++) {
                if (day <= numberOfDays) {
                    InlineKeyboardButton button = new InlineKeyboardButton(String.valueOf(day));
                    button.setCallbackData("/day/" + day++);
                    row.add(button);
                } else {
                    InlineKeyboardButton button = new InlineKeyboardButton(" ");
                    button.setCallbackData("/day/");
                    row.add(button);
                }
            }
            rowList.add(row);
        }
        InlineKeyboardButton button = new InlineKeyboardButton("<<<");
        button.setCallbackData("/day/prev");
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(button);
        rowList.add(row);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
