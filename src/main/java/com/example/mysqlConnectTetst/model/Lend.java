package com.example.mysqlConnectTetst.model;

import java.time.Instant;
import javax.persistence.*;

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

}