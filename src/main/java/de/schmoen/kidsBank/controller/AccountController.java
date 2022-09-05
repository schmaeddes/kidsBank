package de.schmoen.kidsBank.controller;

import de.schmoen.kidsBank.entity.Account;
import de.schmoen.kidsBank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public Account getAccountByNumber(Long number) {
        return accountService.getAccountByNumber(number);
    }


}
