package beverage_management;

import account_management.AccountManagement;
import data_file.FileCsv;
import exception_error.ExceptionHandling;

import java.io.IOException;
import java.net.PortUnreachableException;
import java.util.*;

public class OrderManagement {
    public static final String ORDER_FILE_PATH = "src\\data_file\\order.csv";
    public static final int FIRST_CHOICE = 1;
    public static final int SECOND_CHOICE = 2;
    public static final int THIRD_CHOICE = 3;
    public static final int FOURTH_CHOICE = 4;

    Scanner sc = new Scanner(System.in);
    ExceptionHandling exceptionHandling = new ExceptionHandling();
    AccountManagement accountManagement = new AccountManagement();
    BeverageManagement beverageManagement = new BeverageManagement();
    FileCsv fileCsv = new FileCsv();

    private List<OrderedBeverage> orderedList = new ArrayList<>();
    private List<OrderedBeverage> orderingList = new ArrayList<>();

    public OrderManagement() throws Exception {
        orderedList = fileCsv.readFileOrder(orderedList, ORDER_FILE_PATH);
    }

    public List<OrderedBeverage> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(List<OrderedBeverage> orderedList) {
        this.orderedList = orderedList;
    }

    public void order() throws IOException {
        do {
            int id = exceptionHandling.checkInputOfInteger("Nhập ID Sản Phẩm mà bạn muốn đặt hàng: ");
            int index = beverageManagement.findById(id);
            if (index != -1) {
                Beverage beverage = beverageManagement.getBeverages().get(index);
                if (beverage.getQuantity() != 0) {
                    System.out.println("Sản Phẩm Quý Khách chọn: " + beverage + " còn " + beverage.getQuantity() + " sản phẩm.");
                    do {
                        int orderQuanity = exceptionHandling.checkInputOfInteger("Nhập số lượng: ");
                        if (orderQuanity > 0 && orderQuanity <= beverage.getQuantity()) {
                            String size = selectionSize();
                            String type = selectionType();
                            String sweet = selectionSweet();
                            String answer;
                            double total = 0;

                            OrderedBeverage orderedBeverage
                                    = new OrderedBeverage(id, beverage.getDrinkName(), beverage.getImage(),
                                    beverage.getPrice(), size, type, sweet, orderQuanity, total, accountManagement.getAccount());
                            orderingList.add(orderedBeverage);
                            System.out.println("Đã thêm vào đơn hàng sản phẩm:\n\t\t" + orderedBeverage);
                            int newQuanity = beverage.getQuantity() - orderQuanity;
                            beverage.setQuantity(newQuanity);
                            fileCsv.writeFileBeverage(beverageManagement.getBeverages(), "src\\data_file\\beverage.csv");
                            do {
                                System.out.print("Tiếp tục đặt thêm Đồ Uống khác??? (Y/N) >>> ");
                                answer = sc.nextLine().trim().toLowerCase();
                                if (answer.equals("y")) {
                                    order();
                                }
                                if (answer.equals("n")) {
                                    System.out.println("Đơn Hàng của Quý Khách: ");
                                    for (OrderedBeverage ob : orderingList) {
                                        System.out.println("\t\tSản Phẩm: " + ob);
                                        total += ob.getTotalPrice();
                                    }
                                    System.out.println("\t\tTổng Hóa Đơn cần thanh toán là: " + total + "kVNĐ.");
                                    orderedBeverage.setTotalPrice(total);
                                    orderedList.add(orderedBeverage);
                                    fileCsv.writeFileOrder(orderedList, ORDER_FILE_PATH);
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

    public String selectionSize() {
        String size = null;
        System.out.println("-----------------------------------");
        System.out.println("Chọn size:");
        System.out.println("1. Size M\t\t\t2. Size L");
        int choice = -1;
        do {
            choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn >>> ");
            switch (choice) {
                case FIRST_CHOICE:
                    size = "Size M";
                    break;
                case SECOND_CHOICE:
                    size = "Size L";
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2 !!!");
            }
        } while (choice != 1 && choice != 2);
        return size;
    }

    public String selectionType() {
        String type = null;
        System.out.println("-----------------------------------");
        System.out.println("Chọn Kiểu:");
        System.out.println("1. Nóng\t\t\t2. Lạnh");
        int choiceOfType = -1;
        do {
            choiceOfType = exceptionHandling.checkInputOfInteger("Nhập lựa chọn >>> ");
            switch (choiceOfType) {
                case FIRST_CHOICE:
                    type = "Nóng";
                    break;
                case SECOND_CHOICE:
                    type = "Lạnh";
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2 !!!");
            }
        } while (choiceOfType != 1 && choiceOfType != 2);
        return type;
    }

    public String selectionSweet() {
        String sweet = null;
        System.out.println("-----------------------------------");
        System.out.println("Chọn Độ Ngọt:");
        System.out.println("1. Không Ngọt\t\t\t2. 30% Đường\t\t\t3. 50% Đường\t\t\t4. 70% Đường");
        int choiceOfSweet = -1;
        do {
            choiceOfSweet = exceptionHandling.checkInputOfInteger("Nhập lựa chọn >>> ");
            switch (choiceOfSweet) {
                case FIRST_CHOICE:
                    sweet = "Không Ngọt";
                    break;
                case SECOND_CHOICE:
                    sweet = "30% Đường";
                    break;
                case THIRD_CHOICE:
                    sweet = "50% Đường";
                    break;
                case FOURTH_CHOICE:
                    sweet = "70% Đường";
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 >>> 4 !!!");
            }
        } while (choiceOfSweet < 1 || choiceOfSweet > 4);
        return sweet;
    }

    public void payment() {
        int choice = -1;
        try {
            do {
                System.out.println("Chọn phương thức Thanh Toán: ");
                System.out.println("1. Thanh Toán bằng tiền mặt.");
                System.out.println("2. Thanh Toán qua ví điện tử.");
                System.out.println("3. Thanh Toán bằng thẻ Ngân hàng.");
                choice = exceptionHandling.checkInputOfInteger("Nhập lựa chọn >>> ");
                switch (choice) {
                    case FIRST_CHOICE:
                        System.out.println("Xác Nhận Giao Hàng :");
                        break;
                    case SECOND_CHOICE:
                        System.out.println("--------------------------------");
                        System.out.println("Quý Khách chưa có vé điện tử\nNhập 1 để trả tiền mặt đi nhé !!!");
                        System.out.println("--------------------------------");
                        payment();
                        break;
                    case THIRD_CHOICE:
                        System.out.println("--------------------------------");
                        System.out.println("Tài khoản của Quý Khách làm gì còn tiền\nNhập 1 để trả tiền mặt đi nhé !!!");
                        System.out.println("--------------------------------");
                        payment();
                        break;
                    default:
                        System.out.println("Nhập lại lựa chọn:");
                }
            } while (choice < 1 || choice > 3);
        } catch (NumberFormatException n) {
            System.out.println("Nhập lại lựa chọn:");
            payment();
        }
    }


    public void printOrderedMany() {
        ////////////////
    }


    public void totalRevenue() {
        double total = 0;
        for (OrderedBeverage ob : getOrderedList()) {
            total += ob.getTotalPrice();
        }
        System.out.println("Tổng Doanh Thu: " + total + " kVNĐ");
    }

    public void printAllOrdered() {
        for (OrderedBeverage ob : getOrderedList()) {
            System.out.println(ob);
        }
    }

    public void printByAccount() {
        int count = 0;
        for (OrderedBeverage o : orderedList) {
            if (accountManagement.getAccount().getUserName().equals(o.getAccount().getUserName())) {
                count++;
                System.out.println("Đơn Hàng thứ " + count + ":");
                System.out.println(o);
            }
        }
        if (count == 0) {
            System.out.println("Quý Khách chưa có đơn hàng nào!!!");
        }
        System.out.println("-----------------------------------");
    }


}
