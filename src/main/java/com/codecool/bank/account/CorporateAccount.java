package com.codecool.bank.account;

public class CorporateAccount extends Account{
    public CorporateAccount(String clientId, AccountCurrency accountCurrency, double balance) {
        super(clientId, accountCurrency, 0, balance);
    }
}
