package com.example.randomfacegenerator;

import java.util.Scanner;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        int userInput = scanner.nextInt();
        System.out.println("Please wait while we generate the faces for you");




        stage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {
            gc.clearRect(0, 0, width, height);
            drawPrimitiveFace();
        }));
        timeline.setCycleCount(userInput);
        timeline.play();

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
        Random randMouthGen = new Random();
        int numberMouths = randMouthGen.nextInt(5);
        //int randomMouth = ;
        gc.setFill(Color.BLACK);
        if (numberMouths == 0) {
            gc.fillOval(280,370,mouthSize,mouthSize);

        } else if (numberMouths == 1) {
            gc.fillArc(280,300,200,100,100, 100, ArcType.ROUND);

        } else if (numberMouths == 2) {
            gc.fillArc(240,350,200,10,100, 100, ArcType.ROUND);

        } else {
            gc.fillArc(250,300,100,50,180, 100, ArcType.ROUND);

        }

    }

    public static void drawEyes() {

        Random randEyesGen = new Random();
        int numberEyes = randEyesGen.nextInt(5);
        gc.setFill(Color.BLACK);

        if (numberEyes == 0) {
            gc.fillOval(220,220,20,20);
            gc.fillOval(360,220,20,20);
        } else if (numberEyes == 1) {
            gc.strokeOval(220,220,50,30);
            gc.strokeOval(340,220,50,30);
            gc.fillOval(235,225,20,20);
            gc.fillOval(355,225,20,20);
        } else if (numberEyes == 2) {
            gc.strokeArc(210,225,50,30,0,-180,ArcType.CHORD);
            gc.strokeArc(330,220,50,30,0,-180,ArcType.CHORD);
            gc.strokeOval(230,240,18,15);
            gc.strokeOval(350,235,18,15);
        } else {
            gc.strokeArc(210,225,50,30,10,-170,ArcType.CHORD);
            gc.strokeArc(330,220,50,30,10,-170,ArcType.CHORD);
            gc.strokeOval(230,240,18,15);
            gc.strokeOval(350,235,18,15);
        }


    }

    public static void drawNose(){

        Random randNoseGen = new Random();
        int numberNose = randNoseGen.nextInt(5);

        if (numberNose == 0) {
            double[] xPoints = {290,310,300};
            double[] yPoints = {280,280,270};
            gc.strokePolygon(xPoints , yPoints , 3);
        } else if (numberNose == 1) {
            double[] xPoints2 = {290,290,285,280,285,290,300,305,310,305,300,300};
            double[] yPoints2 = {270,290,292,294,296,298,298,296,294,292,290,270};
            gc.strokePolygon(xPoints2, yPoints2 , 12);
        } else if (numberNose == 2) {
            double[] xPoints3 = {295,295,290,285,285,290,295,305,310,315,315,310,305,305};
            double[] yPoints3 = {265,285,287,291,293,295,297,297,295,293,291,289,287,267};
            gc.strokePolygon(xPoints3,yPoints3,14);
        } else {
            double[] xPoints4 = {295,295,290,285,285,290,295,305,310,315,315,310,305,305};
            double[] yPoints4 = {265,285,287,291,293,295,297,297,295,293,291,289,287,267};
            gc.strokePolygon(xPoints4,yPoints4,14);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}