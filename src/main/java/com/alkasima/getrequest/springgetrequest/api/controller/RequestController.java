package com.alkasima.getrequest.springgetrequest.api.controller;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class RequestController {


    @GetMapping("/api/slack")
    @ResponseBody
   public Object getObject(@RequestParam("slack_name") String slackName, @RequestParam("track") String track) {

         // Get the current time in UTC+2
         LocalDateTime utcTime = LocalDateTime.now().plusHours(2);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
         String formattedUtcTime = utcTime.format(formatter);

         //Variable for github file and repo
         String git_repo_url = "https://github.com/alkasima/SpringGetRequest";
         String git_file_ulr = "https://github.com/alkasima/SpringGetRequest/blob/main/src/main/java/com/alkasima/getrequest/springgetrequest/api/controller/RequestController.java";

         //Get current day
         LocalDate currentDate = LocalDate.now();
         DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
         String dayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);


         //Build object for output
         Map<String, Object> object = new LinkedHashMap<>();
         object.put("slack_name", slackName);
         object.put("current_day", dayName);
         object.put("utc_time", formattedUtcTime);
         object.put("track", track);
         object.put("github_file_url", git_file_ulr);
         object.put("github_repo_url", git_repo_url);
         object.put("status_code", 200); // Use an integer for the status_code

         // Convert the LinkedHashMap to a JSON string
         String jsonString = "{" + object.entrySet().stream()
                 .map(entry -> "\"" + entry.getKey() + "\": " + entry.getValue())
                 .reduce((entry1, entry2) -> entry1 + ", " + entry2)
                 .orElse("") + "}";

          return jsonString;

    }
}
