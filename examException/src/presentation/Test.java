package presentation;

import util.Validator;
import util.StringRule;

import java.util.Scanner;

public class Test {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("------------MENU----------------");
            System.out.println("1. Kiểm tra định dạng số nguyên");
            System.out.println("2. Kiểm tra định dạng số float");
            System.out.println("3. Kiểm tra định dạng số double");
            System.out.println("4. Kiểm tra định dạng kiểu boolean");
            System.out.println("5. Kiểm tra định dạng kiểu String");
            System.out.println("6. Kiểm tra định dạng Email");
            System.out.println("7. Kiểm tra định dạng Số điện thoại");
            System.out.println("8. Thoát");

            choice = Validator.validateInputInt(scanner, "Chọn: ");

            switch (choice) {
                case 1:
                    int intValue = Validator.validateInputInt(scanner, "Nhập vào kiểu số nguyên:");
                    System.out.println("Số nguyên hợp lệ: " + intValue);
                    break;

                case 2:
                    float floatValue = Validator.validateInputFloat(scanner, "Nhập vào kiểu float:");
                    System.out.println("Số float hợp lệ: " + floatValue);
                    break;

                case 3:
                    double doubleValue = Validator.validateInputDouble(scanner, "Nhập vào kiểu double:");
                    System.out.println("Số double hợp lệ: " + doubleValue);
                    break;

                case 4:
                    boolean boolValue = Validator.validateInputBoolean(scanner, "Nhập giá trị true/false:");
                    System.out.println("Giá trị Boolean hợp lệ: " + boolValue);
                    break;

                case 5:
                    int min, max;
                    System.out.println("Nhập giới hạn ký tự:");
                    min = Validator.validateInputInt(scanner, "Bắt đầu từ:");
                    max = Validator.validateInputInt(scanner, "Đến:");

                    String inputString = Validator.validateInputString(scanner, "Nhập vào 1 chuỗi có giới hạn:", new StringRule(min, max));
                    System.out.println("Chuỗi hợp lệ: " + inputString);
                    break;

                case 6:
                    String email = Validator.validateEmail(scanner, "Nhập email:");
                    System.out.println("Email hợp lệ: " + email);
                    break;

                case 7:
                    String phone = Validator.validatePhone(scanner, "Nhập số điện thoại:");
                    System.out.println("Số điện thoại hợp lệ: " + phone);
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 8);
    }
}
