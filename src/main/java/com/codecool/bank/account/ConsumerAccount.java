package com.codecool.bank.account;

public class ConsumerAccount extends Account{
    public ConsumerAccount(String clientId, AccountCurrency accountCurrency, double balance) {
        super(clientId, accountCurrency, 0.01, balance);
    }
}
