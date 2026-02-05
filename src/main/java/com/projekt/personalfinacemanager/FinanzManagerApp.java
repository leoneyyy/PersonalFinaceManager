package com.projekt.personalfinacemanager;

import com.projekt.personalfinacemanager.database.TransaktionDAO;
import com.projekt.personalfinacemanager.model.Transaktion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FinanzManagerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       stage.setTitle("Mein Finanzmanager");
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

        launch(args);
    }
}