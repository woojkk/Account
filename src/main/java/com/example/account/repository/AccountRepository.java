package com.example.account.repository;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findFirstByOrderByIdDesc();   //최근생성 계좌 조회

    Integer countByAccountUser(AccountUser accountUser);    //해당유저의 계좌 수

    Optional<Account> findByAccountNumber(String AccountNumber);    //계좌번호의 계좌 조회

    List<Account> findByAccountUser(AccountUser accountUser);   //유저 계좌정보 조회

    boolean existsByAccountNumber(String newAccountNumber); //같은번호의 계좌가 존재하는지 조회
}
