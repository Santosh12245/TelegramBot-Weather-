package com.telegrambot;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class WeatherService {




  public Pojo getWeather(String city){
      RestTemplate restTemplate = new RestTemplate() ;
      String apikey = "6dd4faaa921670cbc86bb13da963a0ac" ;
    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey;

     try{
         JsonNode node = restTemplate.getForObject(url , JsonNode.class) ;
         System.out.println(node);

         Double temp = node.path("main").path("temp").asDouble() ;
         int humidity = node.path("main").path("temp").asInt() ;
         int cloud = node.path("main").path("all").intValue() ;
         int pressure = node.path("main").path("pressure").asInt() ;
         String name = node.path("name").asText() ;
         Pojo pojo = new Pojo() ;

         pojo.setCloud(cloud);
         pojo.setHumidity(humidity);
         pojo.setName(name);
         pojo.setTemp(temp);
         pojo.setPressure(pressure);


         System.out.println(pojo.getCloud());
         System.out.println(pojo.getPressure());
         System.out.println(pojo.getName());
         System.out.println(pojo.getHumidity());
         System.out.println(pojo.getTemp());

          return pojo ;
     }catch (Exception e){
         System.out.println(e.getMessage());
   return null ;
     }


  }

}

//    @Autowired
//    public RestTemplate restTemplate ;
//    @Autowired
//    public Pojo pojo ;
//public Pojo getWeather(String city){
//
//    String apikey = "6dd4faaa921670cbc86bb13da963a0ac" ;
//    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey;
//
//     try{
//         JsonNode  node = restTemplate.getForObject(url , JsonNode.class) ;
//         System.out.println(node);
//         Double temp = node.path("main").path("temp").asDouble() ;
//         int humidity = node.path("main").path("temp").asInt() ;
//         int cloud = node.path("main").path("all").intValue() ;
//         int pressure = node.path("main").path("pressure").asInt() ;
//         String name = node.path("name").asText() ;
//
//         pojo.setCloud(cloud);
//         pojo.setHumidity(humidity);
//         pojo.setName(name);
//         pojo.setTemp(temp);
//         pojo.setPressure(pressure);
//
//    return pojo;
//
//     }catch (Exception e){
//         System.out.println(e.getMessage());
//         return null ;
//     }
//
//






