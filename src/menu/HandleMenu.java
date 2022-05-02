package menu;

import account_management.Account;
import account_management.AccountManagement;
import beverage_management.BeverageManagement;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleMenu {
    Menu menu = new Menu();
    AccountManagement accountManagement = new AccountManagement();
    BeverageManagement beverageManagement = new BeverageManagement();
    Scanner scanner = new Scanner(System.in);

    public HandleMenu() throws Exception {
    }

    public void showMenuLoginAndSignUp() throws Exception {
        System.out.println(menu.loginAndSignUpMenu);
        int choice = -1;
        do {
            try {
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        int check = accountManagement.login();
                        if (check == 1){
                            showMenuManage();
                        }
                        else if (check == -1) {
                            showMenuUser();
                        }
                        break;
                    case 2:
                        accountManagement.signUp();
                        showMenuLoginAndSignUp();
                        break;
                    case 0:
                        System.out.println("CẢM ƠN VÀ HẸN GẶP LẠI!!!");
                        System.exit(0);
                    default:
                        System.out.println("Yêu cầu lựa chọn từ 0 > 2 : ");
                }
            } catch (Exception e) {
                System.out.println("Yêu cầu lựa chọn từ 0 > 2 : ");
            }
        } while (choice < 0 || choice > 2);

    }

    public void showMenuManage() throws Exception {
        System.out.println(menu.managementMenu);
        int choice = -1;
        do {
            try {
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        beverageManagement.printAll();
                        showMenuManage();
                        break;
                    case 2:
                        beverageManagement.addBeverage();
                        showMenuManage();
                        break;
                    case 3:
                        beverageManagement.editBeverage();
                        showMenuManage();
                        break;
                    case 4:
                        beverageManagement.removeBeverage();
                        showMenuManage();
                        break;
                    case 5:

                        break;
                    case 6:
                        System.out.print("Nhập Tên Sản Phẩm muốn tìm kiếm: ");
                        String name = scanner.nextLine().toLowerCase();
                        beverageManagement.findBeverageByName(name);
                        showMenuManage();
                        break;
                    case 7:
                        accountManagement.printUsers();
                        showMenuManage();
                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 0:
                        showMenuLoginAndSignUp();
                        break;
                    default:
                        System.out.println("Yêu cầu lựa chọn từ 0 > 9 : ");
                }
            } catch (Exception e){
                System.out.println("Yêu cầu lựa chọn từ 0 > 9 : ");
            }
        } while (choice < 0 || choice > 9);

    }

    public void showMenuUser() throws Exception {
        System.out.println(menu.userOfMenu);
        int choice1 = -1;
        do {
            System.out.print("Nhập lựa chọn: ");
            choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    System.out.println(menu.orderMenu);

                    break;
                case 2:
                    accountManagement.printThisAccount();
                    showMenuUser();
                    break;
                case 3:
                    accountManagement.updateAccount();
                    showMenuUser();
                    break;
                case 0:
                    showMenuLoginAndSignUp();
                    break;
                default:
                    System.out.println("Yêu cầu lựa chọn từ 0 > 3 : ");
            }
        } while (choice1 < 0 || choice1 > 4);
    }

    public void showMenuOrder() throws Exception {
        int choice = -1;
        do {
            System.out.println(menu.orderMenu);
            System.out.println("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    showMenuUser();
                    break;
                default:

            }
        } while (choice < 0 || choice > 5);


    }
}
