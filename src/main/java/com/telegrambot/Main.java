package com.telegrambot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Main {
    public static  void main(String [] args){
        try{
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);


                botsApi.registerBot(new SimpleBot());


        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
