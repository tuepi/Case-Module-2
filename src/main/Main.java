package main;

import account_management.Account;
import account_management.AccountManagement;
import beverage_management.Beverage;
import beverage_management.BeverageManagement;
import data_file.FileCsv;
import menu.HandleMenu;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountManagement a = new AccountManagement();
        Account account = new Account();

        FileCsv fileCsv = new FileCsv();
        Beverage beverage = new Beverage();
        BeverageManagement b = new BeverageManagement();
        HandleMenu handleMenu = new HandleMenu();

        handleMenu.showMenuLoginAndSignUp();
//           Beverage bb = b.creatBeverage();
//           b.addBeverage();
//        b.printAll();
//        a.signUp();
//
    }
}
