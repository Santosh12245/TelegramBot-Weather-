package com.telegrambot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebResourcesRuntimeHints;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class SimpleBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("The Application  is .............");
        String city = update.getMessage().getText();
        WeatherService weatherService = new WeatherService();
        Pojo pojo = new Pojo();

        if (!city.isEmpty()) {
            if (city.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else if (!city.isEmpty()) {
                String command = update.getMessage().getText();
                pojo = weatherService.getWeather(command);
                if (pojo == null) {
                    SendMessage result = new SendMessage();
                    String charc = "Invalid City Name ";
                    result.setChatId(update.getMessage().getChatId().toString());
                    result.setText(charc);
                    try {
                        execute(result);

                    } catch (TelegramApiException e) {
                        e.getMessage();
                    }
                } else {
                    SendMessage responce = new SendMessage();
                    responce.setChatId(update.getMessage().getChatId().toString());
//                    String answer ="{\n"+ "\"name\"=" + "\""+pojo.getName() +"\""+  ",\n" + "\"Humidity\"=" +"\""+ pojo.getHumidity() +"\""+ ",\n" + "\"Pressure\"=" +"\""+ pojo.getPressure() + "\""+",\n" + "\"Temp\"=" +"\""+ pojo.getTemp()+"\""+"\n}";
                    String answer = String.format("{%n\"name\"=\"%s\",%n\"Humidity\"=\"%s\",%n\"Pressure\"=\"%s\",%n\"Temp\"=\"%s\"%n}",
                            pojo.getName(), pojo.getHumidity(), pojo.getPressure(), pojo.getTemp());
                    responce.setText(answer);
                    try {
                        execute(responce);

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }


            } else {
                SendMessage responce = new SendMessage();
                responce.setChatId(update.getMessage().getChatId().toString());
                responce.setText("Invalid Request");
                try {
                    execute(responce);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }


        }


    }


    @Override

    public String getBotUsername() {
        return "YWeqtherBot";
    }


    @Override

    public String getBotToken() {
        return "6773652930:AAGskXsbJUtM4_9asB4miO1KzGG_BCXYq7s";
    }


}
