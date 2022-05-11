package account_management;

import beverage_management.OrderedBeverage;
import write_read_file.FileCsv;
import exception_error.ExceptionHandling;
import validate.DetailValidate;
import validate.ValidateAll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
    public static final String PLEASE_SIGN_UP = "MỜI BẠN ĐĂNG KÝ >>> ";
    public static final String USER_FILE_PATH = "src\\data_file\\user.csv";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    public static final String NOT_VALID_EMAIL_MESSAGE = "Nhập Email chưa đúng định dạng!!!\nYêu cầu nhập lại theo dạng (username@main.com) >>> ";
    public static final String NOT_VALID_PASS_MESSAGE =
            """
                    Nhập Password chưa đúng định dạng!!!
                    Nhập lại Mật khẩu theo yêu cầu sau:
                    [Tối thiểu 8 ký tự gồm chữ hoa, chữ thường, ký tự số và ký tự đặc biệt] >>>\s""";
    public static final int FIRST_CHOICE = 1;
    public static final int SECOND_CHOICE = 2;
    public static final int THIRD_CHOICE = 3;

    private List<Account> accounts = new ArrayList<>();

    FileCsv fileCsv = new FileCsv();
    ValidateAll validateAll = new ValidateAll();
    ExceptionHandling exceptionHandling = new ExceptionHandling();
    OrderedBeverage orderedBeverage = new OrderedBeverage();
    public static Account account;
    Scanner scanner = new Scanner(System.in);

    public Account getAccount() {
        return account;
    }

    public AccountManagement() throws Exception {
        fileCsv.readFileAccount(accounts, USER_FILE_PATH);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int login() {
        System.out.println("MỜI BẠN ĐĂNG NHẬP >>>");
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập Mật Khẩu: ");
        String password = scanner.nextLine();

        int count = 0;
        if (email.equals("tue688i3@gmail.com") && password.equals("TranDinhTue3#")) {
            System.out.println("---------------------------------");
            System.out.println("KÍNH CHÀO ÔNG CHỦ Nhà Hàng \u2615PITEU\uD83C\uDF79\"");
            System.out.println("---------------------------------");

            count = 1;
        } else {
            for (Account ac : accounts) {
                if (ac.getEmail().equals(email) && ac.getPassword().equals(password)) {
                    count = -1;
                    System.out.println("---------------------------------");
                    System.out.println(">>>ĐĂNG NHẬP THÀNH CÔNG<<<");
                    System.out.println("---------------------------------");
                    System.out.println("Chào mừng " + ac.getUserName() + " đến với Nhà Hàng \u2615PITEU\uD83C\uDF79\"");
                    System.out.println("---------------------------------");
                    account = new Account(ac.getUserName(), email, password);
                    orderedBeverage.setAccount(account);
                    break;
                }
            }
            if (count == 0) {
                System.out.println("---------------------------------");
                System.out.println("ĐĂNG NHẬP THẤT BẠI!!!");
                System.out.println("---------------------------------");
            }
        }
        return count;
    }

    public void signUp() throws IOException {
        System.out.println("---------------------------------");
        System.out.println(PLEASE_SIGN_UP);
        System.out.print("Nhập Tên Tài Khoản: ");
        String userName = scanner.nextLine();
        boolean checkEmail = false;
        String email = null;
        while (!checkEmail) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            checkEmail = validateAll.validate(new DetailValidate(EMAIL_REGEX, NOT_VALID_EMAIL_MESSAGE), email);
            for (Account a : accounts) {
                if (a.getEmail().equals(email)) {
                    System.out.println("Email đã được sử dụng!!!\nMời nhập lại");
                    checkEmail = false;
                }
            }
        }
        boolean checkPass = false;
        String password = null;
        while (!checkPass) {
            System.out.print("Nhập Mật Khẩu: ");
            password = scanner.nextLine();
            checkPass = validateAll.validate(new DetailValidate(PASSWORD_REGEX, NOT_VALID_PASS_MESSAGE), password);
        }
        String reEnterPass = null;
        while (password != reEnterPass) {
            System.out.print("Nhập lại Mật Khẩu: ");
            reEnterPass = scanner.nextLine();
            if (password.equals(reEnterPass)) {
                System.out.println("---------------------------------");
                System.out.println(">>>ĐĂNG KÝ THÀNH CÔNG<<<");
                System.out.println("---------------------------------");
                Account account = new Account(userName, email, password);
                accounts.add(account);
                fileCsv.writeFileAccount(accounts, USER_FILE_PATH);
                break;
            }
        }
    }

    public void printThisAccount(){
        System.out.println("---------------------------------");
        System.out.println("Thông tin Tài Khoản của Quý Khách là:");
        System.out.println("Tên Tài Khoản: " + account.getUserName());
        System.out.println("Email: " + account.getEmail());
        System.out.println("Mật Khẩu: " + account.getPassword());
        System.out.println("---------------------------------");
    }

    public void updateAccount() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("Quý Khách muốn chỉnh sửa thông tin nào? ");
        System.out.println("1. Tên Tài Khoản\t\t\t2. Số Điện Thoại\t\t\t3. Mật Khẩu");
        int choice;

        do {
            choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn >>> ");
            switch (choice) {
                case FIRST_CHOICE -> {
                    System.out.println("Chỉnh sửa Tên Tài Khoản thành: ");
                    String newUserName = scanner.nextLine();
                    account.setUserName(newUserName);
                }
                case SECOND_CHOICE -> {
                    System.out.println("Chỉnh sửa Số Điện Thoại thành: ");
                    String newPhoneNumber = scanner.nextLine();
                    account.setPassword(newPhoneNumber);
                }
                case THIRD_CHOICE -> {
                    System.out.println("Chỉnh sửa Mật Khẩu thành: ");
                    String newPass = scanner.nextLine();
                    account.setPassword(newPass);
                }
                default -> {
                    System.out.println("---------------------------------");
                    System.out.println("Nhập lại lựa chọn 1 >>> 3:");
                }
            }
        } while (choice < FIRST_CHOICE || choice > THIRD_CHOICE);
        fileCsv.writeFileAccount(accounts, USER_FILE_PATH);
        System.out.println("---------------------------------");
        System.out.println("ĐÃ SỬA TÀI KHOẢN THÀNH CÔNG!!!");
        System.out.println("---------------------------------");
    }

    public Account findByUserName(String userName){
        int index = findIndexByUserName(userName);
        if (index != -1){
            return accounts.get(index);
        } else {
            System.out.println("Không tìm thấy Tài Khoản!");
            return null;
        }
    }

    public int findIndexByUserName(String userName) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }



//    public void removeAccount() throws IOException {
//        System.out.print("Nhập Tên Khách Hàng muốn xóa Tài Khoản: ");
//        String userName = scanner.nextLine();
//        int index = findIndexByUserName(userName);
//        String answer;
//        if (index != -1) {
//            System.out.println("Bạn chắc chắn muốn xóa Tài Khoản: " + accounts.get(index) + "?");
//            do {
//                System.out.print("Nhập lựa chọn để tiếp tục (Y/N) >>> ");
//                answer = scanner.nextLine();
//                if (answer.equals("y")) {
//                    accounts.remove(index);
//                    fileCsv.writeFileAccount(accounts, USER_FILE_PATH);
//                    System.out.println("ĐÃ XÓA THÀNH CÔNG!!!");
//                    System.out.println("---------------------------------");
//                }
//            } while (!answer.equals("y") && !answer.equals("n"));
//        } else {
//            System.out.println("Không tồn tại Tài Khoản có tên " + userName);
//            System.out.println("---------------------------------");
//        }
//    }

    public void printUsers(){
        System.out.println("Danh Sách Khách Hàng: ");
        for (Account a : accounts) {
            System.out.println("Tên Tài Khoản: " + a.getUserName() + ", Email: " + a.getEmail());
        }
    }

}
