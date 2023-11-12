package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.StringJoiner;

public class GradeBookApp extends Application {
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField courseField;
	private ComboBox<String> gradeComboBox;
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private TableView<Student> tableView = new TableView<>();

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

        // Define columns for the TableView
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Student, String> courseColumn = new TableColumn<>("Course");
        TableColumn<Student, String> gradeColumn = new TableColumn<>("Grade");

        // Set cell value factories for each column
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().courseProperty());
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());

        // Add columns to the TableView
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, courseColumn, gradeColumn);

        // Add form elements to the main layout
        mainLayout.getChildren().addAll(
                new Label("First Name:"), firstNameField,
                new Label("Last Name:"), lastNameField,
                new Label("Course:"), courseField,
                new Label("Grade:"), gradeComboBox,
                clearButton,
                viewGradesButton,
                saveButton,
                tableView
        );

        // Set actions for buttons
        clearButton.setOnAction(event -> clearForm(firstNameField, lastNameField, courseField, gradeComboBox));
        viewGradesButton.setOnAction(event -> viewGrades());
        saveButton.setOnAction(event -> saveGrade(firstNameField.getText(), lastNameField.getText(), courseField.getText(), gradeComboBox.getValue()));

        // Create the scene
        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearForm(TextField firstNameField, TextField lastNameField, TextField courseField, ComboBox<String> gradeComboBox) {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.setValue(null);
    }

    private void viewGrades() {
        tableView.setItems(students);
    }

    private void saveGrade(String firstName, String lastName, String course, String grade) {
        if (validateInput(firstName, lastName, course, grade)) {
            Student student = new Student(firstName, lastName, course, grade);
            students.add(student);
            writeToFile(student);
            clearForm(firstNameField, lastNameField, courseField, gradeComboBox);
        } else {
            // Handle invalid input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
        }
    }

    private boolean validateInput(String firstName, String lastName, String course, String grade) {
        return !firstName.isEmpty() && !lastName.isEmpty() && !course.isEmpty() && grade != null;
    }

    private void writeToFile(Student student) {
        try (FileWriter writer = new FileWriter("grades.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            StringJoiner joiner = new StringJoiner(",");
            joiner.add(student.getFirstName());
            joiner.add(student.getLastName());
            joiner.add(student.getCourse());
            joiner.add(student.getGrade());

            bufferedWriter.write(joiner.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
