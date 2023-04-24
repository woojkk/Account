package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//데이터베이스
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // 데이터베이스 설정 파일(클래스)
@EntityListeners(AuditingEntityListener.class)  // 그냥 적고 끝아니고 추가
public class Account extends BaseEntity {      //테이블
    @ManyToOne
    private AccountUser accountUser; // 그냥유저는 중복될 수 있음
    private String accountNumber;

    @Enumerated(EnumType.STRING)    //0123같은 값 말고 실제 문자열이름
    private AccountStatus accountStatus;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;


    public void useBalance(Long amount) {   //잔액 사용
        if (amount > balance) {     //잔액보다 결제금액이 크면 예외발생
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }

    public void cancelBalance(Long amount) {    //잔액 사용 취소
        if (amount < 0) {
            throw new AccountException(ErrorCode.INVALID_REQUEST);
        }
        balance += amount;
    }
}
