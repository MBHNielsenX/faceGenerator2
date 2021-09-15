package com.example.randomfacegenerator;

import java.util.Scanner;
import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        Scanner scanner = new Scanner(System.in);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        System.out.println("Welcome to Random Face Generator");
        System.out.println("How many faces will we be generating today?: ");
        String userInput = scanner.next();
        //if (userInput ==  )


        drawPrimitiveFace();

        stage.show();
    }

    public static void drawPrimitiveFace() {
        drawShape();
        drawMouth(50);
        drawEyes();
        drawNose();
    }

    public static void drawShape() {
        gc.setFill(Color.CRIMSON);
        gc.strokeOval(150, 150, 300, 300);


    }

    public static void drawMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        //gc.fillOval(280,370,mouthSize,mouthSize);
        gc.fillArc(280,300,200,100,100, 100, ArcType.CHORD);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        /*
        gc.fillOval(220,220,20,20);
        gc.fillOval(360,220,20,20);
         */
        /*
        gc.strokeOval(220,220,50,30);
        gc.strokeOval(340,220,50,30);
        gc.fillOval(235,225,20,20);
        gc.fillOval(355,225,20,20);
         */
        //gc.setStroke();

        gc.strokeArc(210,225,50,30,0,-180,ArcType.CHORD);
        gc.strokeArc(330,220,50,30,0,-180,ArcType.CHORD);
        gc.strokeOval(230,240,18,15);
        gc.strokeOval(350,235,18,15);


    }

    public static void drawNose(){
        /*
        double[] xPoints = {290,310,300};
        double[] yPoints = {280,280,270};
        gc.strokePolygon(xPoints , yPoints , 3);
         */

    }

    public static void main(String[] args) {
        launch();
    }
}