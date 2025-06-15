package com.example.UrbanClone.service;

import com.example.UrbanClone.dto.LoginRequest;
import com.example.UrbanClone.dto.RegisterRequest;
import com.example.UrbanClone.entity.Customer;
import com.example.UrbanClone.entity.ServiceProvider;
import com.example.UrbanClone.entity.User;
import com.example.UrbanClone.repository.CustomerRepository;
import com.example.UrbanClone.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ServiceProviderRepository providerRepo;

    public User register(RegisterRequest req) {
        // Check if email already exists
        boolean emailExists = customerRepo.findByEmail(req.getEmail()) != null
                || providerRepo.findByEmail(req.getEmail()) != null;

        if (emailExists) {
            throw new RuntimeException("Email already in use.");
        }

        // Create appropriate subclass instance
        if (req.isProvider()) {
            ServiceProvider sp = new ServiceProvider();
            sp.setName(req.getName());
            sp.setEmail(req.getEmail());
            sp.setPassword(req.getPassword()); // ⚠️ Consider hashing in production
            sp.setLocation(req.getLocation());
            sp.setAvailable(true);
            sp.setWalletBalance(0.0);
            return providerRepo.save(sp);
        } else {
            Customer customer = new Customer();
            customer.setName(req.getName());
            customer.setEmail(req.getEmail());
            customer.setPassword(req.getPassword()); // ⚠️ Consider hashing in production
            customer.setLocation(req.getLocation());
            customer.setWalletBalance(0.0);
            return customerRepo.save(customer);
        }
    }

    public User login(LoginRequest req) {
        // Try logging in as customer
        Customer customer = customerRepo.findByEmail(req.getEmail());
        if (customer != null && customer.getPassword().equals(req.getPassword())) {
            return customer;
        }

        // Try logging in as service provider
        ServiceProvider provider = providerRepo.findByEmail(req.getEmail());
        if (provider != null && provider.getPassword().equals(req.getPassword())) {
            return provider;
        }

        // Invalid credentials
        return null;
    }
}
