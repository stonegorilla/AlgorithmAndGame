package com.algorithm.game.domain;


import com.algorithm.game.util.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
