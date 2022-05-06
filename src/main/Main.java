package main;

import account_management.Account;
import account_management.AccountManagement;
import beverage_management.Beverage;
import beverage_management.BeverageManagement;
import beverage_management.OrderManagement;
import data_file.FileCsv;
import menu.HandleMenu;

public class Main {
    public static void main(String[] args) throws Exception {
        BeverageManagement b = new BeverageManagement();
        AccountManagement a = new AccountManagement();
        Account account = new Account();

        FileCsv fileCsv = new FileCsv();
        Beverage beverage = new Beverage();

        HandleMenu handleMenu = new HandleMenu();
        OrderManagement orderManagement = new OrderManagement();


//        fileCsv.readFileOrder(orderManagement.getOrderedList(), "src\\data_file\\order.csv");
//        orderManagement.order();
//        orderManagement.payment();
//         handleMenu.showMenuLoginAndSignUp();
         //           Beverage bb = b.creatBeverage();
//           b.addBeverage();
//        fileCsv.readFileBeverage(b.getBeverages(),"src\\data_file\\beverage.csv");
//        b.printAll();
//        b.editBeverage();
//        b.removeBeverage();
//        b.printAll();
//        a.printUsers();
//        a.removeAccount();
//        a.printUsers();

        orderManagement.printOrderedMany();
    }
}
