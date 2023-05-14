package com.codecool.bank;

import com.codecool.bank.account.Account;

import java.util.UUID;

public class TransferReport {
    private String transferId;
    private Account accountFrom;
    private Account accountTo;
    private double transferAmount;

    private TransferStatus transferStatus;

    public TransferReport(Account accountFrom, Account accountTo, double transferAmount) {
        this.transferId = UUID.randomUUID().toString();
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.transferAmount = transferAmount;
        this.transferStatus = TransferStatus.PENDING;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferId() {
        return transferId;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }
}
