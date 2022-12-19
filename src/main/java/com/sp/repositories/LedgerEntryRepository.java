package com.sp.repositories;

import com.sp.entities.LedgerEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

@org.springframework.stereotype.Repository
public interface LedgerEntryRepository extends CrudRepository<LedgerEntry, Long>, Repository<LedgerEntry, Long> {
    ArrayList<LedgerEntry> findByIdTransaction(Long idTransaction);
    ArrayList<LedgerEntry> findByIdGroup(Long idGroup);
}
