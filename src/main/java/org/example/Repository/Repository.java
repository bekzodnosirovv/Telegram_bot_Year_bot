package org.example.Repository;

import java.io.*;

public class Repository {
    public void writeResult(Long chatId, String text) {
        StringBuilder builder = new StringBuilder();
        builder.append(chatId).append("#").append(text);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("profile.txt", true));
            printWriter.println(builder);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String readResult(Long id) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("profile.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split("#");
                if (String.valueOf(id).equals(str[0])) {
                    for (int i = 1; i < str.length; i++) {
                        builder.append(str[i]).append("\n");
                    }
                    builder.append("\n\n");
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }
}
