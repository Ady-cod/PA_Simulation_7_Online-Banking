package com.codecool.bank;

import com.codecool.bank.account.Account;
import com.codecool.client.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    private List<Client> clients;

    public Bank() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }


    public List<Client> getClients() {
        return clients;
    }

    public void validateTransfers(){
        for (Client client : clients){
            for (Account account : client.getAccounts()){
                Iterator<TransferReport> iterator = account.getPendingTransfers().iterator();
                while (iterator.hasNext()){
                    TransferReport transferReport = iterator.next();
                    Account accFrom = transferReport.getAccountFrom();
                    Account accTo = transferReport.getAccountTo();
                    double amount = transferReport.getTransferAmount();
                    double balanceFrom = accFrom.getBalance();
                    double balanceTo = accTo.getBalance();
                    if ( ! accFrom.getClientId().equals(accTo.getClientId())
                            && accFrom.getAccountCurrency().equals(accTo.getAccountCurrency())
                            && accFrom.getBalance()>=(amount + amount * accFrom.getWireFee())){
                        accFrom.setBalance(balanceFrom - (amount + amount * accFrom.getWireFee()));
                        accTo.setBalance(balanceTo + amount);
                        transferReport.setTransferStatus(TransferStatus.ACCEPTED);
                        iterator.remove();  // safe removal
                        accFrom.addAcceptedTransfer(transferReport);

                    } else {
                        transferReport.setTransferStatus(TransferStatus.REJECTED);
                        iterator.remove();  // safe removal
                        accFrom.addRejectedTransfer(transferReport);
                    }
                }
            }
        }
    }
    public void displayTransferReports(){
        System.out.println();
        System.out.println("Here it is the report for the updated transactions in the bank: ");
        System.out.println();
        for (Client client: clients){
            for (Account account : client.getAccounts()){
                System.out.println("There are " + account.getPendingTransfers().size() + " pending transfers" +
                        " for the account with the ID: " + account.getId());
                for (TransferReport transferReport : account.getPendingTransfers()) {
                    String formatted = String.format("Transfer ID: %s, transfer amount: %.2f, transfer currency: %s",
                            transferReport.getTransferId(), transferReport.getTransferAmount(),
                            transferReport.getAccountFrom().getAccountCurrency());
                    System.out.println(formatted);
                }
                System.out.println();
                System.out.println("There are " + account.getAcceptedTransfers().size() + " accepted transfers" +
                        " for the account with the ID: " + account.getId());
                for (TransferReport transferReport : account.getAcceptedTransfers()) {
                    String formatted = String.format("Transfer ID: %s, transfer amount: %.2f, transfer currency: %s",
                            transferReport.getTransferId(), transferReport.getTransferAmount(),
                            transferReport.getAccountFrom().getAccountCurrency());
                    System.out.println(formatted);
                }
                System.out.println();
                System.out.println("There are " + account.getRejectedTransfers().size() + " rejected transfers" +
                        " for the account with the ID: " + account.getId());
                for (TransferReport transferReport : account.getRejectedTransfers()) {
                    String formatted = String.format("Transfer ID: %s, transfer amount: %.2f, transfer currency: %s",
                            transferReport.getTransferId(), transferReport.getTransferAmount(),
                            transferReport.getAccountFrom().getAccountCurrency());
                    System.out.println(formatted);
                }
                System.out.println();
            }
        }
    }
}
