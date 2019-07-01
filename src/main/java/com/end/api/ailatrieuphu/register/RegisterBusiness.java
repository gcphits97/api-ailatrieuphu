package com.end.api.ailatrieuphu.register;

import com.end.api.ailatrieuphu.login.dto.UserDTO;
import com.end.api.ailatrieuphu.login.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterBusiness {
    @Autowired
    RegisterRepository registerRepository;

    public UserModel createUser(UserDTO userDTO) {
        UserModel userExist = registerRepository.findByUsername(userDTO.getUsername());
        if (userExist == null) {
            UserModel user = new UserModel();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setFullname(userDTO.getFullname());

            UserModel userModel = registerRepository.save(user);

            if (userModel != null) {
                return userModel;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
