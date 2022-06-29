package models;// é obrigatorio implementar o metodo abstrato na classe filha

import interfaces.Show;

public class Circle extends GeometricShapes {

    public Circle(Show show) {
        super(show);
    }

    @Override
    public void position() {
        show.show("models.Circle" + getX() + getY());
        //System.out.println("circle: "+getX() + getY());
    }

//    @Override
//    public double areaCalculate() {
//        return 0;
//    }
}
