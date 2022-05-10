package menu;

import account_management.AccountManagement;
import beverage_management.BeverageManagement;
import beverage_management.OrderManagement;
import beverage_management.OrderedBeverage;
import exception_error.ExceptionHandling;

import java.util.Scanner;

public class HandleMenu {
    public static final int EXIT_CHOICE = 0;
    public static final int FIRST_CHOICE = 1;
    public static final int SECOND_CHOICE = 2;
    public static final int THIRD_CHOICE = 3;
    public static final int FOURTH_CHOICE = 4;
    public static final int FIFTH_CHOICE = 5;
    public static final int SIXTH_CHOICE = 6;
    public static final int SEVENTH_CHOICE = 7;
    public static final int EIGHTH_CHOICE = 8;
    public static final int NINTH_CHOICE = 9;
    Menu menu = new Menu();
    ExceptionHandling exceptionHandling = new ExceptionHandling();
    AccountManagement accountManagement = new AccountManagement();
    BeverageManagement beverageManagement = new BeverageManagement();
    OrderManagement orderManagement = new OrderManagement();
    Scanner scanner = new Scanner(System.in);
    String answer;

    public HandleMenu() throws Exception {
    }

    public void showMenuLoginAndSignUp() throws Exception {
        System.out.println(menu.loginAndSignUpMenu);
        int choice = -1;
        do {
            choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn: ");
            switch (choice) {
                case FIRST_CHOICE:
                    checkLogin();
                    break;
                case SECOND_CHOICE:
                    accountManagement.signUp();
                    showMenuLoginAndSignUp();
                    break;
                case EXIT_CHOICE:
                    System.out.println("CẢM ƠN VÀ HẸN GẶP LẠI QUÝ KHÁCH!!!");
                    System.exit(0);
                default:
                    System.out.println("Yêu cầu lựa chọn từ 0 > 2 : ");
            }
        } while (choice < 0 || choice > 2);

    }

    public void checkLogin() throws Exception {
        int check = accountManagement.login();
        if (check == 1) {
            showMenuManage();
        } else if (check == -1) {
            showMenuUser();
        } else {
            do {
                System.out.println("Quý khách muốn tiếp tục đăng nhập (Y/N) ???");
                System.out.print("Nhập lựa chọn >>> ");
                answer = scanner.nextLine();
                if (answer.equals("y")) {
                    checkLogin();
                }
                if (answer.equals("n")) {
                    showMenuLoginAndSignUp();
                }
            } while (!answer.equals("y") && !answer.equals("n"));
        }
    }

    public void showMenuManage() throws Exception {
        int choice;
        do {
            System.out.println(menu.managementMenu);
            choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn: ");
            switch (choice) {
                case FIRST_CHOICE:
                    beverageManagement.printAll();
                    break;
                case SECOND_CHOICE:
                    do {
                        beverageManagement.addBeverage();
                        do {
                            System.out.print("Bạn có muốn tiếp tục thêm (Y/N) >>> ");
                            answer = scanner.nextLine();
                        } while (!answer.equals("y") && !answer.equals("n"));
                    } while (answer.equals("y"));
                    break;
                case THIRD_CHOICE:
                    beverageManagement.editBeverage();
                    break;
                case FOURTH_CHOICE:
                    beverageManagement.removeBeverage();
                    break;
                case FIFTH_CHOICE:
                    beverageManagement.updateStatusByQuanity();
                    break;
                case SIXTH_CHOICE:
                    beverageManagement.findBeverageByName();
                    break;
                case SEVENTH_CHOICE:
                    accountManagement.printUsers();
                    break;
                case EIGHTH_CHOICE:
                    orderManagement.printAllOrdered();
                    break;
                case NINTH_CHOICE:
                    orderManagement.totalRevenue();
                    break;
                case EXIT_CHOICE:
                    showMenuLoginAndSignUp();
                    break;
                default:
                    System.out.println("Yêu cầu lựa chọn từ 0 > 9 : ");
            }
        } while (choice != EXIT_CHOICE);

    }

    public void showMenuUser() throws Exception {
        int choice;
        beverageManagement.printAll();
        do {
            System.out.println(menu.userOfMenu);
            choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn: ");
            switch (choice) {
                case FIRST_CHOICE:
                    beverageManagement.printAll();
                    orderManagement.order();
                    break;
                case SECOND_CHOICE:
                    beverageManagement.sortByPrice();
                    break;
                case THIRD_CHOICE:
                    orderManagement.printOrderedMany();
                    // theo order theo số lượng
                    System.out.println("Chưa có gì đâu thưa quý zị !!!");
                    break;
                case FOURTH_CHOICE:
                    orderManagement.printByAccount();
                    break;
                case FIFTH_CHOICE:
                    beverageManagement.findBeverageByName();
                    break;
                case SIXTH_CHOICE:
                    accountManagement.printThisAccount();
                    break;
                case SEVENTH_CHOICE:
                    accountManagement.updateAccount();
                    break;
                case EXIT_CHOICE:
                    System.out.println("TẠM BIỆT QUÝ KHÁCH");
                    showMenuLoginAndSignUp();
                    break;
                default:
                    System.out.println("Yêu cầu lựa chọn từ 0 > 7 : ");

            }
        } while (choice != EXIT_CHOICE);
    }

}
