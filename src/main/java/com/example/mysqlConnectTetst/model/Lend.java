package com.example.mysqlConnectTetst.model;

import java.time.Instant;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lend")
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant startOn;
    private Instant dueOn;

    @Enumerated(EnumType.ORDINAL)
    private LendStatus status;

    @ManyToOne //1개의 책을 여러번 빌릴 수 있음
    @JoinColumn(name = "book_id") //FK
    @JsonManagedReference //양방향 참조에서 무한 참조 막기 위한 애노테이션
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonManagedReference
    private Member member;


}