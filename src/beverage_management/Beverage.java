package beverage_management;

public class Beverage implements Comparable<Beverage> {
    private int id;
    private String drinkName;
    private String image;
    private double price;
    private int quantity;
    private String status;

    public Beverage() {
    }

    public Beverage(String drinkName, String image, double price, int quantity) {
        this.drinkName = drinkName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Beverage(int id, String drinkName, String image, double price, int quantity) {
        this.id = id;
        this.drinkName = drinkName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Beverage(int id, String drinkName, String image, double price, int quantity, String status) {
        this.id = id;
        this.drinkName = drinkName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
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

    @Override
    public String toString() {
        return "Đồ Uống {"
                + "ID = " + id + ", "
                + drinkName + ", "
                + image + ", "
                + price + "kVNĐ, "
                + getStatus() +
                '}';
    }

    @Override
    public int compareTo(Beverage o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}
