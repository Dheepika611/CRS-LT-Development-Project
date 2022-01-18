package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
