package com.sp.controllers;

import java.util.Optional;

import com.sp.entities.LedgerEntry;
import com.sp.objects.UserLedgerEntryBalance;
import com.sp.services.ledgerentries.ILedgerEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class LedgerEntryController {
    private Logger logger = LoggerFactory.getLogger(LedgerEntryController.class);

    @Autowired
    private ILedgerEntryService ledgerEntryService;

    @GetMapping("/payments")
    public Iterable<LedgerEntry> getLedgerEntries(){
        logger.info("-> LedgerEntriesController getLedgerEntries...");
        return ledgerEntryService.getLedgerEntries();
    }

    @GetMapping("/payment/{id}")
    public Optional<LedgerEntry> getLedgerEntry(@PathVariable Long id){
        logger.info("-> LedgerEntriesController getLedgerEntryId: " + id);
        return ledgerEntryService.getLedgerEntry(id);
    }

    @GetMapping("/payments/{id}/balance")
    public Iterable<UserLedgerEntryBalance> getUserLedgerEntriesBalancesByIdTransaction(@PathVariable Long id){
        logger.info("-> LedgerEntriesController getUserLedgerEntriesBalanceByIdTransaction: " + id);
        return ledgerEntryService.getUserLedgerEntriesBalancesByIdTransaction(id);
    }

    @PostMapping("/payment")
    public LedgerEntry addLedgerEntry(@RequestBody LedgerEntry ledgerEntry){
        logger.info("-> LedgerEntriesController addLedgerEntry...");
        return ledgerEntryService.addLedgerEntry(ledgerEntry);
    }
}
