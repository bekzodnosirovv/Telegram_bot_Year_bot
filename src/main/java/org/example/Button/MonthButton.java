package org.example.Button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MonthButton {

    public static InlineKeyboardMarkup getMonthButtonUz() {
        InlineKeyboardButton yanvar = new InlineKeyboardButton("Yanvar");
        yanvar.setCallbackData("/month/Yanvar/01");
        InlineKeyboardButton fevral = new InlineKeyboardButton("Fevral");
        fevral.setCallbackData("/month/Fevral/02");
        InlineKeyboardButton mart = new InlineKeyboardButton("Mart");
        mart.setCallbackData("/month/Mart/03");
        InlineKeyboardButton aprel = new InlineKeyboardButton("Aprel");
        aprel.setCallbackData("/month/Aprel/04");
        InlineKeyboardButton may = new InlineKeyboardButton("May");
        may.setCallbackData("/month/May/05");
        InlineKeyboardButton iyun = new InlineKeyboardButton("Iyun");
        iyun.setCallbackData("/month/Iyun/06");
        InlineKeyboardButton iyul = new InlineKeyboardButton("Iyul");
        iyul.setCallbackData("/month/Iyul/07");
        InlineKeyboardButton avgust = new InlineKeyboardButton("Avgust");
        avgust.setCallbackData("/month/Avgust/08");
        InlineKeyboardButton sentyabr = new InlineKeyboardButton("Sentyabr");
        sentyabr.setCallbackData("/month/Sentyabr/09");
        InlineKeyboardButton oktyabr = new InlineKeyboardButton("Oktyabr");
        oktyabr.setCallbackData("/month/Oktyabr/10");
        InlineKeyboardButton noyabr = new InlineKeyboardButton("Noyabr");
        noyabr.setCallbackData("/month/Noyabr/11");
        InlineKeyboardButton dekabr = new InlineKeyboardButton("Dekabr");
        dekabr.setCallbackData("/month/Dekabr/12");
        InlineKeyboardButton prev = new InlineKeyboardButton("<<<");
        prev.setCallbackData("/month/prev");
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(yanvar);
        row.add(fevral);
        row.add(mart);
        row.add(aprel);
        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(may);
        row1.add(iyun);
        row1.add(iyul);
        row1.add(avgust);
        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(sentyabr);
        row2.add(oktyabr);
        row2.add(noyabr);
        row2.add(dekabr);
        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(prev);
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getMonthButtonRu() {
        InlineKeyboardButton yanvar = new InlineKeyboardButton("Январь");
        yanvar.setCallbackData("/month/Январь/01");
        InlineKeyboardButton fevral = new InlineKeyboardButton("Февраль");
        fevral.setCallbackData("/month/Февраль/02");
        InlineKeyboardButton mart = new InlineKeyboardButton("Март");
        mart.setCallbackData("/month/Март/03");
        InlineKeyboardButton aprel = new InlineKeyboardButton("Апрель");
        aprel.setCallbackData("/month/Апрель/04");
        InlineKeyboardButton may = new InlineKeyboardButton("Май");
        may.setCallbackData("/month/Май/05");
        InlineKeyboardButton iyun = new InlineKeyboardButton("Июнь");
        iyun.setCallbackData("/month/Июнь/06");
        InlineKeyboardButton iyul = new InlineKeyboardButton("Июль");
        iyul.setCallbackData("/month/Июль/07");
        InlineKeyboardButton avgust = new InlineKeyboardButton("Август");
        avgust.setCallbackData("/month/Август/08");
        InlineKeyboardButton sentyabr = new InlineKeyboardButton("Сентябрь");
        sentyabr.setCallbackData("/month/Сентябрь/09");
        InlineKeyboardButton oktyabr = new InlineKeyboardButton("Октябрь");
        oktyabr.setCallbackData("/month/Октябрь/10");
        InlineKeyboardButton noyabr = new InlineKeyboardButton("Ноябрь");
        noyabr.setCallbackData("/month/Ноябрь/11");
        InlineKeyboardButton dekabr = new InlineKeyboardButton("Декабрь");
        dekabr.setCallbackData("/month/Декабрь/12");
        InlineKeyboardButton prev = new InlineKeyboardButton("<<<");
        prev.setCallbackData("/month/prev");
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(yanvar);
        row.add(fevral);
        row.add(mart);
        row.add(aprel);
        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(may);
        row1.add(iyun);
        row1.add(iyul);
        row1.add(avgust);
        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(sentyabr);
        row2.add(oktyabr);
        row2.add(noyabr);
        row2.add(dekabr);
        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(prev);
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getMonthButtonEn() {
        InlineKeyboardButton yanvar = new InlineKeyboardButton("January");
        yanvar.setCallbackData("/month/January/01");
        InlineKeyboardButton fevral = new InlineKeyboardButton("February");
        fevral.setCallbackData("/month/February/02");
        InlineKeyboardButton mart = new InlineKeyboardButton("March");
        mart.setCallbackData("/month/March/03");
        InlineKeyboardButton aprel = new InlineKeyboardButton("April");
        aprel.setCallbackData("/month/April/04");
        InlineKeyboardButton may = new InlineKeyboardButton("May");
        may.setCallbackData("/month/May/05");
        InlineKeyboardButton iyun = new InlineKeyboardButton("June");
        iyun.setCallbackData("/month/June/06");
        InlineKeyboardButton iyul = new InlineKeyboardButton("July");
        iyul.setCallbackData("/month/July/07");
        InlineKeyboardButton avgust = new InlineKeyboardButton("August");
        avgust.setCallbackData("/month/August/08");
        InlineKeyboardButton sentyabr = new InlineKeyboardButton("September");
        sentyabr.setCallbackData("/month/September/09");
        InlineKeyboardButton oktyabr = new InlineKeyboardButton("October");
        oktyabr.setCallbackData("/month/October/10");
        InlineKeyboardButton noyabr = new InlineKeyboardButton("November");
        noyabr.setCallbackData("/month/November/11");
        InlineKeyboardButton dekabr = new InlineKeyboardButton("December");
        dekabr.setCallbackData("/month/December/12");
        InlineKeyboardButton prev = new InlineKeyboardButton("<<<");
        prev.setCallbackData("/month/prev");
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(yanvar);
        row.add(fevral);
        row.add(mart);
        row.add(aprel);
        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(may);
        row1.add(iyun);
        row1.add(iyul);
        row1.add(avgust);
        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(sentyabr);
        row2.add(oktyabr);
        row2.add(noyabr);
        row2.add(dekabr);
        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(prev);
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

}
