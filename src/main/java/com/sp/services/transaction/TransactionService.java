package com.sp.services.transaction;

import com.sp.entities.Transaction;
import com.sp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Iterable<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction addTransaction(Transaction payment) {
        return transactionRepository.save(payment);
    }

//    @Override
//    public Iterable<UserTransactionBalance> getUserTransactionBalance(Long idTransaction) {
//        ArrayList<UserTransactionBalance> userTransactionBalanceList = new ArrayList<>();
//        Iterable<Transaction> payments = getTransactions();
//
//        payments.forEach(payment -> {
//
//        });
//
//
//        return userTransactionBalanceList;
//    }
}
