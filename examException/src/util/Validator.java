package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

    public static int validateInputInt(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Không phải số nguyên, yêu cầu nhập lại!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static double validateInputDouble(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Không phải số thực double, yêu cầu nhập lại!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static float validateInputFloat(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Không phải số thực float, yêu cầu nhập lại!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean validateInputBoolean(Scanner scanner, String message) {
        System.out.println(message + " (Nhập true/false)");
        while (true) {
            try {
                String input = scanner.nextLine().trim().toLowerCase();
                if (!input.equals("true") && !input.equals("false")) {
                    throw new InputMismatchException("Không phải giá trị boolean hợp lệ, yêu cầu nhập lại (true/false)!");
                }
                return Boolean.parseBoolean(input);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static String validateInputString(Scanner scanner, String message, StringRule rule) {
        System.out.println(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Không được để trống!");
                }
                if (!rule.isValidString(input)) {
                    throw new IllegalArgumentException("Số lượng ký tự không hợp lệ, yêu cầu nhập lại!");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String validateEmail(Scanner scanner, String message) {
        System.out.println(message);
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException("Không được để trống!");
                }
                if (!pattern.matcher(input).matches()) {
                    throw new InputMismatchException("Email không hợp lệ, yêu cầu nhập lại!");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String validatePhone(Scanner scanner, String message) {
        System.out.println(message);
        String regex = "^(0[35789][0-9]{8})$";

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException("Không được để trống!");
                }
                if (!input.matches(regex)) {
                    throw new InputMismatchException("Số điện thoại không hợp lệ, yêu cầu nhập lại!");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
