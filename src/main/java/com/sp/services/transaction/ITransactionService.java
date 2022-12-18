package com.sp.services.transaction;

import com.sp.entities.Transaction;

import java.util.Optional;

public interface ITransactionService {
    Transaction addTransaction(Transaction user);
    Iterable<Transaction> getTransactions();
    Optional<Transaction> getTransaction(Long id);
}
