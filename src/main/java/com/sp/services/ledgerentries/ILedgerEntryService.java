package com.sp.services.ledgerentries;

import com.sp.entities.LedgerEntry;
import com.sp.payloads.users.UserLedgerEntryBalancePayload;
import com.sp.payloads.users.UserLedgerEntryPayload;

import java.util.Optional;

public interface ILedgerEntryService {
    LedgerEntry addLedgerEntry(LedgerEntry user);
    Iterable<LedgerEntry> getLedgerEntries();
    Optional<LedgerEntry> getLedgerEntry(Long id);
    Iterable<UserLedgerEntryPayload> getUserLedgerEntriesByIdTransaction(Long idTransaction);
    Iterable<UserLedgerEntryBalancePayload> getUserLedgerEntriesBalancesByIdGroup(Long idGroup);
}
