package de.schmoen.kidsBank.service;

import de.schmoen.kidsBank.entity.Account;
import de.schmoen.kidsBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account getAccountByNumber(Long number) {
        Optional<Account> optionalAccount = accountRepository.findByNumber(number);
        return optionalAccount.orElseGet(optionalAccount::get);
    }

}
