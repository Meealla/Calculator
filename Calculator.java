import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input){
        String[] array = input.split(" ");
            if (input.matches(".*[IVX].*") & input.matches(".*\\d.*")) {
                throw new IllegalArgumentException("введены арабские и римские");
            }
            else if(array.length >3){
                throw  new IllegalArgumentException();
            }
            int num1;
            int num2;
            try {
                num1 = convertToNumber(array[0]);
                num2 = convertToNumber(array[2]);

                if ((num1 < 1 || num1 > 10) || (num2 < 2 || num2 > 10)) {
                    throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Диапазон чисел должен быть от 1 до 10 включительно");
            }
            char operation = array[1].charAt(0);
            int result;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    if ((input.matches(".*[IVX].*")& num1<num2)){
                        throw new IllegalArgumentException("отрицательный результат I-V");

                    }
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new IllegalArgumentException("на ноль делить нельзя");

                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("неверный символ");



            }

            if (input.matches(".*[IVX].*")) {
                if (result<=0){
                    throw new ArithmeticException("неверная операция");
                }
                return "результат " + IntegerToRoman(result);

            } else {
                return "результат " + (result);
            }
        }


    public static int convertToNumber(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            if (input.equals("I")) return 1;
            else if (input.equals("II")) return 2;
            else if (input.equals("III")) return 3;
            else if (input.equals("IV")) return 4;
            else if (input.equals("V")) return 5;
            else if (input.equals("VI")) return 6;
            else if (input.equals("VII")) return 7;
            else if (input.equals("VIII")) return 8;
            else if (input.equals("IX")) return 9;
            else if (input.equals("X")) return 10;
            else throw new IllegalArgumentException();
        }

    }

    public static String IntegerToRoman(int number) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                builder.append(symbols[i]);


            }
        }
        return builder.toString();

    }
}
