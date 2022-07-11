package dh.meli.validation.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {
    private double n1, n2;

    public double divider() {
        if (n2 == 0) {
            return 0;
        } else {
            return n1 / n2;
        }


    }
}
