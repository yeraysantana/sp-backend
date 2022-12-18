package com.sp.objects;

import com.sp.entities.Group;
import com.sp.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLedgerEntryBalance {
    private Optional<User> user;
    private Optional<Group> group;
    private String ledgerEntryType;
    private int paymentAmount;
}
