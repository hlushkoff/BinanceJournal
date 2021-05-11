package com.traider.journal.Controllers;


import com.traider.journal.Coin;
import com.traider.journal.System.Binance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class GreetingController {
    @Autowired
    Binance binance;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        Binance binance = new Binance();

        ArrayList<Coin> coins = binance.getUserBalance();
        model.addAttribute("UserCoins", coins);
        return "greeting";
    }


    @GetMapping("/coin/{name}")
    public String coinInfo(@PathVariable String name, Model model) {

        //Binance binance = new Binance();
        System.out.println(name);
        binance.getAllUserOrdersDone(name);

       // model.addAttribute("UserCoins", coins);
        return "greeting";
    }
}
