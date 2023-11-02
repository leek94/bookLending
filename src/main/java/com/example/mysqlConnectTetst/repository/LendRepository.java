package com.example.mysqlConnectTetst.repository;

import com.example.mysqlConnectTetst.model.Book;
import com.example.mysqlConnectTetst.model.Lend;
import com.example.mysqlConnectTetst.model.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
