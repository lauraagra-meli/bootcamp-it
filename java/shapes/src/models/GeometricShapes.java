package models;// Classes abstratas

import interfaces.Show;

public abstract class GeometricShapes {
    private int x, y;
    public Show show;

    public GeometricShapes(Show show) {
        this.show = show;
    }

    public abstract void position(); // metodos nao tem chaves, apenas a declaracao
    //public abstract double areaCalculate();
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
