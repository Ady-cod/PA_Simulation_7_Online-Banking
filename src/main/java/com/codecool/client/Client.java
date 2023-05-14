package com.codecool.client;

import com.codecool.bank.TransferReport;
import com.codecool.bank.TransferStatus;
import com.codecool.bank.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private String id;
    private List<Account> accounts;

    public Client() {
        this.id = UUID.randomUUID().toString();
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account){
        accounts.add(account);
    }

    public String getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void transferMoney(Account accountFrom,Account accountTo,int amount){
        TransferReport transferReport = new TransferReport(accountFrom,accountTo,amount);
        accountFrom.addPendingTransfer(transferReport);
    }
}
