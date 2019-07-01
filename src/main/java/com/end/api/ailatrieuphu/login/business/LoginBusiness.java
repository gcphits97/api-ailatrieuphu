package com.end.api.ailatrieuphu.login.business;

import com.end.api.ailatrieuphu.login.dto.UserDTO;
import com.end.api.ailatrieuphu.login.model.UserModel;
import com.end.api.ailatrieuphu.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginBusiness {
    @Autowired
    private LoginRepository loginRepository;

    public UserModel login(UserDTO userDTO) {
        return loginRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }

    @Transactional
    public UserModel passwordRetrieval(UserDTO userDTO) {
        UserModel userModel = loginRepository.findByUsername(userDTO.getUsername());
        if (userModel != null) {
            int i = loginRepository.passwordRetrieval(userDTO.getPassword(), userDTO.getUsername());
            if (i == 1) {
                return loginRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
