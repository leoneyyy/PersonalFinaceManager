package com.projekt.personalfinacemanager;

import com.projekt.personalfinacemanager.database.TransaktionDAO;
import com.projekt.personalfinacemanager.helpClasses.CsvImporter;
import com.projekt.personalfinacemanager.model.Transaktion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FinanzManagerApp extends Application {

     public static String filePath = "";
    @Override
    public void start(Stage stage) throws IOException {
       stage.setTitle("Mein Finanzmanager");
        stage.show();
    }

    public static void main(String[] args) {
//        Transaktion testBuchung = new Transaktion( new java.math.BigDecimal("19.99"), "Lebensmittel", java.time.LocalDate.now(), "Ausgabe", null);
        TransaktionDAO dao = new TransaktionDAO();
        dao.loescheAlleTransaktionen();
        ArrayList<Transaktion> liste = dao.zeigeTransaktionen();
        List<Transaktion> alleTransAktionen = CsvImporter.readDataWithCustomSeparator(filePath);
        for (int i = 0; i < alleTransAktionen.size(); i++) {
            dao.speicherTransaktion(alleTransAktionen.get(i));
        }



//        dao.speicherTransaktion(testBuchung);

        launch(args);
    }
}