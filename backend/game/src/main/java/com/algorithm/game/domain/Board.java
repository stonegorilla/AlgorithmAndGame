package com.algorithm.game.domain;


import com.algorithm.game.util.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="board")
@Getter
@Setter
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_seq")
    private Long boardSeq;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;



    @JoinColumn(name="user_seq",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Builder
    public Board(Long boardSeq, String title, String content, User user) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
