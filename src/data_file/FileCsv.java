package data_file;

import account_management.Account;
import beverage_management.Beverage;

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
                Beverage beverage = new Beverage(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), Boolean.parseBoolean(arr[4]), Boolean.parseBoolean(arr[5]), arr[6]);

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
        String title = "TÊN,HÌNH ẢNH,\n";
        for (Beverage b : list) {
            title += b.getId() + ","
                    + b.getDrinkName() + ","
                    + b.getImage() + ","
                    + b.getPrice() + ","
                    + b.getType() + ","
                    + b.getSweet() + ","
                    + b.getStatus() + "\n";
        }
        bufferedWriter.write(title);
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
                Account account = new Account(arr[0],arr[1],arr[2]);

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
        String title = "TÊN ĐĂNG NHẬP,EMAIL,MẬT KHẨU\n";
        for (Account a : list) {
            title += a.getUserName() + ","
                    + a.getEmail() + ","
                    + a.getPassword() + "\n";
        }
        bufferedWriter.write(title);
        bufferedWriter.close();
        fileWriter.close();
    }
}


