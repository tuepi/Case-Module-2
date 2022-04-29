package beverage_management;

import data_file.FileCsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeverageManagement {
    private List<Beverage> beverages = new ArrayList<>();
    public static final String BEVERAGE_FILE_PATH = "C:\\Users\\hongh\\IdeaProjects\\everage_order_management_app\\src\\data_file\\beverage.csv";
    public static final String ORDER_FILE_PATH = "C:\\Users\\hongh\\IdeaProjects\\everage_order_management_app\\src\\data_file\\order.csv";

    FileCsv fileCsv = new FileCsv();
    Scanner sc = new Scanner(System.in);

    public BeverageManagement() throws Exception {
        //đọc từ file và add vào list
        fileCsv.readFileBeverage(beverages,BEVERAGE_FILE_PATH);
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }

    public Beverage creatBeverage(){

        return new Beverage();
    }

    public void addBeverage(Beverage beverage){

    }

    public int findById(int id){
        for (int i = 0; i < beverages.size(); i++) {
            if (beverages.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void editBeverage(int id, Beverage beverage){

    }

    public void removeBeverage(int id){

    }

    public void findBeverageByName(String name){

    }

    public void updateStatus(int id){

    }

    public void totalQuantitySold(){

    }

    public void totalIncome(){

    }

    public void printAll(){

    }

    public void printOrderedMany(){

    }

    public void printByUser(){

    }

    public void order(){

    }

    public int calculateThePrice(int quannity, int size){
        return 0;
    }
}
