package dh.meli.validation.calculator;

import dh.meli.validation.calculator.util.CreateCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() { // antes de rodar o metodo, preciso que crie a calculadora
        //calculator = new Calculator(); // define o objeto
        calculator = CreateCalculator.create();
    }

    @Test
    @DisplayName("To valid parameters different of zero")
    void divider_ReturnValueDouble_WhenParamDifferentZero() {
//        double a = 4; // declara as variaveis
//        double b = 2;
        double expected = CreateCalculator.create().getN1() / CreateCalculator.create().getN2(); // o que espera

        double result = calculator.divider(); // chama o metodo

        Assertions.assertEquals(expected, result); // o que espera e resultado
    }

    @Test
    @DisplayName("To valid parameters equals of zero")
    void divider_ReturnValueDouble_WhenParamEqualZero() {
        Calculator calculator = new Calculator(); // define o objeto
        double a = 4; // declara as variaveis
        double b = 0;
        double expected = 0; // o que espera

        double result = calculator.divider(); // chama o metodo

        Assertions.assertEquals(expected, result); // o que espera e resultado
    }
}