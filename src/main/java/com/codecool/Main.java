package com.codecool;

import com.codecool.bank.Bank;
import com.codecool.bank.account.Account;
import com.codecool.bank.account.AccountCurrency;
import com.codecool.bank.account.ConsumerAccount;
import com.codecool.client.Client;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();
        Client client5 = new Client();

        bank.addClient(client1);
        bank.addClient(client2);
        bank.addClient(client3);
        bank.addClient(client4);
        bank.addClient(client5);

        Account consumerAccount1 = new ConsumerAccount(client1.getId(), AccountCurrency.EURO,5000);
        Account consumerAccount2 = new ConsumerAccount(client2.getId(), AccountCurrency.EURO,3000);
        Account consumerAccount3 = new ConsumerAccount(client3.getId(), AccountCurrency.EURO,1000);
        Account corporateAccount1 = new ConsumerAccount(client4.getId(), AccountCurrency.EURO,15000);
        Account corporateAccount2 = new ConsumerAccount(client5.getId(), AccountCurrency.EURO,25000);

        client1.addAccount(consumerAccount1);
        client2.addAccount(consumerAccount2);
        client3.addAccount(consumerAccount3);
        client4.addAccount(corporateAccount1);
        client5.addAccount(corporateAccount2);

        client5.transferMoney(corporateAccount2,consumerAccount1,3000);
        client2.transferMoney(consumerAccount2,consumerAccount3,500);
        client3.transferMoney(consumerAccount3,consumerAccount3,500);
        bank.validateTransfers();
        bank.displayTransferReports();
    }
}