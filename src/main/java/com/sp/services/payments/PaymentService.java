package com.sp.services.payments;

import com.sp.entities.Payment;
import com.sp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Iterable<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPayment(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

}
