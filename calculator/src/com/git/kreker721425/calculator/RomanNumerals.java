package com.git.kreker721425.calculator;

public enum RomanNumerals {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);

    private Integer arabicNumeral;

    RomanNumerals() {}

    RomanNumerals(Integer arabicNumeral) {
        this.arabicNumeral = arabicNumeral;
    }

    public Integer getArabicNumeral() {
        return arabicNumeral;
    }

    public static String getRomanNumeralByArabicNumeral(Integer arabicNumeral) {
        StringBuilder romanNumeral = new StringBuilder();
        while (arabicNumeral > 10) {
            while (arabicNumeral >= 100) {
                romanNumeral.append("C");
                arabicNumeral -= 100;
            }
            while (arabicNumeral >= 90) {
                romanNumeral.append("XC");
                arabicNumeral -= 90;
            }
            while (arabicNumeral >= 50) {
                romanNumeral.append("L");
                arabicNumeral -= 50;
            }
            while (arabicNumeral >= 40) {
                romanNumeral.append("XL");
                arabicNumeral -= 40;
            }
            while (arabicNumeral > 10) {
                romanNumeral.append("X");
                arabicNumeral -= 10;
            }
        }
        if (arabicNumeral > 0) {
            for (RomanNumerals r : RomanNumerals.values()) {
                if (r.getArabicNumeral().equals(arabicNumeral)) {
                    romanNumeral.append(r.name());
                    break;
                }
            }
        }
        return String.valueOf(romanNumeral);
    }
}
