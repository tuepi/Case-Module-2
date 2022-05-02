package beverage_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    public static final String ORDER_FILE_PATH = "src\\data_file\\order.csv";

    BeverageManagement beverageManagement = new BeverageManagement();
    private List<Beverage> orderedList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public OrderManagement() throws Exception {
    }

    public List<Beverage> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(List<Beverage> orderedList) {
        this.orderedList = orderedList;
    }

    public void order() {
        System.out.println("XIN MỜI ĐẶT HÀNG!!!");
        System.out.print("Nhập ID Sản Phẩm Mà bạn muốn đặt hàng: ");
        int id = Integer.parseInt(sc.nextLine());


    }

    public void printOrderedMany() {

    }

    public void totalQuantitySold() {
//      tổng số đã bán theo order
    }

    public void totalIncome() {
//      tổng thu nhập
    }


    public int calculateThePrice(int quannity, int size) {
        return 0;
    }
}
