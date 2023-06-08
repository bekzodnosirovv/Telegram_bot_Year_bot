package org.example.Button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class YearButton {
    public static final int LastYear = 1900;

    public static InlineKeyboardMarkup getYearButton(int beginYear) {
        int year = beginYear;
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            List<InlineKeyboardButton> row = new LinkedList<>();
            for (int j = 0; j < 3; j++) {
                InlineKeyboardButton button = new InlineKeyboardButton(String.valueOf(year));
                button.setCallbackData("/year/" + year);
                year++;
                if (year >= LastYear) row.add(button);
                if (year > Calendar.getInstance().getWeekYear()) {
                    break;
                }
            }
            if (year >= LastYear) rowList.add(row);
            if (year > Calendar.getInstance().getWeekYear()) {
                break;
            }
        }

        InlineKeyboardButton button1 = new InlineKeyboardButton(">>");
        button1.setCallbackData("/year/next/" + (beginYear + 9));
        InlineKeyboardButton button = new InlineKeyboardButton("<<");
        button.setCallbackData("/year/prev/" + (beginYear - 9));
        List<InlineKeyboardButton> navigation = new LinkedList<>();
        if (beginYear > LastYear) {
            navigation.add(button);
        }
        if (year < Calendar.getInstance().getWeekYear()) {
            navigation.add(button1);
        }
        rowList.add(navigation);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;


    }
}
