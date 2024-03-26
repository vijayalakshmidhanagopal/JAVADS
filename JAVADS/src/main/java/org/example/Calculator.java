package org.example;

public class Calculator {
    public static final Calculator INSTANCE = new Calculator();

    private Calculator() {
    }

    public int power(int base, int exponent) {
        assert exponent >= 0 : "exponent can't be < 0";
        int result = 1;
        for (int i = 0; i < exponent; ++i) {
            result *= base;
        }
        return result;
    }

}



