package com.codecool.bank.account;

import com.codecool.bank.TransferReport;
import com.codecool.bank.TransferStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    private String id;
    private String clientId;
    private AccountCurrency accountCurrency;
    private double wireFee;

    private double balance;

    private List<TransferReport> pendingTransfers;
    private List<TransferReport>acceptedTransfers;
    private List<TransferReport>rejectedTransfers;
    public Account(String clientId, AccountCurrency accountCurrency, double wireFee, double balance) {
        this.id = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.accountCurrency = accountCurrency;
        this.wireFee = wireFee;
        this.balance = balance;
        this.pendingTransfers = new ArrayList<>();
        this.acceptedTransfers = new ArrayList<>();
        this.rejectedTransfers = new ArrayList<>();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addPendingTransfer(TransferReport transferReport){
        if (transferReport.getTransferStatus() == TransferStatus.PENDING){
            pendingTransfers.add(transferReport);
        }
    }
    public void addAcceptedTransfer(TransferReport transferReport){
        if (transferReport.getTransferStatus() == TransferStatus.ACCEPTED){
            acceptedTransfers.add(transferReport);
        }
    }
    public void addRejectedTransfer(TransferReport transferReport){
        if (transferReport.getTransferStatus() == TransferStatus.REJECTED){
            rejectedTransfers.add(transferReport);
        }
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public AccountCurrency getAccountCurrency() {
        return accountCurrency;
    }

    public double getWireFee() {
        return wireFee;
    }

    public double getBalance() {
        return balance;
    }

    public List<TransferReport> getPendingTransfers() {
        return pendingTransfers;
    }

    public List<TransferReport> getAcceptedTransfers() {
        return acceptedTransfers;
    }

    public List<TransferReport> getRejectedTransfers() {
        return rejectedTransfers;
    }
}
