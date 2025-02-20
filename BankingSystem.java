import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts;
    private TreeMap<Double, List<String>> sortedAccounts;
    private Queue<String> withdrawalQueue;

    public BankingSystem() {
        this.accounts = new HashMap<>();
        this.sortedAccounts = new TreeMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);
            updateSortedAccounts(accountNumber, oldBalance, newBalance);
        }
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                double oldBalance = accounts.get(accountNumber);
                double newBalance = oldBalance - amount;
                accounts.put(accountNumber, newBalance);
                updateSortedAccounts(accountNumber, oldBalance, newBalance);
                System.out.println("Processed withdrawal of $" + amount + " for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient funds for Account: " + accountNumber);
            }
        }
    }

    private void updateSortedAccounts(String accountNumber, double oldBalance, double newBalance) {
        sortedAccounts.get(oldBalance).remove(accountNumber);
        if (sortedAccounts.get(oldBalance).isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }
        sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<Double, List<String>> entry : sortedAccounts.entrySet()) {
            for (String account : entry.getValue()) {
                System.out.println("Account: " + account + " - Balance: $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("ACC123", 5000);
        bank.addAccount("ACC456", 3000);
        bank.addAccount("ACC789", 7000);

        bank.deposit("ACC123", 1000);
        bank.requestWithdrawal("ACC456");
        bank.requestWithdrawal("ACC789");

        bank.displayAccountsSortedByBalance();
        bank.processWithdrawals(2000);
        bank.displayAccountsSortedByBalance();
    }
}