package com.seniorglez.cobid;


import com.seniorglez.cobid.model.DataLine;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CovidCYL extends Application {

    private TableView<DataLine> table = new TableView<DataLine>();
    private final ObservableList<DataLine> lines = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(800);
        stage.setHeight(600);

        final Label label = new Label("Datos Cobid CYL");
        label.setFont(new Font("Arial", 20));
        table.setPrefWidth(760);

        retrieveData();
        table.setEditable(true);
        //fecha;provincia;casos_confirmados;nuevos_positivos;altas;fallecimientos;codigo_ine;Posicion
        TableColumn date = new TableColumn("Fecha");
        date.setCellValueFactory(new PropertyValueFactory<DataLine,String>("date"));
        TableColumn provincia = new TableColumn("Provincia");
        provincia.setCellValueFactory(new PropertyValueFactory<DataLine,String>("provincia"));
        TableColumn confirmedCases = new TableColumn("Casos Confirmados");
        confirmedCases.setCellValueFactory(new PropertyValueFactory<DataLine,String>("confirmedCases"));
        TableColumn newPositives = new TableColumn("Nuevos Positivos");
        newPositives.setCellValueFactory(new PropertyValueFactory<DataLine,String>("newPositives"));
        TableColumn discharged = new TableColumn("Altas");
        discharged.setCellValueFactory(new PropertyValueFactory<DataLine,String>("discharged"));
        TableColumn deaths = new TableColumn("Fallecimientos");
        deaths.setCellValueFactory(new PropertyValueFactory<DataLine,String>("deaths"));
        TableColumn ineCode = new TableColumn("Código ine");
        ineCode.setCellValueFactory(new PropertyValueFactory<DataLine,String>("ineCode"));
        TableColumn position = new TableColumn("Posición");
        position.setCellValueFactory(new PropertyValueFactory<DataLine,String>("position"));

        table.setItems(lines);
        table.getColumns().addAll(date,provincia,confirmedCases,newPositives,discharged,deaths,ineCode,position);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }

    private void retrieveData() {
        URL dataSource = null;
        DataLine dataLine;
        try {
            dataSource = new URL("https://datosabiertos.jcyl.es/web/jcyl/risp/es/salud/situacion-epidemiologica-coronavirus/1284940407131.csv");
            BufferedReader in = new BufferedReader(new InputStreamReader(dataSource.openStream()));
            String inputLine;
            in.readLine();//skips the csv header
            while ((inputLine = in.readLine()) != null) {
                String[]data = inputLine.split(";");
                dataLine = new DataLine(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]);
                lines.add(dataLine);
            };
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}