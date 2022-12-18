package com.sp.controllers;

import java.util.Optional;

import com.sp.entities.Payment;
import com.sp.services.payments.IPaymentService;
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
public class PaymentController {
    private Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/payments")
    public Iterable<Payment> getPayments(){
        logger.info("-> PaymentController getPayments...");
        return paymentService.getPayments();
    }

    @GetMapping("/payment/{id}")
    public Optional<Payment> getPayment(@PathVariable Long id){
        logger.info("-> PaymentController getPaymentId: " + id);
        return paymentService.getPayment(id);
    }

    @PostMapping("/payment")
    public Payment addPayment(@RequestBody Payment payment){
        logger.info("-> PaymentController addPayment...");
        return paymentService.addPayment(payment);
    }
}
