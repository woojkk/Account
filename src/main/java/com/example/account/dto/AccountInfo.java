package com.example.account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo {  //클라이언트와 어플리케이션 간에 응답
    private String accountNumber;
    private Long balance;
}
