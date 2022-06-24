package exemplo04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        double result;

        System.out.println("digite um numero inteiro: ");

        try {
            number = Integer.parseInt(sc.nextLine());
            System.out.println(number);
        } catch (InputMismatchException e) {
            System.out.println("digitacao invalida.");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("valor incorreto.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("erro...");
        } finally { // independente de dar certo ou errado, cai no finally
            System.out.println("fim do programa.");
            sc.close();
        }

    }
}
