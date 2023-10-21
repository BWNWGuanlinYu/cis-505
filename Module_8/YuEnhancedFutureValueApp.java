//@author Guanlin Yu

package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YuEnhancedFutureValueApp extends Application {
    private ComboBox<Integer> cbYears;
    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private TextArea txtResults;
    private Label lblFutureValueDate;

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

        cbYears = new ComboBox<>();
        for (int year = 0; year <= 500; year++) {
            cbYears.getItems().add(year);
        }

        txtMonthlyPayment = new TextField();
        txtInterestRate = new TextField();

        Button btnCalculate = new Button("Calculate");
        Button btnClear = new Button("Clear");

        lblFutureValueDate = new Label();
        txtResults = new TextArea();
        txtResults.setWrapText(true);
        txtResults.setEditable(true);
        txtResults.setMaxWidth(250);
        txtResults.setMaxHeight(150);

        // Set button actions (event handlers)
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

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
        pane.add(cbYears, 1, 3);
        pane.add(lblFutureValueDate, 0, 4);
        pane.add(txtResults, 0, 5, 2, 1);

        // Create an HBox for buttons and set its properties
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);

        // Add the HBox to the GridPane with positioning
        pane.add(actionBtnContainer, 1, 4);

        // Set the primary stage's title
        primaryStage.setTitle("Yu Enhanced Future Value App");

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    }

    private void calculateResults() {
        double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
        double rate = Double.parseDouble(txtInterestRate.getText());
        int years = cbYears.getValue();

        double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, rate, years);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(new Date());

        lblFutureValueDate.setText("Calculation as of " + currentDate);
        txtResults.setText("The future value is " + futureValue);
    }
}
