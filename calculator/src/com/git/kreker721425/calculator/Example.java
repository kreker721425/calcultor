package com.git.kreker721425.calculator;

import com.git.kreker721425.calculator.exception.IntervalException;

public class Example {

    private String firstNumber;

    private String secondNumber;

    private final String operation;

    public Example(String firstNumber, String secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public String getResult(){
        firstNumber = firstNumber.replaceAll("\\s+","");
        secondNumber = secondNumber.replaceAll("\\s+","");

        try {

            //Калькулятор для римских чисел
            RomanNumerals firstRomanNumeral = RomanNumerals.valueOf(firstNumber);
            RomanNumerals secondRomanNumeral = RomanNumerals.valueOf(secondNumber);
            switch (operation){
                case "\\*":
                    return RomanNumerals.getRomanNumeralByArabicNumeral(firstRomanNumeral.getArabicNumeral() * secondRomanNumeral.getArabicNumeral());
                case "\\+":
                    return RomanNumerals.getRomanNumeralByArabicNumeral(firstRomanNumeral.getArabicNumeral() + secondRomanNumeral.getArabicNumeral());
                case "-":
                    return RomanNumerals.getRomanNumeralByArabicNumeral(firstRomanNumeral.getArabicNumeral() - secondRomanNumeral.getArabicNumeral());
                case "/":
                    return RomanNumerals.getRomanNumeralByArabicNumeral(firstRomanNumeral.getArabicNumeral() / secondRomanNumeral.getArabicNumeral());
            }
        }
        catch (IllegalArgumentException eIAE){
            try {

                //Калькулятор для арабских чисел

                if (Integer.parseInt(firstNumber) > 10 || Integer.parseInt(secondNumber) > 10)
                    throw new IntervalException();
                switch (operation){
                    case "\\*":
                        return Integer.toString(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                    case "\\+":
                        return Integer.toString(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
                    case "-":
                        return Integer.toString(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
                    case "/":
                        return Integer.toString(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
                }
            }
            catch (NumberFormatException eNFE) {
                return "ERROR: Вводите только числа!";
            }
            catch (IntervalException eIE) {
                System.out.println(eIE.toString());
            }
        }
        return "";
    }
}
