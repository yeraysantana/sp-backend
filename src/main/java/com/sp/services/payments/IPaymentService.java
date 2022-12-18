package com.sp.services.payments;

import com.sp.entities.Payment;

import java.util.Optional;

public interface IPaymentService {
    Payment addPayment(Payment user);
    Iterable<Payment> getPayments();
    Optional<Payment> getPayment(Long id);
}
