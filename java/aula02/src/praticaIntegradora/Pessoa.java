package praticaIntegradora;

public class Pessoa {
    private String nome;
    private int idade;
    private String id;
    private double peso;
    private double altura;
    private double resultado;

    public Pessoa() {

    }

    public Pessoa(String nome, int idade, String id) {

    }

    public Pessoa(String nome, int idade, String id, double peso, double altura) {
        setId(id);
        setNome(nome);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0 && idade < 150) {
            this.idade = idade;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() <= 6) {
            this.id = id;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    public double calcularIMC() {
        resultado = peso/(Math.pow(altura, 2));

        if (resultado < 20) {
            return -1;
        }
        if (resultado >= 20 && resultado <= 25) {
            return 0;
        }
        if (resultado > 25) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean ehMaiorIdade() {
        if (idade >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String resposta;
        resposta = id + " " +
                "nome: " + nome +
                ", idade: " + idade +
                ", peso: " + peso +
                ", altura: " + altura;

        return resposta;
    }
}
