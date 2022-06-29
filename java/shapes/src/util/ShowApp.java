package util;

import interfaces.Show;

public class ShowApp implements Show {

    @Override
    public void show(String msg) {
        System.out.println("na tela: " + msg);
    }
}
