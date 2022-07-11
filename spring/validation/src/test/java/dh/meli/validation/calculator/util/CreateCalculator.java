package dh.meli.validation.calculator.util;

import dh.meli.validation.calculator.Calculator;
import lombok.Data;

@Data
public class CreateCalculator {
    private static double n1 = 4, n2 = 2;

    public static Calculator create() {
        return new Calculator(n1, n2);
    }
}
