/**
 *
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.repository.AccountsRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eazy Bytes
 *
 */

@RestController
@RequestMapping("accounts")
public class AccountsController {

    private final AccountsRepository accountsRepository;

    public AccountsController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @GetMapping("")
    @Timed(value = "getAccountDetails.time", description = "Time taken to return account detail")
    public Accounts getAccountDetails(@RequestParam Integer custId) {
        return accountsRepository.findByCustomerId(custId);
    }

}
