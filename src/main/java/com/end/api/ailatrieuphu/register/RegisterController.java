package com.end.api.ailatrieuphu.register;

import com.end.api.ailatrieuphu.login.dto.UserDTO;
import com.end.api.ailatrieuphu.login.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class RegisterController {
    @Autowired
    RegisterBusiness registerBusiness;

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserModel> register(@RequestBody UserDTO userDTO) {
        UserModel userModel = registerBusiness.createUser(userDTO);
        if (userModel == null) {
            return null;
        } else {
            return ResponseEntity.ok(userModel);
        }
    }
}
