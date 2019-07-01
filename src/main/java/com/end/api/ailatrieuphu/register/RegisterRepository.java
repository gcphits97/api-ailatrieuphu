package com.end.api.ailatrieuphu.register;

import com.end.api.ailatrieuphu.login.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String Username);
}
