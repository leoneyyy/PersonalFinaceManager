package com.projekt.personalfinacemanager;

import com.projekt.personalfinacemanager.database.DatabaseConnection;
import com.projekt.personalfinacemanager.database.TransaktionDAO;
import com.projekt.personalfinacemanager.model.Transaktion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        Transaktion testBuchung = new Transaktion( new java.math.BigDecimal("19.99"), "Lebensmittel", java.time.LocalDate.now(), "Ausgabe", null);
        TransaktionDAO dao = new TransaktionDAO();
        ArrayList<Transaktion> liste = dao.zeigeTransaktionen();
        for (int i = 0; i < liste.size(); i++) {
                System.out.println(liste.get(i).toString());
        }

//        dao.speicherTransaktion(testBuchung);


    }
}