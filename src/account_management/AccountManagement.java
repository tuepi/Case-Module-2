package account_management;

import data_file.FileCsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
    public static final String PLEASE_SIGN_UP = "MỜI BẠN ĐĂNG NHẬP";
    private List<Account> accounts = new ArrayList<>();
    FileCsv fileCsv = new FileCsv();
    Scanner scanner = new Scanner(System.in);
    
    public static final String USER_FILE_PATH = "C:\\Users\\hongh\\IdeaProjects\\everage_order_management_app\\src\\data_file\\user.csv";

    public AccountManagement() throws Exception {
        fileCsv.readFileAccount(accounts, USER_FILE_PATH);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void login(){
        System.out.println("");
    }

    public void signUp(){
        System.out.println(PLEASE_SIGN_UP);
        System.out.print("Tên đăng nhập: ");
        String userName = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        for (Account a : accounts) {
            if (a.getEmail().equals(email)){
                System.out.println("Email đã được sử dụng!!!\nMời nhập lại");
                signUp();
                break;
            }
        }
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

    }

    public void updateAccount(){
        //chỉnh sửa tên và mật khẩu giữ nguyên email
    }
}
