package com.sp.controllers;

import com.sp.entities.Transaction;
import com.sp.services.transaction.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private ITransactionService transactionService;

}
