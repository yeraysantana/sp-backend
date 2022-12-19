package com.sp.payloads.users;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLedgerEntryBalancePayload {
    Iterable<UserLedgerEntryBalance> balancesListPayload;
}
