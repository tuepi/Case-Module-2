package beverage_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    public static final String ORDER_FILE_PATH = "src\\data_file\\order.csv";

    BeverageManagement beverageManagement = new BeverageManagement();
    private List<Beverage> orderedList = new ArrayList<>();
    private List<Beverage> orderingList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public OrderManagement() throws Exception {
        // đọc file
    }

    public List<Beverage> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(List<Beverage> orderedList) {
        this.orderedList = orderedList;
    }

    public void order() {
        // Sau khi hiển thị danh sách
        do {
            System.out.print("Nhập ID Sản Phẩm mà bạn muốn đặt hàng: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = beverageManagement.findById(id);
            if (index != -1) {
                Beverage beverage = beverageManagement.getBeverages().get(index);
                if (beverage.getQuantity() != 0) {
                    System.out.println("Sản Phẩm Quý Khách chọn: " + beverage + " còn " + beverage.getQuantity() + " sản phẩm.");
                    do {
                        System.out.print("Nhập số lượng: ");
                        int orderQuanity = Integer.parseInt(sc.nextLine());
                        int newQuanity = beverage.getQuantity();
                        if (orderQuanity > 0 && orderQuanity <= beverage.getQuantity()) {
                            beverage.setQuantity(newQuanity = beverage.getQuantity() - orderQuanity);
                            String size = null;
                            String type = null;
                            String sweet = null;
                            String answer ;
                            double total = 0;

                            System.out.println("Chọn size:");
                            System.out.println("1. Size M");
                            System.out.println("2. Size L");
                            int choice = -1;
                            do {
                                System.out.print("Nhập lựa chọn >>> ");
                                choice = Integer.parseInt(sc.nextLine());
                                switch (choice){
                                    case 1:
                                        size = "Size M";
                                        break;
                                    case 2:
                                        size = "Size L";
                                        break;
                                    default:
                                        System.out.println("Vui lòng chọn 1 hoặc 2 !!!");
                                }
                            } while (choice != 1 && choice != 2);

                            System.out.println("Chọn Kiểu:");
                            System.out.println("1. Nóng");
                            System.out.println("2. Lạnh");
                            int choiceOfType = -1;
                            do {
                                System.out.print("Nhập lựa chọn >>> ");
                                choiceOfType = Integer.parseInt(sc.nextLine());
                                switch (choiceOfType){
                                    case 1:
                                        type = "Nóng";
                                        break;
                                    case 2:
                                        type = "Lạnh";
                                        break;
                                    default:
                                        System.out.println("Vui lòng chọn 1 hoặc 2 !!!");
                                }
                            } while (choiceOfType != 1 && choiceOfType != 2);

                            System.out.println("Chọn Độ Ngọt:");
                            System.out.println("1. Không Ngọt");
                            System.out.println("2. Ngọt");
                            int choiceOfSweet = -1;
                            do {
                                System.out.print("Nhập lựa chọn >>> ");
                                choiceOfSweet = Integer.parseInt(sc.nextLine());
                                switch (choiceOfSweet){
                                    case 1:
                                        sweet = "Không Ngọt";
                                        break;
                                    case 2:
                                        sweet = "Ngọt";
                                        break;
                                    default:
                                        System.out.println("Vui lòng chọn 1 hoặc 2 !!!");
                                }
                            } while (choiceOfSweet != 1 && choiceOfSweet != 2);

                            Beverage beverageOrder = new Beverage(id, beverage.getDrinkName(), beverage.getImage(), size, beverage.getPrice(), beverage.getQuantity(), orderQuanity, type, sweet, beverage.getStatus());
                            orderingList.add(beverageOrder);
                            // add vào list order và vào file gồm tên khách hàng và các thông tin khác
                            System.out.println("Quý Khách vừa thêm vào giỏ sản phẩm: " + beverageOrder.printOrder());
                            while (true){
                                System.out.print("Quý Khách có muốn tiếp tục đặt thêm Đồ Uống khác??? (Y/N) >>> ");
                                answer = sc.nextLine().trim().toLowerCase();
                                if (answer.equals("y")){
                                    order();
                                }
                                if (answer.equals("n")){
                                    System.out.println("Đơn Hàng của Quý Khách: ");
                                    for (Beverage b : orderingList) {
                                        System.out.println(" Sản Phẩm: " + b.printOrder());
                                        total += (b.getPriceBySize() * b.getOrderQuanity());
                                    }
                                    System.out.println("Tổng Hóa Đơn cần thanh toán là: " + total + "kVNĐ.");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Số Lượng vừa nhập không hợp lệ!!!\nVui lòng nhập lại >>>");
                        }
                    } while (true);
                } else {
                    System.out.println(beverage);
                    System.out.println("Rất tiếc!!! Sản Phẩm Quý Khách chọn đã hết hàng!!!\nVui lòng nhập lại >>>");
                }
            } else {
                System.out.println("Không tồn tại đồ uống có ID = " + id + "\nVui lòng nhập lại >>>");
            }
        } while (true);

        // Số lượng đặt hàng >>>  count của List ++;
        // size
        //type nóng lạnh
        //sweet ngọt không ngọt
        // hiển thị giá (Hiển thị đơn hàng)
        // yêu cầu thanh toán
    }

    public void printOrderedMany() {
        // dựa vào count của list
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
