package write_read_file;

import account_management.Account;
import account_management.AccountManagement;
import beverage_management.Beverage;
import beverage_management.OrderedBeverage;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileCsv {

    public List<Beverage> readFileBeverage(List<Beverage> list, String filePath) throws Exception {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            list.clear();
            if (scanner.nextLine() != null) {
                while (scanner.hasNext()) {
                    String out = scanner.nextLine();
                    String[] arr = out.split(",");
                    Beverage beverage = new Beverage(arr[1], arr[2], Double.parseDouble(arr[3]), Integer.parseInt(arr[4]));
                    beverage.setId(list.size() + 1);
                    list.add(beverage);
                }
            } else {
                throw new Exception();
            }
        return list;
    }

    public void writeFileBeverage(List<Beverage> list, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "ID,TÊN,HÌNH MINH HỌA,GIÁ(kVNĐ/Size M),SỐ LƯỢNG,TRẠNG THÁI\n";
        for (Beverage b : list) {
            line += b.getId() + ","
                    + b.getDrinkName() + ","
                    + b.getImage() + ","
                    + b.getPrice() + ","
                    + b.getQuantity() + ","
                    + b.getStatus() + "\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }

    public List<OrderedBeverage> readFileOrder(List<OrderedBeverage> orderedList, String filePath) throws Exception {
        AccountManagement accountManagement = new AccountManagement();
        FileReader fileReader = new FileReader(filePath);
        Scanner scanner = new Scanner(fileReader);
        orderedList.clear();
        if (scanner.nextLine() != null) {
            while (scanner.hasNext()) {
                String out = scanner.nextLine();
                String[] arr = out.split(",");
                Account account = accountManagement.findByUserName(arr[9]);
                OrderedBeverage orderedBeverage = new OrderedBeverage(Integer.parseInt(arr[0]), arr[1], arr[2], Double.parseDouble(arr[3]), arr[4], arr[5], arr[6], Integer.parseInt(arr[7]), Double.parseDouble(arr[8]), account);
                orderedList.add(orderedBeverage);
            }
        } else {
            throw new Exception();
        }
        return orderedList;
    }

    public void writeFileOrder(List<OrderedBeverage> orderedList, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "ID,TÊN,IMAGE,ĐƠN GIÁ(SIZE M),SIZE,KIỂU,ĐỘ NGỌT,SỐ LƯỢNG,TỔNG(kVNĐ),TÊN KHÁCH HÀNG\n";
        for (OrderedBeverage ob : orderedList) {
            line += ob.getId() + ","
                    + ob.getDrinkName() + ","
                    + ob.getImage() + ","
                    + ob.getPrice() + ","
                    + ob.getSize() + ","
                    + ob.getType() + ","
                    + ob.getSweet() + ","
                    + ob.getOrderQuanity() + ","
                    + ob.getTotalPrice() + ","
                    + ob.getAccount().getUserName() + "\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }

    public List<Account> readFileAccount(List<Account> list, String filePath) throws Exception {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            list.clear();
            if (scanner.nextLine() != null) {
                while (scanner.hasNext()) {
                    String out = scanner.nextLine();
                    String[] arr = out.split(",");
                    Account account = new Account(arr[0], arr[1], arr[2]);
                    list.add(account);
                }
            } else {
                throw new Exception();
            }
        return list;
    }

    public void writeFileAccount(List<Account> list, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "TÊN TÀI KHOẢN,EMAIL,MẬT KHẨU\n";
        for (Account a : list) {
            line += a.getUserName() + ","
                    + a.getEmail() + ","
                    + a.getPassword() + "\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }
}


