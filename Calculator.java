import java.util.Arrays;
import java.util.Scanner;

public class calc {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {


            String input = sc.nextLine();
            String[] array = input.split(" ");
            if (input.matches(".*[IVX].*") & input.matches(".*\\d.*")) {
                throw new IllegalArgumentException("введены арабские и римские");
            }
            if(input.length()>6){
                throw  new IllegalArgumentException();
            }
            int num1;
            int num2;
            try {
                num1 = convertToNumber(array[0]);
                num2 = convertToNumber(array[2]);


            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("диапозон от 1 до 10");

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
                System.out.println("результат " + IntegerToRoman(result));

            } else {
                System.out.println("результат " + result);
            }
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
