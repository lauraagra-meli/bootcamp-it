package exemplo02;

public class AppClock {
    public static void main(String[] args) {
        Clock clock = new Clock(12, 34, 11); // chamando o construtor

        Clock r2 = new Clock(); // polimorfismo
        Clock r3 = new Clock();
//        clock.hour = 12;
//        clock.minute = 34;
//        clock.second = 11;

        clock.setHour(11);
        clock.setMinute(54);
        clock.setSecond(21);
        clock.showTime();
    }
}
