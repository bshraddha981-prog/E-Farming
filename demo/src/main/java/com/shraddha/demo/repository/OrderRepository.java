package com.shraddha.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shraddha.demo.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    // 👉 Buyer wise orders fetch करण्यासाठी
    List<Orders> findByBuyerName(String buyerName);
}