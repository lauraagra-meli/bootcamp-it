package praticaIntegradora;

public class PraticaExcecoes {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int result = 0;

        try {
            result = b / a;
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Não pode ser divido por 0.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
