package model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Transaction> transactions;

    public Wallet() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public float getTotalMoney() {
        float totalMoney = 0;
        for (Transaction transaction : transactions) {
            totalMoney += transaction.getAmount();
        }
        return totalMoney;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

