package com.traider.journal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.traider.journal.Models.Symbol;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    Symbol findByNameIgnoreCase(String name);
}
