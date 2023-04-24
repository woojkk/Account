package com.example.account.dto;


import com.example.account.domain.Account;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateAccount {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {      //public static//
        @NotNull
        @Min(1)
        private Long userId;    //사용자 아이디

        @NotNull
        @Min(0)
        private Long initialBalance;    //초기 잔액
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long userId;
        private String accountNumber;
        private LocalDateTime registeredAt;


        //응답정보(아이디,계좌번호,등록일시)
        public static Response from(AccountDto accountDto) {
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .registeredAt(accountDto.getRegisteredAt())
                    .build();
        }
    }
}
