package exemplo02;
// Encapsulamento - esconder, pra que determinadas informacoes nao sejam expostas diretamente
// construtores

public class Clock {
    // atributos = caracteristicas
    private int hour;
    private int minute;
    private int second;

    // construtores
    public Clock(int hour, int minute, int second) { // parametros do construtor
        setHour(hour);
        setMinute(minute);
        setSecond(second);

//        this.hour = hour;
//        this.minute = minute;
//        this.second = second;
    }

    // overload - sobrecarga
    public Clock() { // polimorfismo - criando um novo construtor para não precisar passar os 3 parametros

    }

    public Clock(int hour) {
        this.hour = hour;
    }

    // metodos de acesso (getters and setters)

    public void setHour(int hour) {
        if (hour > 0 && hour < 24) {
            this.hour = hour;
        }
    }

    public int getHour() {
        return hour;
    }
    public void  setMinute(int newMinute) {
        if (newMinute > 0 && newMinute < 59) {
            this.minute = newMinute;
        }
    }
    public int getMinute() {
        return minute;
    }

    public void setSecond(int second) {
        if (second > 0 && second < 59) {
            this.second = second;
        }
    }

    public int getSecond() {
        return second;
    }

    // metodos = acoes
    public void showTime() { // void - não retorna nenhuma informacao
        System.out.println(
                  hour + ":" +
                  minute + ":" +
                  second);

    }
}

