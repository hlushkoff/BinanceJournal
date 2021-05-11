package com.traider.journal.Repositories;

import com.traider.journal.Models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    public Trade findByOrderId(String id);
}
