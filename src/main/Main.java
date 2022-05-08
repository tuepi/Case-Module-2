package main;

import account_management.Account;
import account_management.AccountManagement;
import beverage_management.Beverage;
import beverage_management.BeverageManagement;
import beverage_management.OrderManagement;
import data_file.FileCsv;
import menu.HandleMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BeverageManagement b = new BeverageManagement();
        AccountManagement a = new AccountManagement();
        Account account = new Account();

        FileCsv fileCsv = new FileCsv();
        Beverage beverage = new Beverage();

        HandleMenu handleMenu = new HandleMenu();
        OrderManagement orderManagement = new OrderManagement();

//orderManagement.printOrderedMany();
//        fileCsv.readFileOrder(orderManagement.getOrderedList(), "src\\data_file\\order.csv");
//        orderManagement.order();
//        orderManagement.payment();
//            handleMenu.showMenuUser();
//            handleMenu.showMenuManage();
                handleMenu.showMenuLoginAndSignUp();
//a.updateAccount();
//                   b.creatBeverage();
//           b.addBeverage();
//        fileCsv.readFileBeverage(b.getBeverages(),"src\\data_file\\beverage.csv");💜
//        b.printAll();
//        b.editBeverage();
//        b.removeBeverage();
//        b.printAll();
//        a.printUsers();
//        a.removeAccount();
//        a.printUsers();

//        orderManagement.printByAccount();
//        b.editBeverage();

//        System.out.println("🍵, ☕, \uD83C\uDF77, \uD83C\uDF77,\uD83C\uDF78 , \uD83E\uDDCB,\uD83E\uDD43, \uD83E\uDD42 , \uD83C\uDF79,\uD83C\uDF78, \uD83C\uDF77");
//🧃, 🧃, 🧋💚❤️🍺🍹🍸🍷🍾🍶🍵☕🥛🍼⌛⏳🎁📞☎️⚠️⛔⤵️↩️0️⃣1️⃣2️⃣3️⃣
        //4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣💲💸💳
    }
}
