package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
       Optional<User> tmp = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
       return tmp.orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            Optional<Account> tmp = users.get(user).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
            return tmp.orElse(null);
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcBalance = srcAccount.getBalance();
            double destBalance = destAccount.getBalance();
            srcBalance = srcBalance - amount;
            destBalance = destBalance + amount;
            if (srcBalance >= 0) {
                srcAccount.setBalance(srcBalance);
                destAccount.setBalance(destBalance);
                rsl = true;
            }
        }
        return rsl;
    }

}
