package beverage_management;

public class Beverage implements Comparable<Beverage> {
    private int id;
    private String drinkName;
    private String image;
    private String size;
    private double price;
    private int quantity;
    private int orderQuanity;
    private String type; // nóng - lạnh
    private String sweet; // ngọt - không ngọt
    private String status; // còn - hết

    public Beverage() {
    }

    public Beverage(String drinkName, String image, double price, int quantity) {
        this.drinkName = drinkName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

//    public Beverage(int id, String size, int orderQuanity, String type, String sweet){
//        this
//    }


    public Beverage(int id, String size, int orderQuanity, String type, String sweet) {
        this.id = id;
        this.size = size;
        this.orderQuanity = orderQuanity;
        this.type = type;
        this.sweet = sweet;
    }

    public Beverage(int id, String drinkName, String image, String size, double price, int quantity, int orderQuanity, String type, String sweet, String status) {
        this.id = id;
        this.drinkName = drinkName;
        this.image = image;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.orderQuanity = orderQuanity;
        this.type = type;
        this.sweet = sweet;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceBySize() {
        if (this.size.equals("Size M")){
            return this.price;
        } else if (this.size.equals("Size L")){
            return this.price * 1.5;
        } else {
            return 0;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderQuanity() {
        return orderQuanity;
    }

    public void setOrderQuanity(int orderQuanity) {
        this.orderQuanity = orderQuanity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

//    public String getType(){
//        if (isType()){
//            return "Lạnh";
//        } return "Nóng";
//    }


    public void setSweet(String sweet) {
        this.sweet = sweet;
    }

    public String getSweet() {
        return sweet;
    }

//    public String getSweet(){
//        if (isSweet()){
//            return "Ngọt";
//        } return "Không Ngọt";
//    }

    public String getStatus() {
        if (getQuantity() != 0){
            status = "Còn Hàng";
        } else {
            status = "Hết Hàng";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String printOrder() {
        return "Đồ Uống {" +
                "ID = " + id + ", "
                + getDrinkName() + ", "
                + getImage() + ", "
                + size +
                ", Giá: " + getPrice() +
                " kVNĐ/SP, Số Lượng đặt mua: " + orderQuanity +
                " sản phẩm, " + type + ", "
                + sweet + '}';
    }

    @Override
    public String toString() {
        return "Đồ Uống {"
                + "ID = " + id + ", "
                + drinkName + ", "
                + image + ", "
                + price + "kVNĐ, "
//                + quantity + ", "
//                + getType() + ", "
//                + getSweet() + ", "
                + getStatus() +
                '}';
    }

    @Override
    public int compareTo(Beverage o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}
