package HanYo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.tools.Tool;
import java.awt.*;

public class GUI extends Application { //Extending application, so we can use that entire library.

    //Declareing the variables.
    private Cell[][] matrix;
    private Label label;
    private Game world;
    private Pane root;

    //Setting up the game window.
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Game world = Game.initialize();
        matrix = world.getArrayH();
        updateScene(matrix, root);
        Scene scene = new Scene(root, 640, 480);

        label = new Label("0");
        label.setLayoutX(200);
        root.getChildren().add(label);

        primaryStage.setTitle("Game of JamesBond");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void evolve(Game world, Pane root) {
            matrix = world.getArrayH();
            world.update();
            updateScene(matrix, root);
            String rounds = String.valueOf(world.getRound());
            label.setText(rounds);
        }

    public static void main(String[] args) {
        launch(args);
    }

    private void updateScene(Cell[][] matrix, Pane root) {
    root.getChildren().removeAll();

    int yMax = matrix.length;
    int xMax = matrix[0].length;
    for(int x = 0; x < xMax; x++){
        for(int y = 0; y < yMax; y++){
            double xVal = x * 20 + 20;
            double yVal = y * 20 + 50;

            Paint color;
            if(matrix[x][y].isAlive()) {
                color = Paint.valueOf("RED");
            }else{
                color = Paint.valueOf("WHITE");
            }
            Circle circ = new Circle(xVal, yVal, 6, color);

            if(matrix[x][y].isAlive()) {
                circ.setStrokeType(StrokeType.OUTSIDE);
                circ.setStroke(Color.web("red", 1));
                circ.setStrokeWidth(2);
            }else {
                circ.setStrokeType(StrokeType.OUTSIDE);
                circ.setStroke(Color.web("black", 1));
                circ.setStrokeWidth(2);
            }
            String toolTip = matrix[x][y].toString();
            Tooltip.install(circ, new Tooltip(toolTip));
            root.getChildren().add(circ);

        }

    }
    }
}
