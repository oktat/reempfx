package lan.zold.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lan.zold.models.Employee;
import lan.zold.models.FileHandler;
import lan.zold.models.MainModel;

public class MainController {

    //Első mező id
    @FXML
    private TableColumn<Employee, Integer> idCol;

    //Második mező name
    @FXML
    private TableColumn<Employee, String> nameCol;

    //Harmadik mező city
    @FXML
    private TableColumn<Employee, String> cityCol;

    //Negyedik mező salary
    @FXML
    private TableColumn<Employee, Double> salaryCol;

    //A tábla
    @FXML
    private TableView<Employee> empTable;

    //Most következnek a gombok
    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button saveButton;
    
    @FXML
    public void initialize() {
        //Előkészítjük a TableColumnokat
        idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        cityCol.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        salaryCol.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());

        //Kezeljük az eseményeket
        exitButton.setOnAction(e -> Platform.exit());
        loadButton.setOnAction(e -> {
            MainModel model = new MainModel();        
            ObservableList<Employee> employeeList = 
            FXCollections.observableArrayList(
                model.getEmployeeList()
                );
            empTable.setItems(employeeList);            
        });
        saveButton.setOnAction(e -> {
            Employee employee = empTable.getSelectionModel().getSelectedItem();
            FileHandler fileHandler = new FileHandler();
            fileHandler.w(employee);
        });
    }
}
