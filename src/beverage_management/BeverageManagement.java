package beverage_management;

import data_file.FileCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BeverageManagement {

    public static final String BEVERAGE_FILE_PATH = "src\\data_file\\beverage.csv";
    public static final String ORDER_FILE_PATH = "src\\data_file\\order.csv";
    // từ order ddeerr làm gì???

    private List<Beverage> beverages = new ArrayList<>();
    FileCsv fileCsv = new FileCsv();
    Scanner scanner = new Scanner(System.in);
    String answer;

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
        String drinkName = scanner.nextLine();
        System.out.print("Chèn Hình Ảnh: ");
        String image = scanner.nextLine();
        boolean check = false;
        double price = 0;
        int quanity = 0;
        do {
            try {
                System.out.print("Nhập Giá Đồ Uống: ");
                price = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập Số Lượng: ");
                quanity = Integer.parseInt(scanner.nextLine());
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
        System.out.println("---------------------------------");
    }

    public int findById(int id) {
        for (int i = 0; i < beverages.size(); i++) {
            if (beverages.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editBeverage() throws IOException {
        System.out.print("Nhập ID Sản Phẩm muốn thay đổi: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findById(id);
        // check xem có muốn sửa k?
        if (index != -1) {
            System.out.println("Sẽ thay đổi đồ uống " + beverages.get(index).getDrinkName());
            Beverage beverage = creatBeverage();
            beverage.setId(beverages.get(index).getId());
            beverages.set(index, beverage);
            fileCsv.writeFileBeverage(beverages, BEVERAGE_FILE_PATH);
            System.out.println("ĐÃ THAY ĐỔI THÀNH CÔNG!!!");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Không tồn tại đồ uống có ID = " + id);
            System.out.println("---------------------------------");
        }
    }

    public void removeBeverage() throws IOException {
        System.out.print("Nhập ID Sản Phẩm muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findById(id);
        if (index != -1) {
            System.out.println("Bạn chắc chắn muốn xóa Sản Phẩm: " + beverages.get(index) + "?");
            do {
                System.out.print("Nhập lựa chọn để tiếp tục (Y/N) >>> ");
                answer = scanner.nextLine();
                if (answer.equals("y")) {
                    beverages.remove(index);
                    fileCsv.writeFileBeverage(beverages, BEVERAGE_FILE_PATH);
                    System.out.println("ĐÃ XÓA THÀNH CÔNG!!!");
                    System.out.println("---------------------------------");
                }
            } while (!answer.equals("y") && !answer.equals("n"));
        } else {
            System.out.println("Không tồn tại đồ uống có ID = " + id);
            System.out.println("---------------------------------");
        }
    }

    public void findBeverageByName(String name) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getDrinkName().toLowerCase().contains(name)) {
                System.out.println("Sản Phẩm cần tìm là: ");
                System.out.println(b);
                System.out.println("---------------------------------");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy Sản Phẩm có tên " + name);
            System.out.println("---------------------------------");
        }
    }

    public void updateStatusByQuanity(int newQuanity) throws IOException {
//     update số lượng chỉnh sửa số lượng
        System.out.print("Nhập ID Sản Phẩm cần chỉnh sửa >>> ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findById(id);
        if (index != -1) {
            System.out.print("Số lượng Sản Phẩm mới là: ");
            newQuanity = Integer.parseInt(scanner.nextLine());
            beverages.get(index).setQuantity(newQuanity);
            fileCsv.writeFileBeverage(beverages, BEVERAGE_FILE_PATH);
            System.out.println("ĐÃ SỬA THÀNH CÔNG!!!");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Không tồn tại đồ uống có ID = " + id);
            System.out.println("---------------------------------");
        }
    }

    public void printAll() {
        if (beverages.size() != 0) {
            System.out.println("Danh Sách Tất Cả Các Loại Đồ Uống:");
            for (Beverage b : beverages) {
                System.out.println(b);
            }
            System.out.println("---------------------------------");
        } else {
            System.out.println("Danh Sách Trống!!!");
            System.out.println("---------------------------------");
        }
    }

    public void sortByPrice(){
        Collections.sort(this.beverages);
    }

    public void printByUser() {
//      danh sách mà 1 khách đã mua

    }


}
