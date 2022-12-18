package com.sp.services.ledgerentries;

import com.sp.entities.LedgerEntry;
import com.sp.objects.UserLedgerEntryBalance;

import java.util.Optional;

public interface ILedgerEntryService {
    LedgerEntry addLedgerEntry(LedgerEntry user);
    Iterable<LedgerEntry> getLedgerEntries();
    Optional<LedgerEntry> getLedgerEntry(Long id);
    Iterable<UserLedgerEntryBalance>getUserLedgerEntriesBalancesByIdTransaction(Long idTransaction);
}
