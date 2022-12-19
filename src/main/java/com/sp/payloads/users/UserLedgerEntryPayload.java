package com.sp.payloads.users;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLedgerEntryPayload {
    private String userName;
    private String groupName;
    private String description;
    private String ledgerEntryType;
    private int paymentAmount;
    private String createdAt;
}
