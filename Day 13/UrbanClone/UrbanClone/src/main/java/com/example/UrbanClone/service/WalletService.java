package com.example.UrbanClone.service;

import com.example.UrbanClone.entity.Customer;
import com.example.UrbanClone.entity.ServiceProvider;
import com.example.UrbanClone.entity.WalletTransaction;
import com.example.UrbanClone.repository.CustomerRepository;
import com.example.UrbanClone.repository.ServiceProviderRepository;
import com.example.UrbanClone.repository.WalletTransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class WalletService {
    @Autowired
    private WalletTransactionRepository walletRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ServiceProviderRepository providerRepo;
    public void addMoney(Long customerId, Double amount) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();
        customer.setWalletBalance(customer.getWalletBalance() + amount);
        customerRepo.save(customer);
        WalletTransaction tx = new WalletTransaction();
        tx.setUser(customer);
        tx.setAmount(amount);
        tx.setType("ADD");
        walletRepo.save(tx);

    }

    @Transactional
    public void makePayment(Long customerId, Long providerId, Double amount, String category) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();
        ServiceProvider provider = providerRepo.findById(providerId).orElseThrow();
        double feePercentage = category.equalsIgnoreCase("plumbing") ? 0.10 : 0.15;
        double handlingFee = amount * feePercentage;
        double amountToProvider = amount - handlingFee;
        if (customer.getWalletBalance() < amount) {
            throw new RuntimeException("Insufficient balance.");
        }

        customer.setWalletBalance(customer.getWalletBalance() - amount);
        provider.setWalletBalance(provider.getWalletBalance() + amountToProvider);
        customerRepo.save(customer);
        providerRepo.save(provider);
        WalletTransaction tx = new WalletTransaction();
        tx.setUser(customer);
        tx.setType("PAY");
        tx.setAmount(amount);
        tx.setHandlingFee(handlingFee);
        tx.setCategory(category);
        tx.setTimestamp(LocalDateTime.now());
        walletRepo.save(tx);

    }

    public void withdraw(Long providerId, Double amount) {
        ServiceProvider provider = providerRepo.findById(providerId).orElseThrow();
        if (provider.getWalletBalance() < amount) {
            throw new RuntimeException("Insufficient balance.");
        }
        provider.setWalletBalance(provider.getWalletBalance() - amount);
        providerRepo.save(provider);
        WalletTransaction tx = new WalletTransaction();
        tx.setUser(provider);
        tx.setAmount(amount);
        tx.setType("WITHDRAW");
        walletRepo.save(tx);

    }
}


