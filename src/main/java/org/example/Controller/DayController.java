package org.example.Controller;

import org.example.Button.DayButton;
import org.example.Button.MonthButton;
import org.example.Repository.Repository;
import org.example.dto.Profile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayController {
    AuthController controller;

    public DayController(AuthController controller) {
        this.controller = controller;
    }

    public void handleMessage(CallbackQuery query) {
        int month1 = AuthController.userMap.get(query.getFrom().getId()).getMonth();
        String[] items = query.getData().split("/");
        if (items[2].equals("prev")) {
            AuthController.userMap.get(query.getFrom().getId()).setMonth(null);
            controller.monthController.beginMonthMessage(query, month1);
        }else {
            Profile profile = AuthController.userMap.get(query.getFrom().getId());
            profile.setDay(Integer.parseInt(items[2]));
            int year = profile.getYear();
            int month = profile.getMonth() - 1;
            int day = profile.getDay();
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            String text = getText(getTime(profile));
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(query.getMessage().getChatId());
            sendMessage.setText(text);
            controller.myBot.sendMes(sendMessage);
            new Repository().writeResult(query.getMessage().getChatId(), getTime(profile));

        }
    }

    public String getText(String text) {
        String[] strArr = text.split("#");
        StringBuilder builder = new StringBuilder();
        for (String tex : strArr) {
            builder.append(tex).append("\n");
        }
        return builder.toString();
    }

    public String getTime(Profile profile) {
        String dateStart = profile.getYear() + "/" + profile.getMonth() + "/" + profile.getDay() + "/" + "00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd/HH:mm:ss");

        Date d1 = null;
        Date d2 = new Date();
        try {
            d1 = format.parse(dateStart);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert d1 != null;
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (60 * 60 * 1000 * 24);
        long diffWeeks = diff / (60 * 60 * 1000 * 24 * 7);
        long diffMonths = (long) (diff / (60 * 60 * 1000 * 24 * 30.41666666));
        long diffYears = diff / ((long) 60 * 60 * 1000 * 24 * 365);
        StringBuilder builder = new StringBuilder();
        if (profile.getLanguage().equals("UZ")) {
            builder.append(" Jami#");
            builder.append(diffYears).append(" yil#");
            builder.append(diffMonths).append(" oy#");
            builder.append(diffWeeks).append(" hafta#");
            builder.append(diffDays).append(" kun#");
            builder.append(diffHours).append(" soat#");
            builder.append(diffMinutes).append(" minut#");
            builder.append(diffSeconds).append(" sekund#");
        }
        if (profile.getLanguage().equals("RU")) {
            builder.append(" Общий#");
            builder.append(diffYears).append(" годах#");
            builder.append(diffMonths).append(" месяцах#");
            builder.append(diffWeeks).append(" неделях#");
            builder.append(diffDays).append(" днях#");
            builder.append(diffHours).append(" часах#");
            builder.append(diffMinutes).append(" минутах#");
            builder.append(diffSeconds).append(" секундах#");
        }
        if (profile.getLanguage().equals("EN")) {
            builder.append(" Totals#");
            builder.append(diffYears).append(" years#");
            builder.append(diffMonths).append(" months#");
            builder.append(diffWeeks).append(" weeks#");
            builder.append(diffDays).append(" days#");
            builder.append(diffHours).append(" hours#");
            builder.append(diffMinutes).append(" minutes#");
            builder.append(diffSeconds).append(" seconds#");
        }
        return builder.toString();
    }

    public void beginDayMessage(CallbackQuery query, String item) {
        String text = "";
        Profile profile = AuthController.userMap.get(query.getFrom().getId());
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(query.getMessage().getChatId());
        editMessageText.setMessageId(query.getMessage().getMessageId());
        if (profile.getLanguage().equals("UZ")) {
            editMessageText.setReplyMarkup(DayButton.getDayButton(profile.getYear(), profile.getMonth() - 1));
            text = item + "\nKunni tanlang";
        }
        if (profile.getLanguage().equals("RU")) {
            editMessageText.setReplyMarkup(DayButton.getDayButton(profile.getYear(), profile.getMonth() - 1));
            text = item + "\nВыберите день";
        }
        if (profile.getLanguage().equals("EN")) {
            editMessageText.setReplyMarkup(DayButton.getDayButton(profile.getYear(), profile.getMonth() - 1));
            text = item + "\nSelect a day";
        }
        editMessageText.setText(text);
        controller.myBot.sendEditMes(editMessageText);

    }
}
