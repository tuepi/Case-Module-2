package account_management;

import data_file.FileCsv;
import validate.DetailValidate;
import validate.ValidateAll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
    public static final String PLEASE_SIGN_UP = "MỜI BẠN ĐĂNG NHẬP";
    public static final String USER_FILE_PATH = "src\\data_file\\user.csv";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    public static final String NOT_VALID_EMAIL_MESSAGE = "Nhập Email chưa đúng định dạng!!!\nYêu cầu nhập lại theo dạng (username@main.com) >>> ";
    public static final String NOT_VALID_PASS_MESSAGE =
            "Nhập Password chưa đúng định dạng!!!\n" +
                    "Nhập lại Mật khẩu theo yêu cầu sau:\n" +
                    "[Tối thiểu 8 ký tự gồm chữ hoa, chữ thường, ký tự số và ký tự đặc biệt]>>>";

    private List<Account> accounts = new ArrayList<>();

    FileCsv fileCsv = new FileCsv();
    ValidateAll validateAll = new ValidateAll();
    Scanner scanner = new Scanner(System.in);


    public AccountManagement() throws Exception {
        fileCsv.readFileAccount(accounts, USER_FILE_PATH);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void login() {
        System.out.println("Mời bạn Đăng Nhập >>>");
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập Mật Khẩu: ");
        String password = scanner.nextLine();
        if (email.equals("tue688i3@gmail.com") && password.equals("TranDinhTue3#")) {
            System.out.println("XIN CHÀO ÔNG CHỦ Nhà Hàng \u2615PITEU\uD83C\uDF79\"");
            // HIỂN THỊ MÀN HÌNH QUẢN LÝ
        } else {
            for (Account ac : accounts) {
                if (ac.getEmail().equals(email) && ac.getPassword().equals(password)) {
                    System.out.println("---------------------------------");
                    System.out.println(">>>ĐĂNG NHẬP THÀNH CÔNG<<<");
                    System.out.println("---------------------------------");
                    System.out.println("Chào mừng " + ac.getUserName() + " đến với Nhà Hàng \u2615PITEU\uD83C\uDF79\"");
                    //hiển thị màn hình order
                } else {
                    System.out.println("---------------------------------");
                    System.out.println("ĐĂNG NHẬP THẤT BẠI!!!");
                    System.out.println("---------------------------------");
                    // check y thì login() còn n thì thoát ra menu đăng nhập đăng kí
                    login();
                }
            }
        }
    }

    public void signUp() throws IOException {
        System.out.println(PLEASE_SIGN_UP);
        System.out.print("Nhập Tên Tài Khoản: ");
        String userName = scanner.nextLine();
        boolean checkEmail = false;
        String email = null;
        while (checkEmail == false) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            checkEmail = validateAll.validate(new DetailValidate(EMAIL_REGEX, NOT_VALID_EMAIL_MESSAGE), email);
            for (Account a : accounts) {
                if (a.getEmail().equals(email)) {
                    System.out.println("Email đã được sử dụng!!!\nMời nhập lại");
                } else {
                    break;
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
                //hiển thị menu đăng nhập
                break;
            }
        }
    }

    public void updateAccount() {
        //chỉnh sửa tên và mật khẩu giữ nguyên email

    }

}
