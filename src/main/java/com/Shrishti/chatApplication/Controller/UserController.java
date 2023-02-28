package com.Shrishti.chatApplication.Controller;

import com.Shrishti.chatApplication.Dao.IStatusRepository;
import com.Shrishti.chatApplication.Model.Status;
import com.Shrishti.chatApplication.Model.User;
import com.Shrishti.chatApplication.Utils.CommonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("api/v1/status")
public class UserController {

    @Autowired
    IStatusRepository statusRepository;


    @PostMapping("createUser")
    public ResponseEntity<String> createUser (@RequestBody String userData){
        JSONObject isValid = validateUser(userData);
        User user = new User();

        if(isValid.isEmpty()){
            user  = setUser(userData);
        }
        else{
            return new ResponseEntity<>(isValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }
    private JSONObject validateUser(String userData){
        JSONObject userJson = new JSONObject(userData);
        JSONObject errorList = new JSONObject();

        if(userJson.has("userName")){
            String UserName = userJson.getString("userName");
        }
        else{
            errorList.put("userName", "Missing Parameter");
        }

        if(userJson.has("Password")){
            String password = userJson.getString("Password");
            if(!CommonUtils.isValidPassword(password)){
                errorList.put("password", "Please Enter the valid password , Ex : Anushka@1234");
            }
        }
        else{
            errorList.put("Password", "Missing Password");
        }

        if(userJson.has("firstName")){
            String firstName = userJson.getString("firstName");
        }
        else{
            errorList.put("firstName", "Missing UserName");
        }

        if(userJson.has("Email")){
            String Email = userJson.getString("Email");
            if(!CommonUtils.isValidEmail(Email)){
                errorList.put("Email", "Please Enter valid Email");
            }
        }
        else{
            errorList.put("Email", "Missing Email");
        }

        if(userJson.has("phoneNumber")){
            String phone = userJson.getString("phoneNumber");
            if(!CommonUtils.isValidPhoneNumber(phone)){
                errorList.put("phoneNumber", "Please Enter Valid Phone Number");
            }
        }
        else{
            errorList.put("phoneNUmber", "Missing phonenUmber");
        }

        if(userJson.has("age")){
            Integer Age = userJson.getInt("age");
        }
        else{
            errorList.put("age", "Missing age");
        }
        return errorList;
    }

    private User setUser(String userData){
        User user = new User();
        JSONObject json = new JSONObject(userData);

        user.setEmail(json.getString("Email"));
        user.setPassword(json.getString("Password"));
        user.setFirstName(json.getString("firstName"));
        user.setUsername(json.getString("userName"));
        user.setPhoneNumber(json.getString("phoneNumber"));

        if(json.has("age")){
            user.setAge(json.getInt("age"));
        }
        if(json.has("lastName")){
            user.setLastName(json.getString("lastname"));
        }
        if(json.has("Gender")){
            user.setGender(json.getString("Gender"));
        }

        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        user.setCreatedDate(createdDate);

        Status status = statusRepository.findById(1).get();
        user.setStatusId(status);
        return user;
    }
}
