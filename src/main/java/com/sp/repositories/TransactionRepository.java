package com.sp.repositories;

import com.sp.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

@org.springframework.stereotype.Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>, Repository<Transaction, Long> {}
