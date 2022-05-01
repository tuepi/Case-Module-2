package beverage_management;

public class Beverage {
    private int id;
    private String drinkName;
    private String image;
//    private boolean size;
    private double price;
    private int quantity;
//    private boolean type; // nóng - lạnh
//    private boolean sweet; // ngọt - không ngọt
    private String status; // còn - hết

    public Beverage() {
    }

    public Beverage(String drinkName, String image, double price, int quantity) {
        this.drinkName = drinkName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Beverage(String drinkName, String image,boolean size, double price, int quantity, boolean type, boolean sweet, String status) {
        this.drinkName = drinkName;
        this.image = image;
//        this.size = size;
        this.price = price;
        this.quantity = quantity;
//        this.type = type;
//        this.sweet = sweet;
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

//    public boolean isSize() {
//        return size;
//    }

//    public void setSize(boolean size) {
//        this.size = size;
//    }

    public double getPrice() {
        return price;
    }

//    public double getPriceBySize() {
//        if (isSize()){
//            return this.price;
//        } else {
//            return this.price * 1.5;
//        }
//    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public boolean isType() {
//        return type;
//    }
//
//    public void setType(boolean type) {
//        this.type = type;
//    }
//
//    public String getType(){
//        if (isType()){
//            return "Lạnh";
//        } return "Nóng";
//    }

//    public boolean isSweet() {
//        return sweet;
//    }
//
//    public void setSweet(boolean sweet) {
//        this.sweet = sweet;
//    }
//
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

    //    public String printO

    @Override
    public String toString() {
        return "Đồ Uống {"
                + id + ", "
                + drinkName + ", "
                + image + ", "
                + price + ", "
                + quantity + ", "
//                + getType() + ", "
//                + getSweet() + ", "
                + getStatus() +
                '}';
    }
}
