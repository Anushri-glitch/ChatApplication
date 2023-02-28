package com.Shrishti.chatApplication.Service;

import com.Shrishti.chatApplication.Dao.IStatusRepository;
import com.Shrishti.chatApplication.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    IStatusRepository statusRepository;

    public int saveStatus (Status status){
        Status statusObj = statusRepository.save(status);
        return statusObj.getStatusId();
    }
}
