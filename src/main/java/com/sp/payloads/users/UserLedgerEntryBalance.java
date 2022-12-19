package com.sp.payloads.users;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLedgerEntryBalance {
    private String userName;
    private String groupName;
    private String description;
    private String ledgerEntryType;
    private int paymentAmount;
    private String createdAt;
}
