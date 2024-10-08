package com.booleanuk.core.idgenerator;

import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.bank.User;
import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.AccountType;
import com.booleanuk.core.transactons.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class IdGeneratorTest {

    @Test
    public void generateMultipleUniqueIds() {
        Bank bank = new Bank();

        User customer1 = bank.createUser("P_#1");
        bank.createUserAccount(customer1, AccountType.CURRENT);
        bank.createUserAccount(customer1, AccountType.SAVINGS);

        ArrayList<Account> accountss1 = customer1.getAllAccounts();
        for (Account a : accountss1) {
            System.out.println(a.getAccountNumber());
        }

        Assertions.assertEquals("AC_1", accountss1.get(0).getAccountNumber());
        Assertions.assertEquals("AC_2", accountss1.get(1).getAccountNumber());

        User customer2 = bank.createUser("P_#1");
        bank.createUserAccount(customer2, AccountType.CURRENT);
        bank.createUserAccount(customer2, AccountType.SAVINGS);

        Assertions.assertEquals("AC_3", customer2.getAllAccounts().get(0).getAccountNumber());
        Assertions.assertEquals("AC_4", customer2.getAllAccounts().get(1).getAccountNumber());
    }

    @Test
    public void generateMultipleUniqueIdsForAnotherBankeShouldHaveOwnIds() {
        Bank bank = new Bank();

        User customer1 = bank.createUser("P_#1");
        bank.createUserAccount(customer1, AccountType.CURRENT);
        bank.createUserAccount(customer1, AccountType.SAVINGS);

        Assertions.assertEquals("AC_1", customer1.getAllAccounts().get(0).getAccountNumber());
        Assertions.assertEquals("AC_2", customer1.getAllAccounts().get(1).getAccountNumber());

        User customer2 = bank.createUser("P_#1");
        bank.createUserAccount(customer2, AccountType.CURRENT);
        bank.createUserAccount(customer2, AccountType.SAVINGS);

        Assertions.assertEquals("AC_3", customer2.getAllAccounts().get(0).getAccountNumber());
        Assertions.assertEquals("AC_4", customer2.getAllAccounts().get(1).getAccountNumber());
    }
}
