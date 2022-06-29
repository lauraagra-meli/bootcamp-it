import interfaces.Show;
import models.Circle;
import models.GeometricShapes;
import models.Square;
import util.ShowApp;

public class AppShapes {
    public static void main(String[] args) {
        // models.GeometricShapes f1 = new models.GeometricShapes(); - não pode

        ShowApp ex1 = new ShowApp();

        Circle c1 = new Circle(ex1);
        GeometricShapes f1 = new Circle(ex1);
        GeometricShapes f2 = new Square(ex1);

        Show ex2 = new ShowApp();

        f1.position();
        f2.position();

    }
}
