package exemplo01;
// Classes - definicao e instancia

public class AppBook {
    public static void main(String[] args) {
        Book book1; // definicao de livro
        book1 = new Book(); // intancia de livro

        Book book2 = new Book();

        book1.name = "Programando em Java";
        book1.author = "Deitel";

        book2.name = "Banco de Dados SQL";
        book2.author = "Marcos Silva";

        System.out.println(book1.name);
        System.out.println(book1.author);
        System.out.println(book2.name);
        System.out.println(book2.author);
    }
}
