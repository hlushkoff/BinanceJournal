package com.traider.journal.Services;


import com.traider.journal.Models.Symbol;
import com.traider.journal.Repositories.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SymbolService {

    @Autowired
    private SymbolRepository symbolRepository;


    public List<Symbol> getAllSymbols()
    {
        List<Symbol> symbols = new ArrayList<Symbol>();
        symbolRepository.findAll().forEach(symbol -> symbols.add(symbol));
        return symbols;
    }

    public Symbol getSymbolById(long id)
    {
        return symbolRepository.findById(id).get();
    }

        public Symbol getByName(String name){

            return symbolRepository.findByNameIgnoreCase(name);
        }

    public void saveOrUpdate(Symbol symbol)
    {
        symbolRepository.save(symbol);
    }
    }
