package de.schmoen.kidsBank.service;

import de.schmoen.kidsBank.entity.Account;
import de.schmoen.kidsBank.entity.Transaction;
import de.schmoen.kidsBank.repository.AccountRepository;
import de.schmoen.kidsBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class DataBaseFillerService implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public DataBaseFillerService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Account firstAccount = new Account();
        firstAccount.setNumber(123456789L);
        firstAccount.setOwner("Alina");
        firstAccount.setBalance(BigDecimal.valueOf(10.5));
        firstAccount.setPin("1234");
        accountRepository.save(firstAccount);

        Account secondAccount = new Account();
        secondAccount.setNumber(987654321L);
        secondAccount.setOwner("Joris");
        secondAccount.setBalance(BigDecimal.valueOf(15L));
        secondAccount.setPin("4321");
        accountRepository.save(secondAccount);

        Transaction firstTransaction = new Transaction();
        firstTransaction.setAccountNumber(123456789L);
        firstTransaction.setAmount(BigDecimal.valueOf(4L));
        firstTransaction.setTime(LocalDateTime.now());
        firstTransaction.setOldAmount(BigDecimal.valueOf(10));
        firstTransaction.setNewAmount(BigDecimal.valueOf(6));
        firstTransaction.setDetail("Ausgabe");
        transactionRepository.save(firstTransaction);

        Transaction secondTransaction = new Transaction();
        secondTransaction.setAccountNumber(123456789L);
        secondTransaction.setAmount(BigDecimal.valueOf(10L));
        secondTransaction.setTime(LocalDateTime.now());
        secondTransaction.setOldAmount(BigDecimal.valueOf(6));
        secondTransaction.setNewAmount(BigDecimal.valueOf(16));
        secondTransaction.setDetail("Einzahlung");
        transactionRepository.save(secondTransaction);

        Transaction thirdTransaction = new Transaction();
        thirdTransaction.setAccountNumber(987654321L);
        thirdTransaction.setAmount(BigDecimal.valueOf(2L));
        thirdTransaction.setTime(LocalDateTime.now());
        thirdTransaction.setOldAmount(BigDecimal.valueOf(12));
        thirdTransaction.setNewAmount(BigDecimal.valueOf(10));
        thirdTransaction.setDetail("Auszahlung");
        transactionRepository.save(thirdTransaction);
    }
}
