package beverage_management;

import account_management.AccountManagement;
import data_file.FileCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    public static final String ORDER_FILE_PATH = "src\\data_file\\order.csv";

    AccountManagement accountManagement = new AccountManagement();

    BeverageManagement beverageManagement = new BeverageManagement();
    FileCsv fileCsv = new FileCsv();

    private List<OrderedBeverage> orderedList = new ArrayList<>();
    private List<OrderedBeverage> orderingList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public OrderManagement() throws Exception {
        // đọc file
    }

    public List<OrderedBeverage> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(List<OrderedBeverage> orderedList) {
        this.orderedList = orderedList;
    }

    public void order() throws IOException {
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
                        if (orderQuanity > 0 && orderQuanity <= beverage.getQuantity()) {
                            String size = null;
                            String type = null;
                            String sweet = null;
                            String answer = null;
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

                            OrderedBeverage orderedBeverage
                                    = new OrderedBeverage(id,beverage.getDrinkName(), beverage.getImage(),
                                    beverage.getPrice(), beverage.getQuantity(), size, orderQuanity, type, sweet, total, accountManagement.getAccount());
                            orderingList.add(orderedBeverage);
                            // add vào list order và vào file gồm tên khách hàng và các thông tin khác
                            System.out.println("Quý Khách vừa thêm vào giỏ sản phẩm:\n\t\t\t" + orderedBeverage);
                            int newQuanity = beverage.getQuantity() - orderQuanity;
                            beverage.setQuantity(newQuanity);
                            fileCsv.writeFileBeverage(beverageManagement.getBeverages(), "src\\data_file\\beverage.csv");
                                do {
                                    System.out.print("Quý Khách có muốn tiếp tục đặt thêm Đồ Uống khác??? (Y/N) >>> ");
                                    answer = sc.nextLine().trim().toLowerCase();
                                    if (answer.equals("y")){
                                        order();
                                    }
                                    if (answer.equals("n")){
                                        System.out.println("Đơn Hàng của Quý Khách: ");
                                        for (OrderedBeverage ob : orderingList) {
                                            System.out.println("\t\t\tSản Phẩm: " + ob);
                                            total += (ob.getPriceBySize() * ob.getOrderQuanity());
                                        }
                                        System.out.println("Tổng Hóa Đơn cần thanh toán là: " + total + "kVNĐ.");
                                        //check thanh toán
                                        //sau thanh toán thì thêm vào list
                                        return;
                                    }
                                } while (!answer.equals("y") && !answer.equals("n"));
                                break;
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
