package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GradeBookApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GradeBookApp");

        // Create a layout for the main scene
        VBox mainLayout = new VBox(10);

        // Create form elements
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField courseField = new TextField();
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "E", "F");
        Button clearButton = new Button("Clear");
        Button viewGradesButton = new Button("View Grades");
        Button saveButton = new Button("Save");

        // Create a TableView to display the saved grade entries
        TableView<String> gradesTableView = new TableView<>();

        // Define columns for the TableView
        TableColumn<String, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<String, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<String, String> courseColumn = new TableColumn<>("Course");
        TableColumn<String, String> gradeColumn = new TableColumn<>("Grade");
        gradesTableView.getColumns().addAll(firstNameColumn, lastNameColumn, courseColumn, gradeColumn);

        // Add form elements to the main layout
        mainLayout.getChildren().addAll(
            new Label("First Name:"),
            firstNameField,
            new Label("Last Name:"),
            lastNameField,
            new Label("Course:"),
            courseField,
            new Label("Grade:"),
            gradeComboBox,
            clearButton,
            viewGradesButton,
            saveButton,
            gradesTableView
        );

        // Create the scene
        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
