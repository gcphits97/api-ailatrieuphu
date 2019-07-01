package com.end.api.ailatrieuphu.login.controller;

import com.end.api.ailatrieuphu.login.business.LoginBusiness;
import com.end.api.ailatrieuphu.login.dto.UserDTO;
import com.end.api.ailatrieuphu.login.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class LoginController {
    @Autowired
    LoginBusiness loginBusiness;
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserModel> login(@RequestBody UserDTO userDTO) {
        UserModel userModel = loginBusiness.login(userDTO);
        if (userModel == null) {
            return null;
        } else {
            return ResponseEntity.ok(userModel);
        }
    }

    @PostMapping(path = "/passwordRetrieval", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserModel> passwordRetrieval(@RequestBody UserDTO userDTO) {
        UserModel retrieval = loginBusiness.passwordRetrieval(userDTO);
        if (retrieval != null) {
            return ResponseEntity.status(HttpStatus.OK).body(retrieval);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
