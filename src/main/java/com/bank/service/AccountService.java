package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return repository.findById(id);
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Account account = repository.findById(id).orElseThrow();
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setName(accountDetails.getName());
        account.setEmail(accountDetails.getEmail());
        account.setType(accountDetails.getType());
        account.setBalance(accountDetails.getBalance());
        account.setBranch(accountDetails.getBranch());
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
