package com.algorithm.game.domain;


import com.algorithm.game.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_seq")
    private Long userSeq;

    @Column(name="password")
    private String password;

    @Column(name="email",unique = true)
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="nickname")
    private String nickname;

    @Builder
    public User(Long userSeq, String password, String email, String name, String nickname) {
        this.userSeq = userSeq;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }
}
