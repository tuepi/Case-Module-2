package beverage_management;

import write_read_file.FileCsv;
import exception_error.ExceptionHandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BeverageManagement {

    public static final String BEVERAGE_FILE_PATH = "src\\data_file\\beverage.csv";
    public static final String MILK_TEA_IMAGE = "\uD83E\uDDCB";
    public static final String CAFE_IMAGE = "☕";
    public static final String JUICE_IMAGE = "\uD83C\uDF79";
    public static final String COCKTAILS_IMAGE = "🍸";
    public static final String SMOOTHIE_IMAGE = "\uD83E\uDD5B";



    private List<Beverage> beverages = new ArrayList<>();
    FileCsv fileCsv = new FileCsv();
    ExceptionHandling exceptionHandling = new ExceptionHandling();
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
        String image = insertImage();
        double price = exceptionHandling.checkInputOfDouble("Nhập Giá Đồ Uống: ");
        int quanity = exceptionHandling.checkInputOfInteger("Nhập Số Lượng: ");

        return new Beverage(drinkName, image, price, quanity);
    }

    public String insertImage(){
        String image = null;
        System.out.println("Chọn Kiểu Đồ Uống:");
        System.out.println("1. Cafe\t\t2. Trà Sữa\t\t3. Nước trái cây\t\t4. Sinh Tố\t\t5. Cocktails");
        int choice;
        do {
            choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn >>> ");
            switch (choice) {
                case 1:
                    image = CAFE_IMAGE;
                    break;
                case 2:
                    image = MILK_TEA_IMAGE;
                    break;
                case 3:
                    image = JUICE_IMAGE;
                    break;
                case 4:
                    image = SMOOTHIE_IMAGE;
                    break;
                case 5:
                    image = COCKTAILS_IMAGE;
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 đến 5 !!!");
            }
        } while (choice < 1 || choice > 5);
        return image;
    }

    public void addBeverage() throws IOException {
        Beverage beverage = creatBeverage();
        beverage.setId(beverages.size() + 1);
        beverages.add(beverage);
        fileCsv.writeFileBeverage(beverages, BEVERAGE_FILE_PATH);
        System.out.println("---------------------------------");
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
        int id = exceptionHandling.checkInputOfInteger("Nhập ID Sản Phẩm muốn thay đổi: ");
        int index = findById(id);
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
        int id = exceptionHandling.checkInputOfInteger("Nhập ID Sản Phẩm muốn xóa: ");
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

    public void findBeverageByName() {
        System.out.print("Nhập Tên Sản Phẩm muốn tìm kiếm: ");
        String name = scanner.nextLine().toLowerCase();
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

    public void updateStatusByQuanity() throws Exception {
        int id = exceptionHandling.checkInputOfInteger("Nhập ID Sản Phẩm cần chỉnh sửa >>> ");
        int index = findById(id);
        if (index != -1) {
            int newQuanity = exceptionHandling.checkInputOfInteger("Số lượng Sản Phẩm mới là: ");
            beverages.get(index).setQuantity(newQuanity);
            fileCsv.writeFileBeverage(beverages, BEVERAGE_FILE_PATH);
            fileCsv.readFileBeverage(beverages, BEVERAGE_FILE_PATH);
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
        List<Beverage> sortedBeverages = beverages;
        Collections.sort(sortedBeverages);

        for (Beverage b : sortedBeverages) {
            System.out.println(b);
        }
    }

}
