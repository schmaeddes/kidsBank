package de.schmoen.kidsBank;

import de.schmoen.kidsBank.entity.Account;
import de.schmoen.kidsBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping()
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }


}
