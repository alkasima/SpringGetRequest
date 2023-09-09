package com.alkasima.getrequest.springgetrequest.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestController {

    LocalDateTime utcTime = LocalDateTime.now().plusHours(2); // UTC+2
    @GetMapping("/api/object")
    @ResponseBody
    public Object getObject() {
        Map<String, Object> object = new HashMap<>();
        object.put("slack_name", "Slack name here");
        object.put("current_day", "Current day");
        object.put("utc_time", utcTime);
        object.put("track", "B track nam");
        object.put("github_file_url", "htt url");
        object.put("github_repo_url", "git hub repo");
        object.put("status_code", "Code");
        return object;
    }
}
