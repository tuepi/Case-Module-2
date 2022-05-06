package beverage_management;

import account_management.Account;

public class OrderedBeverage extends Beverage {
    private String size;
    private int orderQuanity;
    private String type;
    private String sweet;
    private double totalPrice;
    private Account account;
    private int totalOrdered;

    public OrderedBeverage() {
    }

    public OrderedBeverage(int id, String drinkName, String image, double price, int totalOrdered) {
        super(id,drinkName, image, price);
        this.totalOrdered = totalOrdered;
    }

    public OrderedBeverage(int id, String drinkName, String image,double price, String size,
                           String type, String sweet, int orderQuanity, double totalPrice, Account account) {
        super(id, drinkName, image, price);
        this.size = size;
        this.type = type;
        this.sweet = sweet;
        this.orderQuanity = orderQuanity;
        this.totalPrice = totalPrice;
        this.account = account;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getOrderQuanity() {
        return orderQuanity;
    }

    public void setOrderQuanity(int orderQuanity) {
        this.orderQuanity = orderQuanity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSweet() {
        return sweet;
    }

    public void setSweet(String sweet) {
        this.sweet = sweet;
    }

    public double getTotalPrice() {
        return getPriceBySize() * getOrderQuanity();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getPriceBySize() {
        if (this.size.equals("Size M")){
            return super.getPrice();
        } else if (this.size.equals("Size L")){
            return super.getPrice() * 1.5;
        } else {
            return 0;
        }
    }

    public int getTotalOrdered() {
        return totalOrdered;
    }

    public void setTotalOrdered(int totalOrdered) {
        this.totalOrdered = totalOrdered;
    }

    public String printOrdered(){
        return getId() + ", " + getTotalOrdered();
    }

    @Override
    public String toString() {
        return "Đồ Uống {" +
                "ID = " + getId() + ", "
                + getDrinkName() + ", "
                + getImage() + ", "
                + size + ", "
                + type + ", "
                + sweet + " , Giá: " + getPriceBySize() + " kVNĐ"
                + "}\n\t\tSố Lượng đặt mua: " + orderQuanity + " sản phẩm, "
                + "Tổng Thanh Toán: " + getTotalPrice() + " kVNĐ, "
                + "Khách Hàng: " + account.getUserName();
    }
}
