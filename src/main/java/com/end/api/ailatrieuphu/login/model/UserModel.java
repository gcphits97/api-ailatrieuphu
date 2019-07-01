package com.end.api.ailatrieuphu.login.model;

import com.end.api.ailatrieuphu.highscore.HighScoreModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @JsonIgnore
    @OneToMany(mappedBy = "userModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HighScoreModel> highScoreModelList = new ArrayList<>();
}
