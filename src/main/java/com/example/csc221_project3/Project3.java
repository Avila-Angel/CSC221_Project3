package com.example.csc221_project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Project3 extends Application {
    static int x = 500;
    static int y = 500;
    @Override
    public void start(Stage stage) {
        stage.setTitle("Project 3"); // title
        Canvas cv = new Canvas(x, y);
        GraphicsContext gc = cv.getGraphicsContext2D();
        VBox root = new VBox(cv);

        Label label = new Label("Enter a Number"); // new label with title
        label.setFont(Font.font(15)); // font

        TextField input = new TextField(); // new textfield
        input.setMaxWidth(100); // textfield width

        Button button = new Button("Create"); // new button

        root.getChildren().addAll(label, input, button); // get children
        stage.setScene(new Scene(root)); // creates Scene from the group root
        stage.show(); // show stage

        Scanner reader;
        File file =
                new File("/Users/Angel/Documents/Java /Java Projects/CSC221_Project3/src/main/java/com/example/csc221_project3/War and Peace5.txt");
        // File Path
        try { // try this...
            reader = new Scanner(file);
            String text = "";
            while(reader.hasNext()) {
                text+=reader.nextLine().replaceAll("[^a-zA-z]", "").toLowerCase();
            }
            reader.close() ;
            HistogramAlphaBet test = new HistogramAlphaBet(text);
            button.setOnAction(e -> {
                gc.clearRect(0, 0, x, y);
                HistogramAlphaBet.MyPieChart pieChart = test.new MyPieChart(Integer.parseInt(input.getText()), (x<y)? x/4:y/4, new MyPoint (x/2,y/2));
                pieChart.draw(gc);
            });
            // testing:
            //HistogramAlphaBet.MyPieChart pieChart = test.new MyPieChart(4, (x<y)? x/4:y/4, new MyPoint (x/2,y/2));
            //pieChart.draw(gc);

        } catch (FileNotFoundException e) { // catch exception
            System.out.println("Error found"); // prints when error is found
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
