package com.example.UrbanClone.controller;

import com.example.UrbanClone.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/add")
    public String addMoney(@RequestParam Long customerId, @RequestParam Double amount) {
        walletService.addMoney(customerId, amount);
        return "Amount added.";
    }

    @PostMapping("/pay")
    public String makePayment(@RequestParam Long customerId, @RequestParam Long providerId,
                              @RequestParam Double amount, @RequestParam String category) {
        walletService.makePayment(customerId, providerId, amount, category);
        return "Payment successful.";

    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long providerId, @RequestParam Double amount) {
        walletService.withdraw(providerId, amount);
        return "Withdrawal successful.";
    }

}

