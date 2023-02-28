package com.Shrishti.chatApplication.Controller;

import com.Shrishti.chatApplication.Model.Status;
import com.Shrishti.chatApplication.Service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ChatApp")
public class StatusController {

    @Autowired
    StatusService statusService;

    @PostMapping("status")
    public ResponseEntity<String> createStatus (@RequestBody String statusData){
        Status status = setStatus(statusData);
        int statusId = statusService.saveStatus(status);
        return new ResponseEntity<>("status saved - " + statusId, HttpStatus.CREATED);
    }

    private Status setStatus(String statusData){
        Status status = new Status();
        JSONObject json = new JSONObject(statusData);

        String statusName = json.getString("statusname");
        String statusDesc = json.getString("statusDescription");

        status.setStatusName(statusName);
        status.setStatusDescription(statusDesc);

        return status;
    }
}
