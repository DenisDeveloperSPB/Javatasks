import java.io.IOException;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws Exception {
        Scanner Keyboard = new Scanner(System.in); // string input
        String FullString;
        FullString = Keyboard.nextLine();
        System.out.println(calc(FullString));
    }

    public static String calc(String input) throws Exception {

        String[] StringPieces = input.split(" "); // string split
        if (StringPieces.length != 3) {
            throw new Exception("Количество параметров неверное, либо параметры не разделены пробелом!");
        }

        int[] ConvertedNumbers;
        ConvertedNumbers = new int[3];

        boolean[] NumberIsDecimal;
        NumberIsDecimal = new boolean[3];

        for (int i = 0; i < 3; i = i + 2) {
            NumberIsDecimal[i] = true;
            try {
                ConvertedNumbers[i] = Integer.parseInt(StringPieces[i]);
            }
            catch (NumberFormatException e) {
                 NumberIsDecimal[i] = false;
                 if (StringPieces[i].equals("I")) {
                     ConvertedNumbers[i] = 1;
                 } else if (StringPieces[i].equals("II")) {
                     ConvertedNumbers[i] = 2;
                 } else if (StringPieces[i].equals("III")) {
                     ConvertedNumbers[i] = 3;
                 } else if (StringPieces[i].equals("IV")) {
                     ConvertedNumbers[i] = 4;
                 } else if (StringPieces[i].equals("V")) {
                     ConvertedNumbers[i] = 5;
                 } else if (StringPieces[i].equals("VI")) {
                     ConvertedNumbers[i] = 6;
                 } else if (StringPieces[i].equals("VII")) {
                     ConvertedNumbers[i] = 7;
                 } else if (StringPieces[i].equals("VIII")) {
                     ConvertedNumbers[i] = 8;
                 } else if (StringPieces[i].equals("IX")) {
                     ConvertedNumbers[i] = 9;
                 } else if (StringPieces[i].equals("X")) {
                     ConvertedNumbers[i] = 10;
                 } else {
                     throw new Exception("Числа должны быть от 1 до 10, состоять из арабских или римских цифр!");
                 }
            }
        } // for-loop

        int ResultInteger = 0;
        if (NumberIsDecimal[0] != NumberIsDecimal[2]) {
            throw new Exception("Оба числа должны состоять или из арабских, или из римских цифр!");
        } else if (StringPieces[1].equals("+")) {
            ResultInteger = ConvertedNumbers[0] + ConvertedNumbers[2];
        } else if (StringPieces[1].equals("-")) {
            ResultInteger = ConvertedNumbers[0] - ConvertedNumbers[2];
        } else if (StringPieces[1].equals("*")) {
            ResultInteger = ConvertedNumbers[0] * ConvertedNumbers[2];
        } else if (StringPieces[1].equals("/")) {
            ResultInteger = ConvertedNumbers[0] / ConvertedNumbers[2];
        } else {
            throw new Exception("Знак операции должен быть +, -, * или /!");
        }

        int Digits10 = ResultInteger / 10;
        int Digits1  = ResultInteger - (Digits10 * 10);
        String AnswerStringPart1 = "";
        String AnswerStringPart2 = "";

        if (NumberIsDecimal[0] == true) {
            return String.valueOf(ResultInteger); // return result of operation with integer numbers
        } else if (ResultInteger <= 0) {
            throw new Exception("Число, состоящее из римских цифр, может быть только положительным!");
        } else if (ResultInteger == 100) {
            return "C";                           // return "C" if result is Roman 100
        } else {
            if (Digits10 == 1) {
                AnswerStringPart1 = "X";
            } else if (Digits10 == 2) {
                AnswerStringPart1 = "XX";
            } else if (Digits10 == 3) {
                AnswerStringPart1 = "XXX";
            } else if (Digits10 == 4) {
                AnswerStringPart1 = "XL";
            } else if (Digits10 == 5) {
                AnswerStringPart1 = "L";
            } else if (Digits10 == 6) {
                AnswerStringPart1 = "LX";
            } else if (Digits10 == 7) {
                AnswerStringPart1 = "LXX";
            } else if (Digits10 == 8) {
                AnswerStringPart1 = "LXXX";
            } else if (Digits10 == 9) {
                AnswerStringPart1 = "XC";
            }

            if (Digits1 == 1) {
                AnswerStringPart2 = "I";
            } else if (Digits1 == 2) {
                AnswerStringPart2 = "II";
            } else if (Digits1 == 3) {
                AnswerStringPart2 = "III";
            } else if (Digits1 == 4) {
                AnswerStringPart2 = "IV";
            } else if (Digits1 == 5) {
                AnswerStringPart2 = "V";
            } else if (Digits1 == 6) {
                AnswerStringPart2 = "VI";
            } else if (Digits1 == 7) {
                AnswerStringPart2 = "VII";
            } else if (Digits1 == 8) {
                AnswerStringPart2 = "VIII";
            } else if (Digits1 == 9) {
                AnswerStringPart2 = "IX";
            }
            return AnswerStringPart1 + AnswerStringPart2;
        } // if else
    } // static calc

} // class main