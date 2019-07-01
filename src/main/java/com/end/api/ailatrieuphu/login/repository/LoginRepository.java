package com.end.api.ailatrieuphu.login.repository;

import com.end.api.ailatrieuphu.login.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsernameAndPassword(String username, String password);

    UserModel findUserModelById(int id);

    UserModel findByUsername(String username);

    @Modifying
    @Query("update UserModel u set u.password = ?1 where u.username = ?2")
    int passwordRetrieval(String password, String username);
}
