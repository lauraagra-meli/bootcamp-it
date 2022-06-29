package models;

import interfaces.Show;

public class Square extends GeometricShapes {

    public Square(Show show) {
        super(show);
    }
    @Override
    public void position() {
        show.show("models.Square" + getX() + getY());
        //System.out.println("square: "+ getX() + getY());
    }

//    @Override
//    public double areaCalculate() {
//        return 0;
//    }
}
