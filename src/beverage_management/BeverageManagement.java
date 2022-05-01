package beverage_management;

import data_file.FileCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BeverageManagement {

    public static final String BEVERAGE_FILE_PATH = "src\\data_file\\beverage.csv";
    public static final String ORDER_FILE_PATH = "src\\data_file\\order.csv";
    // từ order ddeerr làm gì???
    FileCsv fileCsv = new FileCsv();
    private List<Beverage> beverages = new ArrayList<>();


    Scanner sc = new Scanner(System.in);

    public BeverageManagement() throws Exception {
        beverages = fileCsv.readFileBeverage(beverages, BEVERAGE_FILE_PATH);
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }

    public Beverage creatBeverage() {

        System.out.println("Nhập thông tin Đồ Uống mới:");
        System.out.print("Nhập tên Đồ Uống: ");
        String drinkName = sc.nextLine();
        System.out.print("Chèn Hình Ảnh: ");
        String image = sc.nextLine();
        boolean check = false;
        double price = 0;
        int quanity = 0;
        do {
            try {
                System.out.print("Nhập Giá Đồ Uống: ");
                price = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập Số Lượng: ");
                quanity = Integer.parseInt(sc.nextLine());
                check = true;
            } catch (NumberFormatException i) {
                System.out.println("Nhập sai định dạng");

            }
        } while (!check);
        return new Beverage(drinkName, image, price, quanity);
    }

    public void addBeverage() throws IOException {
        Beverage beverage = creatBeverage();
        beverage.setId(beverages.size() + 1);
        beverages.add(beverage);
        fileCsv.writeFileBeverage(beverages, BEVERAGE_FILE_PATH);
        System.out.println("ĐÃ THÊM ĐỒ UỐNG THÀNH CÔNG!!!");
    }

    public int findById(int id) {
        for (int i = 0; i < beverages.size(); i++) {
            if (beverages.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editBeverage() {
        System.out.print("Nhập ID Sản Phẩm muốn thay đổi: ");
        int id = Integer.parseInt(sc.nextLine());
        int index = findById(id);
        // check xem có muốn sửa k?
        if (index != -1) {
            System.out.println("Sẽ thay đổi đồ uống " + beverages.get(index).getDrinkName());
            Beverage beverage = creatBeverage();
            beverages.set(index, beverage);
            System.out.println("ĐÃ THAY ĐỔI THÀNH CÔNG!!!");
        } else {
            System.out.println("Không tồn tại đồ uống " + beverages.get(index).getDrinkName());
        }
    }

    public void removeBeverage() {
        System.out.print("Nhập ID Sản Phẩm muốn thay đổi: ");
        int id = Integer.parseInt(sc.nextLine());
        int index = findById(id);
        if (index != -1) {
            beverages.remove(index);
            System.out.println("ĐÃ XÓA THÀNH CÔNG!!!");
        } else {
            System.out.println("Không tồn tại !!!");
        }
    }

    public void findBeverageByName(String name) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getDrinkName().contains(name)) {
                System.out.println(b);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy!!!");
        }
    }

    public void updateStatus(int id) {
//     update số lượng chỉnh sửa số lượng
    }

    public void totalQuantitySold() {
//      tổng số đã bán theo order
    }

    public void totalIncome() {
//      tổng thu nhập
    }

    public void printAll() {
        if (beverages.size() != 0) {
            System.out.println("Danh Sách Tất Cả Các Loại Đồ Uống:");
            for (Beverage b : beverages) {
                System.out.println(b);
            }
        } else {
            System.out.println("Danh Sách Trống!!!");
        }
    }

    public void printOrderedMany() {

    }

    public void printByUser() {
//      danh sách mà 1 khách đã mua
    }

    public void order() {

    }

    public int calculateThePrice(int quannity, int size) {
        return 0;
    }

    // hiển thị danh sách khách hàng
    public void printUsers(){

    }
}
