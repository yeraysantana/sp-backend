package com.sp.services.transaction;

import com.sp.entities.Transaction;

import java.util.Optional;

public interface ITransactionService {
    Transaction addTransaction(Transaction transaction);
    Iterable<Transaction> getTransactions();
    Iterable<Transaction> getTransactionsByIdGroup(Long idGroup);
    Optional<Transaction> getTransaction(Long id);
}
