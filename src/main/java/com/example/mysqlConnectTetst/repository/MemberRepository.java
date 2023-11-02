package com.example.mysqlConnectTetst.repository;

import com.example.mysqlConnectTetst.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
