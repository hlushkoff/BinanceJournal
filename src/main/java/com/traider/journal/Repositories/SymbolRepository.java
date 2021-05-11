package com.traider.journal.Repositories;

import com.traider.journal.Models.Symbol;
import com.traider.journal.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    Symbol findByNameIgnoreCase(String name);
}
