package org.example;

public class Powercalculator {
    public static final Powercalculator INSTANCE = new Powercalculator();

    private Powercalculator() {
    }

    public int calculate(int base, int exponent) {
        assert exponent >= 0 : "exponent can't be < 0";
        int result = 1;
        for (int i = 0; i < exponent; ++i) {
            result *= base;
        }
        return result;
    }

}



