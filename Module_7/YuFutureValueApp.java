//Author: Guanlin Yu

package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;




public class YuFutureValueApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create JavaFX controls
        Label lblMonthlyPayment = new Label("Monthly Payment:");
        Label lblInterestRate = new Label("Interest Rate:");
        Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
        lblInterestRateFormat.setTextFill(Color.RED);
        Label lblYear = new Label("Years:");
        
        
     
        
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        for (int year = 0; year <= 500; year++) {
            yearComboBox.getItems().add(year);
        }

        // Add more labels and controls as needed

        TextField txtMonthlyPayment = new TextField();
        TextField txtInterestRate = new TextField();
        
        // Add more text fields and controls as needed

        Button btnCalculate = new Button("Calculate");
        Button btnClear = new Button("Clear");

        // Set button actions (e.g., event handlers) here

        // Create a GridPane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Add controls to the GridPane with positioning
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);
        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        pane.add(lblYear, 0, 3);
        pane.add(yearComboBox, 1, 3);
        
        // Constructing the TextArea
        TextArea resultTextArea = new TextArea();
        resultTextArea.setWrapText(true);
        resultTextArea.setEditable(true);
        resultTextArea.setMaxWidth(250); 
        resultTextArea.setMaxHeight(150); 
        VBox textAreaContainer = new VBox(resultTextArea);
        textAreaContainer.setAlignment(Pos.CENTER);
        GridPane.setColumnSpan(textAreaContainer, 2);
        pane.add(textAreaContainer, 0, 5);


        // Add more controls to the GridPane and set their positions

        // Create an HBox for buttons and set its properties
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);

        // Add the HBox to the GridPane with positioning
        pane.add(actionBtnContainer, 1, 4);

        // Set the primary stage's title
        primaryStage.setTitle("Yu Future Value App");

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        

        // Show the stage
        primaryStage.show();
    }
}
